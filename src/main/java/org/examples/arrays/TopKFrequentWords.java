package org.examples.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * 692. Top K Frequent Words Given a non-empty list of words, return the k most
 * frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1: Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"] Explanation: "i" and "love" are the two most frequent
 * words. Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2: Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny",
 * "is", "is"], k = 4 Output: ["the", "is", "sunny", "day"]
 * 
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * Note: You may assume k is always valid, 1 <= k <= number of unique elements.
 * Input words contain only lowercase letters.
 * 
 * Follow up: Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * @author rkata
 *
 */
public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {

		Map<String, Integer> wordsFreqMap = new HashMap<>();
		for (String word : words) {
			wordsFreqMap.putIfAbsent(word, wordsFreqMap.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<Object[]> topStrings = new PriorityQueue<Object[]>(new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				Integer o1Count = (Integer) o1[0];
				Integer o2Count = (Integer) o2[0];
				if (o1Count == o2Count) {
					String o1Str = (String) o1[1];
					String o2Str = (String) o2[1];
					return o1Str.compareTo(o2Str);
				} else {
					return o2Count - o1Count;
				}
			}
		});

		for (Map.Entry<String, Integer> wordFreqEntry : wordsFreqMap.entrySet()) {
			topStrings.offer(new Object[] { wordFreqEntry.getValue(), wordFreqEntry.getKey() });
		}
		
		List<String> results = new ArrayList<String>();
		while (k > 0 && !topStrings.isEmpty()) {
			results.add((String) topStrings.poll()[1]);
		}

		return results;
	}
}
