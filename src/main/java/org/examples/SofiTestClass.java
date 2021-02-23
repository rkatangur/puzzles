package org.examples;

public class SofiTestClass {

	// Given a string, find the longest substring which is palindrome
	// "forgeeksskeegfor" -> "geeksskeeg"
	// "babadabba" -> "abba"
	// "thhwerw" -> hh

	// aba
	// abba

	public static String findLongestPalindrome(String word) {

		String longestPalSubStr = null;
		int longPalSubStrLength = -1;

		// substring would be the characters between the left and rightPointers.
		for (int i = 0; i < word.length(); i++) {
			int[] result = isPlandrome(word, i, i);

			// pick the one that is greater between twoSubStrs and also check with the
			// longestPalSubStr.
			if (result[0] == 1 && (result[2] - result[1] - 1) > longPalSubStrLength) {
				longestPalSubStr = word.substring(result[1] + 1, result[2]);
				longPalSubStrLength = longestPalSubStr.length();
			}

			int[] result2 = isPlandrome(word, i, i + 1);
			if (result2[0] == 1 && (result2[2] - result2[1] - 1) > longPalSubStrLength) {
				longestPalSubStr = word.substring(result2[1] + 1, result2[2]);
				longPalSubStrLength = longestPalSubStr.length();
			}
		}

		return longestPalSubStr;
	}

	public static int[] isPlandrome(String str, int leftPointer, int rightPointer) {

		int isPalSubStrFound = 0;
		while (leftPointer >= 0 && rightPointer < str.length()) {
			if (str.charAt(leftPointer) != str.charAt(rightPointer)) {
				break;
			} else {
				isPalSubStrFound = 1;
				leftPointer--;
				rightPointer++;
			}
		}

		return new int[] { isPalSubStrFound, leftPointer, rightPointer };
	}

	public static void main(String[] args) {
//		System.out.println(findLongestPalindrome("forgeeksskeegfor"));
//		System.out.println(findLongestPalindrome("babadabba"));
//		System.out.println(findLongestPalindrome("thhwerw"));
		System.out.println(findLongestPalindrome("abbaabbajkabbaabbaabbaabbazkabbaabbaabbaabbaabbaabbaxy"));
		System.out.println(findLongestPalindrome("aba"));
		System.out.println(findLongestPalindrome(null));

	}

}
