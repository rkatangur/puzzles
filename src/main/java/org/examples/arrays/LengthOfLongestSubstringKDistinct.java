package org.examples.arrays;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {

//	public int lengthOfLongestSubstringKDistinct(String s, int k) {
//
//		int curWinStarIndex = 0;
//
//		int maxSubstrLength = -1;
//		Map<Character, Integer> charCountMap = new HashMap<>();
//
//		for (int i = 0; i < s.length(); i++) {
//			char curChar = s.charAt(i);
//			Integer curCharCount = charCountMap.get(curChar);
//			if (curCharCount == null) {
//				charCountMap.put(curChar, 1);
//			} else {
//				charCountMap.put(curChar, ++curCharCount);
//			}
//
//			if (charCountMap.size() == k) {
//				maxSubstrLength = Math.max(i - curWinStarIndex + 1, maxSubstrLength);
//			} else if (charCountMap.size() > k) {
//				System.out.println(
//						"Num of distinct chars " + charCountMap.size() + " , curWinStarIndex " + curWinStarIndex);
//				while (true) {
//					char charAtWinStartIndex = s.charAt(curWinStarIndex++);
//					Integer charCountAtWinStartIndex = charCountMap.get(charAtWinStartIndex);
//					if (charCountAtWinStartIndex == null) {
//						charCountMap.remove(charAtWinStartIndex);
//					} else {
//						charCountAtWinStartIndex--;
//						if (charCountAtWinStartIndex == 0) {
//							charCountMap.remove(charAtWinStartIndex);
//						} else {
//							charCountMap.put(charAtWinStartIndex, charCountAtWinStartIndex);
//						}
//					}
//
//					if (charCountMap.size() <= k) {
//						break;
//					}
//				}
//
//				System.out.println("Adjusted Index curWinStarIndex " + curWinStarIndex);
//			}
//		}
//
//		return maxSubstrLength;
//	}

	public int lengthOfLongestSubstringKDistinctV2(String s, int k) {

		if (s.length() * k == 0) {
			return 0;
		}

		int curWinStarIndex = 0;
		int maxSubstrLength = 1;

		LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);
			if (charPosMap.containsKey(curChar)) {
				charPosMap.remove(curChar);
			}
			charPosMap.put(curChar, i);

			if (charPosMap.size() == k + 1) {
				Iterator<Map.Entry<Character, Integer>> charPosIte = charPosMap.entrySet().iterator();
				if (charPosIte.hasNext()) {
					curWinStarIndex = charPosIte.next().getValue() + 1;
					charPosIte.remove();
				}
			}

			maxSubstrLength = Math.max(i - curWinStarIndex + 1, maxSubstrLength);
		}

		return maxSubstrLength;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstringKDistinct solver = new LengthOfLongestSubstringKDistinct();
//		System.out.println(solver.lengthOfLongestSubstringKDistinctV2("eceba", 2));
		System.out.println(solver.lengthOfLongestSubstringKDistinctV2("ab", 1));
//			solver.moveZeroesV1(new int[] { 1, 2, 3, 1 });
//			System.out.println(solver.numberToWords(1003));
	}

}
