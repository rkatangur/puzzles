package org.examples.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * TopUrls Container processes the received urls by adding it to
 * linkedBlockingQueue a thread safe data-structure and updating the count to
 * mapped to the URL in the concurrentHashMap.
 * 
 * Have a dedicated cleanup thread that cleansup the structures processing the
 * old entries from the linkedBlockingQueue and decrementing the count in the
 * concurrentHashMap and adding it to the SortedHashSet.
 * 
 * Uses Read and writeLock to synchronize the access to the shared
 * data-structures.
 * 
 * Write lock synchronizes access to the topKUrls sortedSet where at any point
 * only one thread can write or modify the count of the url stored in topKUrls
 * sortedSet. Read lock synchronizes access to the topKUrls sortedSet where
 * there can be multiple reads to the topKUrls sortedSet but no other thread can
 * modify the topKUrls collection.
 * 
 * @author rkata
 *
 */
public class TopUrlsContainer {

	private int intervalInSecs = 300;

	private final LinkedBlockingQueue<Object[]> urls = new LinkedBlockingQueue<Object[]>();
	private final ConcurrentHashMap<String, Integer> urlsMap = new ConcurrentHashMap<String, Integer>();

	// build sortedSet of urls with its count
	private SortedSet<UrlWithCount> topKUrls = new TreeSet<UrlWithCount>(new Comparator<UrlWithCount>() {
		@Override
		public int compare(UrlWithCount o1, UrlWithCount o2) {
			if (o1 != null && o2 != null) {
				String url1 = o1.getUrl();
				int url1AccessedCount = o1.getCount();

				String url2 = o2.getUrl();
				int url2AccessedCount = o2.getCount();

				if (url1AccessedCount == url2AccessedCount) {
					return url1.compareTo(url2);
				} else if (url1AccessedCount < url2AccessedCount) {
					return -1;
				} else {
					return 1;
				}
			} else if (o1 != null && o2 == null) {
				return 1;
			} else {
				return -1;
			}
		}
	});

	private final ReadWriteLock readWriteLock;
	private final Lock readLock;
	private final Lock writeLock;

	public TopUrlsContainer() {
		readWriteLock = new ReentrantReadWriteLock();
		readLock = readWriteLock.readLock();
		writeLock = readWriteLock.writeLock();

		Thread th = new Thread(() -> {
			cleanup();
		});

		th.start();
	}

	public void cleanup() {
		while (true) {
			try {
				cleanupStructures();
				// sleep for 100 to 1000 millis and compute again.
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

	private void cleanupStructures() {
		try {
			writeLock.lock();
			while (!urls.isEmpty()) {
				Object[] obj = urls.peek();
				if (obj != null) {
					// process it
					String url = (String) obj[0];
					long urlAccessedTime = (long) obj[1];
					long elapsedTime = System.currentTimeMillis() - urlAccessedTime;

					if (elapsedTime > intervalInSecs * 1000) {
						// remove it and record the count in the map and priorityQueue
						removeExpiredUrl(url);
						// remove element from the queue
						urls.poll();
					} else {
						// all entries in queue are valid. so nothing to process
						break;
					}
				}
			}
		} finally {
			writeLock.unlock();
		}
	}

	private void removeExpiredUrl(String url) {
		Integer urlCount = urlsMap.get(url);
		if (urlCount != null) {
			// if the Url and the urlCount combination exists in the sortedSet then
			// remove it and decrement the count and add it back to the set.
			UrlWithCount existingObj = new UrlWithCount(url, urlCount);
			topKUrls.remove(existingObj);

			urlCount--;
			if (urlCount == 0) {
				urlsMap.remove(url);
			} else {
				// updating the map with the new count
				urlsMap.put(url, urlCount);

				// Add the new url with the count back to the sortedSet.
				UrlWithCount newUrlObj = new UrlWithCount(url, urlCount);
				topKUrls.add(newUrlObj);
			}
		} else {
			urlsMap.remove(url);
		}
	}

	/**
	 * 
	 * Write lock synchronizes access to the urls, urlsMap, topKUrls sortedSet where no other
	 * thread is reading entries.
	 * 
	 * @param url
	 * @param urlAccessedTime
	 */
	public void add(String url, long urlAccessedTime) {
		// update the map and the sorted tree set of urls with the new count
		try {
			writeLock.lock();
			urls.add(new Object[] { url, urlAccessedTime });
			Integer urlCount = urlsMap.get(url);
			if (urlCount != null) {

				// Remove the existing entry from the sortedSet
				UrlWithCount existinObj = new UrlWithCount(url, urlCount);
				topKUrls.remove(existinObj);

				// record the new UrlWithCount with the updated url and the new count into the
				// map and the sortedSet
				UrlWithCount newObj = new UrlWithCount(url, urlCount++);
				// update the count in the map
				urlsMap.put(url, urlCount);
				// Add the new UrlWithCount entry back to the sortedSet.
				topKUrls.add(newObj);
			}
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 * Read lock synchronizes access to the topKUrls sortedSet where no other thread
	 * is adding entries while a user is getting the topKUrls.
	 * 
	 * @param n
	 * @return
	 */
	public List<String> getTopNUrls(int n) {
		try {
			readLock.lock();
			List<String> results = new ArrayList<String>();
			for (UrlWithCount urlObj : topKUrls) {
				results.add(urlObj.getUrl());
				n--;
				if (n == 0) {
					break;
				}
			}
			return results;
		} finally {
			readLock.unlock();
		}
	}

	private class UrlWithCount {
		private String url;
		private int count;

		public UrlWithCount(String url, int count) {
			super();
			this.url = url;
			this.count = count;
		}

		public String getUrl() {
			return url;
		}

		public int getCount() {
			return count;
		}
	}

}
