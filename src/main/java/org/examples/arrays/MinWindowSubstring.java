package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

	public String minWindow(String s, String t) {

		if (s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> charsMapInTStr = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			Character tChar = t.charAt(i);
			if (charsMapInTStr.containsKey(tChar)) {
				charsMapInTStr.put(tChar, charsMapInTStr.get(tChar) + 1);
			} else {
				charsMapInTStr.put(tChar, 1);
			}
		}

		Map<Character, Integer> matchedCharInSrcStrMap = new HashMap<Character, Integer>();

		String substring = null;
		int l = -1;
		int r = 0;

		for (int i = 0; i < s.length(); i++) {
			char currCharInSrcStr = s.charAt(i);
			if (charsMapInTStr.containsKey(currCharInSrcStr)) {

				if (l == -1) {
					l = i;
					r = i;
				} else {
					r = i;
				}

				charsMapInTStr.get(currCharInSrcStr);
				recordAndIncrementTheCount(matchedCharInSrcStrMap, currCharInSrcStr);

				boolean isFullWindow = isFullWindow(charsMapInTStr, matchedCharInSrcStrMap);

				if (isFullWindow) {
					r = i;
					int numOfWellFormed = matchedCharInSrcStrMap.size();
					
					while (l <= r && numOfWellFormed == charsMapInTStr.size()) {
						char charAtL = s.charAt(l);
						if (matchedCharInSrcStrMap.containsKey(charAtL)) {

							Integer countOfCharAtLPos = matchedCharInSrcStrMap.get(charAtL);
							Integer countOfCharNeeded = charsMapInTStr.get(charAtL);
							
							int newWindowSize = r - l;
							if (substring == null || (newWindowSize + 1) < (substring.length())) {
								substring = s.substring(l, r + 1);
							}

							if (countOfCharAtLPos >= countOfCharNeeded) {
								countOfCharAtLPos--;
							}
							
							l++;
							
							if (countOfCharAtLPos == 0) {
								matchedCharInSrcStrMap.remove(charAtL);
							} else {
								matchedCharInSrcStrMap.put(charAtL, countOfCharAtLPos);
							}
							
							if (countOfCharAtLPos < countOfCharNeeded)
								numOfWellFormed--;

						} else {
							l++;
						}
					}
				}
			}
		}

		if (substring == null) {
			return "";
		}
		return substring;
	}

	private Integer recordAndIncrementTheCount(Map<Character, Integer> matchedCharInSrcStrMap, char currCharInSrcStr) {
		Integer matchedCharCountInSrcStr = matchedCharInSrcStrMap.get(currCharInSrcStr);
		if (matchedCharInSrcStrMap.containsKey(currCharInSrcStr)) {
			matchedCharCountInSrcStr += 1;
		} else {
			matchedCharCountInSrcStr = 1;
		}
		matchedCharInSrcStrMap.put(currCharInSrcStr, matchedCharCountInSrcStr);
		return matchedCharCountInSrcStr;
	}

	private boolean isFullWindow(Map<Character, Integer> charsMapInTStr,
			Map<Character, Integer> matchedCharInSrcStrMap) {
		boolean isFullWindow = true;
		for (Map.Entry<Character, Integer> targetCharEntry : charsMapInTStr.entrySet()) {
			Character targetChar = targetCharEntry.getKey();
			Integer targetCharCount = targetCharEntry.getValue();
			Integer matchedCharCount = matchedCharInSrcStrMap.get(targetChar);
			if (matchedCharCount == null || matchedCharCount < targetCharCount) {
				isFullWindow = false;
				break;
			}
		}
		return isFullWindow;
	}

	public static void main(String[] args) {
		MinWindowSubstring solver = new MinWindowSubstring();
		System.out.println(solver.minWindow("ab", "a"));
		System.out.println(solver.minWindow("ab", "b"));
		System.out.println(solver.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(solver.minWindow("bdab", "ab"));
		System.out.println(solver.minWindow("cabwefgewcwaefgcf", "cae"));
		System.out.println(solver.minWindow("bba", "ab"));
		System.out.println(solver.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));

		System.out.println(solver.minWindow("acbbaca", "aba"));
//		//baca

		System.out.println(solver.minWindow("abcabdebac", "cda")); // "cabd"
	}

}
