package org.examples.arrays;

import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		LongestSubstring solver = new LongestSubstring();
//		System.out.println(solver.lengthOfLongestSubstringV2("abcabcbb"));
//		System.out.println(solver.lengthOfLongestSubstringV2("abcbbcbb"));

//		System.out.println(solver.lengthOfLongestSubstring("bbbbb"));
		System.out.println(solver.lengthOfLongestSubstringV2("pwwkew"));
//		System.out.println(solver.lengthOfLongestSubstring(""));

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
