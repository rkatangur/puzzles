package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 424. Longest Repeating Character Replacement
 * 
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2 Output: 4 Explanation: Replace the two 'A's with two
 * 'B's or vice versa. Example 2:
 * 
 * Input: s = "AABABBA", k = 1 Output: 4 Explanation: Replace the one 'A' in the
 * middle with 'B' and form "AABBBBA". The substring "BBBB" has the longest
 * repeating letters, which is 4.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists of only uppercase English letters. 0 <= k <=
 * s.length
 * 
 * @author rkata
 *
 */
public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement solver = new LongestRepeatingCharacterReplacement();
		System.out.println(solver.characterReplacement("ABAB", 2));
		System.out.println(solver.characterReplacement("AABABBA", 1));

	}

	public int characterReplacement(String s, int k) {

		int leftIndex = 0;
		int rightIndex = 0;
		Map<Character, Integer> charsMap = new HashMap<>();
		Integer moreRepeatingCharCount = Integer.MIN_VALUE;
		int subStrLength = Integer.MIN_VALUE;

		while (rightIndex < s.length()) {
			Character charAtRightIdx = s.charAt(rightIndex);
			charsMap.put(charAtRightIdx, charsMap.getOrDefault(charAtRightIdx, 0) + 1);

			if (charsMap.get(charAtRightIdx) > moreRepeatingCharCount) {
				moreRepeatingCharCount = charsMap.get(charAtRightIdx);
			}

			int curSubStrLength = rightIndex - leftIndex + 1;

			while (curSubStrLength - moreRepeatingCharCount > k) {
				// move the left index;
				Character charAtLeftIdx = s.charAt(leftIndex);
				charsMap.put(charAtLeftIdx, charsMap.getOrDefault(charAtLeftIdx, 0) - 1);
				leftIndex++;
				Integer newMoreRepeatingCharCount = Integer.MIN_VALUE;
				for (Map.Entry<Character, Integer> charMapEntry : charsMap.entrySet()) {
					if (charMapEntry.getValue() > newMoreRepeatingCharCount) {
						newMoreRepeatingCharCount = charMapEntry.getValue();
					}
				}
				moreRepeatingCharCount = newMoreRepeatingCharCount;
				curSubStrLength = rightIndex - leftIndex + 1;
			}

			subStrLength = Math.max(subStrLength, rightIndex - leftIndex + 1);
			rightIndex++;
		}

		return subStrLength;
	}

}
