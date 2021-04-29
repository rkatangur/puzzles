package org.examples.arrays;

import java.util.LinkedList;

public class HitCounter {

	private LinkedList<Integer> hitsQ = new LinkedList<Integer>();

	/** Initialize your data structure here. */
	public HitCounter() {

	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		hitsQ.push(timestamp);
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int numOfHits = 0;
		for (Integer hitTimestamp : hitsQ) {
			if (hitTimestamp > timestamp) {
				break;
			} else if (timestamp - hitTimestamp < 300) {
				numOfHits++;
			}
		}
		return numOfHits;
	}
}
