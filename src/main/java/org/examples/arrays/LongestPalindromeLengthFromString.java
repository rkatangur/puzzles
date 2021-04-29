package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome Given a string s which consists of lowercase or
 * uppercase letters, return the length of the longest palindrome that can be
 * built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abccccdd" Output: 7 Explanation: One longest palindrome that can
 * be built is "dccaccd", whose length is 7. Example 2:
 * 
 * Input: s = "a" Output: 1 Example 3:
 * 
 * Input: s = "bb" Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000 s consists of lowercase and/or uppercase English
 * letters only.
 * 
 * @author rkata
 *
 */

public class LongestPalindromeLengthFromString {
	public int longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		Map<Character, Integer> mapOfChars = new HashMap<>();
		for (char c : s.toCharArray()) {
			Integer cCount = mapOfChars.get(c);
			if (cCount == null) {
				mapOfChars.put(c, 1);
			} else {
				mapOfChars.put(c, cCount + 1);
			}
		}

		int palindromeLength = 0;
		for (Integer countVal : mapOfChars.values()) {
			int remainder = countVal % 2;
			palindromeLength += countVal / 2 * 2;

			if (palindromeLength % 2 == 0 && remainder == 1) {
				palindromeLength++;
			}
		}

		return palindromeLength;
	}
}
