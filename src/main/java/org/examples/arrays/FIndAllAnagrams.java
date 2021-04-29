package org.examples.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String Given two strings s and p, return an array
 * of all the start indices of p's anagrams in s. You may return the answer in
 * any order.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "cbaebabacd", p = "abc" Output: [0,6] Explanation: The substring
 * with start index = 0 is "cba", which is an anagram of "abc". The substring
 * with start index = 6 is "bac", which is an anagram of "abc". Example 2:
 * 
 * Input: s = "abab", p = "ab" Output: [0,1,2] Explanation: The substring with
 * start index = 0 is "ab", which is an anagram of "ab". The substring with
 * start index = 1 is "ba", which is an anagram of "ab". The substring with
 * start index = 2 is "ab", which is an anagram of "ab".
 * 
 * Constraints:
 * 
 * 1 <= s.length, p.length <= 3 * 104 s and p consist of lowercase English
 * letters.
 * 
 * @author rkata
 *
 */
public class FIndAllAnagrams {

	public List<Integer> findAnagrams(String s, String p) {

		Map<Character, Integer> pCount = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			char pChar = p.charAt(i);
			pCount.put(pChar, pCount.getOrDefault(pChar, 0) + 1);
		}

		List<Integer> results = new ArrayList<>();

		int startIndex = 0;
		int endIndex = 0;
		Map<Character, Integer> sCount = new HashMap<>();

		while (endIndex < s.length()) {
			char curChar = s.charAt(endIndex++);
			if (pCount.containsKey(curChar)) {
				sCount.put(curChar, sCount.getOrDefault(curChar, 0) + 1);
				while (endIndex - startIndex >= p.length()) {

					if (sCount.equals(pCount)) {
						results.add(startIndex);
					}

					char startChar = s.charAt(startIndex++);
					Integer sCharCount = sCount.get(startChar);
					if (sCharCount - 1 == 0) {
						sCount.remove(startChar);
					} else {
						sCount.put(startChar, sCharCount - 1);
					}
				}
			} else {
				startIndex = endIndex;
				sCount.clear();
			}
		}

		return results;
	}

}
