package org.examples.arrays;

/**
 * 567. Permutation in String
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's permutations
 * is the substring of the second string.
 * 
 * Example 1:
 * 
 * Input: s1 = "ab" s2 = "eidbaooo" Output: True Explanation: s2 contains one
 * permutation of s1 ("ba"). Example 2:
 * 
 * Input:s1= "ab" s2 = "eidboaoo" Output: False
 * 
 * Constraints:
 * 
 * The input strings only contain lower case letters. The length of both given
 * strings is in range [1, 10,000].
 * 
 * 
 */
public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {
		int[] s1Hash = new int[27];

		for (int i = 0; i < s1.length(); i++) {
			s1Hash[s1.charAt(i) - 'a'] = s1Hash[s1.charAt(i) - 'a'] + 1;
			;
		}

		int[] s2Hash = new int[27];
		int left = 0;
		int right = 0;
		while (right < s2.length()) {
			char s2Char = s2.charAt(right);
			s2Hash[s2Char - 'a'] += 1;

			if (right - left + 1 > s1.length()) {
				s2Hash[s2.charAt(left++) - 'a'] -= 1;
			}

			if (right - left + 1 == s1.length()) {
				// compare the hash
				boolean hashMatched = true;
				for (int i = 0; i < s1Hash.length; i++) {
					if (s1Hash[i] != s2Hash[i]) {
						hashMatched = false;
						break;
					}
				}

				if (hashMatched) {
					return true;
				}
			}
			right++;
		}

		return false;
	}

}
