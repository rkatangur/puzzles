package org.examples.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc",
 * with the length of 3.
 * 
 * Example 2:
 * 
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length
 * of 1.
 * 
 * Example 3: Input: s = "pwwkew" Output: 3
 * 
 * Explanation: The answer is "wke", with the length of 3. Notice that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Example 4:
 * 
 * Input: s = "" Output: 0
 * 
 * @author rkata
 *
 */
public class LongestSubstrWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstrWithoutRepeatingCharacters solver = new LongestSubstrWithoutRepeatingCharacters();
//		System.out.println(solver.lengthOfLongestSubstringV2("abcabcbb"));
//		System.out.println(solver.lengthOfLongestSubstringV2("abcbbcbb"));

//		System.out.println(solver.lengthOfLongestSubstring("bbbbb"));
//		System.out.println(solver.lengthOfLongestSubstringV2("pwwkew"));
//		System.out.println(solver.lengthOfLongestSubstring(""));

		System.out.println(solver.lengthOfLongestSubstringV3("pwwkew"));
//		System.out.println(solver.lengthOfLongestSubstringV3("abcabcbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}

		if (s.length() <= 1) {
			return s.length();
		}

		char[] sChars = s.toCharArray();
		int subStrLength = 0;
		int subStrstartIndex = 0;
		int subStrEndIndex = 0;
		for (int i = 1; i < sChars.length; i++) {
			subStrEndIndex = i;
			for (int j = subStrstartIndex; j < i; j++) {
				if (sChars[j] == sChars[i]) {
					subStrstartIndex = j + 1;
					break;
				}
			}
			subStrLength = Math.max(subStrLength, subStrEndIndex - subStrstartIndex + 1);
		}

		return subStrLength;
	}

	public int lengthOfLongestSubstringV3(String s) {
		if (s == null) {
			return 0;
		}

		if (s.length() <= 1) {
			return s.length();
		}

		Map<Character, Integer> charCountMap = new HashMap<>();

		int subStrLength = Integer.MIN_VALUE;
		int leftIndex = 0;
		int rightIndex = 0;

		while (leftIndex < s.length() && rightIndex < s.length()) {
			charCountMap.put(s.charAt(rightIndex), charCountMap.getOrDefault(s.charAt(rightIndex), 0) + 1);

			// duplicates are there, move the leftIndex
			while (charCountMap.get(s.charAt(rightIndex)) > 1) {
				charCountMap.put(s.charAt(leftIndex), charCountMap.get(s.charAt(leftIndex)) - 1);
				leftIndex++;
			}

			subStrLength = Math.max(rightIndex - leftIndex + 1, subStrLength);
			rightIndex++;
		}

		return subStrLength;
	}

	public int lengthOfLongestSubstringV2(String s) {
		if (s == null) {
			return 0;
		}

		if (s.length() <= 1) {
			return s.length();
		}

		int subStrLength = 0;
		int subStrstartIndex = 0;
		int subStrEndIndex = 0;

		HashSet<Character> charsSet = new HashSet<Character>();
		while (subStrEndIndex < s.length()) {
			if (!charsSet.contains(s.charAt(subStrEndIndex))) {
				charsSet.add(s.charAt(subStrEndIndex));
				subStrLength = Math.max(subStrLength, charsSet.size());
				subStrEndIndex++;
			} else {
				charsSet.remove(s.charAt(subStrstartIndex));
				subStrstartIndex++;
			}
		}

		return subStrLength;
	}

}
