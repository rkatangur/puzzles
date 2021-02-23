package org.examples.arrays;

import java.util.Arrays;

public class LongestPalindromeDP {

	public static void main(String[] args) {
//		String str = "xyabayxj";
//		int midPos = str.length() / 2;
//		System.out.println(longestPalindromeBruteForce("xyabayxj"));
		System.out.println(longestPalindrome("xyabayxj"));
//		System.out.println(longestPalindrome("xyabayxj"));
	}

	// xyabayx
	// If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a
	// palindrome?
	public static String longestPalindrome(String strToEval) {

		int[][] data = new int[strToEval.length()][strToEval.length()];
		int maxLength = 1;
		for (int i = 0; i < strToEval.length(); ++i) {
			data[i][i] = 1;
		}

		int start = 0;
		for (int i = 0; i < strToEval.length() - 1; ++i) {
			if (strToEval.charAt(i) == strToEval.charAt(i + 1)) {
				data[i][i + 1] = 1;
				start = i;
				maxLength = 2;
			}
		}
		int n = strToEval.length();
		// Check for lengths greater than 2.
		// k is length of substring
		for (int k = 3; k <= n; ++k) {

			// Fix the starting index
			for (int i = 0; i < n - k + 1; ++i) {

				// Get the ending index of substring from
				// starting index i and length k
				int j = i + k - 1;

				// checking for sub-string from ith index to
				// jth index iff str.charAt(i+1) to
				// str.charAt(j-1) is a palindrome
				if (strToEval.charAt(i) == strToEval.charAt(j) && data[i + 1][j - 1] == 1) {
					data[i][j] = 1;

					if (k > maxLength) {
						start = i;
						maxLength = k;
						System.out.println("Setting maxlength to " + k+" start "+start);
					}
				}
			}
		}

		int endIndex = (start + maxLength - 1);
		return strToEval.substring(start, endIndex + 1);
	}
//
//	// xyabayx
//	// If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a
//	// palindrome?
//	public static String longestPalindrome(char[] strChars, int midPos) {
//
//		if (midPos <= 0 || midPos >= strChars.length)
//			return null;
//
//		int leftIndex = midPos - 1;
//		int rightIndex = midPos + 1;
//		boolean palSubStrFound = false;
//		while (leftIndex >= 0 && rightIndex < strChars.length) {
//			if (strChars[leftIndex] != strChars[rightIndex]) {
//				break;
//			} else {
//				leftIndex--;
//				rightIndex++;
//				palSubStrFound = true;
//			}
//		}
//
//		String longestPal = null;
//		if (palSubStrFound) {
//			longestPal = new String(Arrays.copyOfRange(strChars, leftIndex + 1, rightIndex - 1));
//		}
//
//		String longestPal1 = longestPalindrome(strChars, leftIndex);
//		if (longestPal1 != null && longestPal1.length() > longestPal.length()) {
//			longestPal = longestPal1;
//		}
//
//		String longestPal2 = longestPalindrome(strChars, rightIndex);
//		if (longestPal2 != null && longestPal2.length() > longestPal.length()) {
//			longestPal = longestPal2;
//		}
//
//		return longestPal;
//	}
//
//	// xyabayx
//	// If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a
//	// palindrome?
//	public static String longestPalindromeBruteForce(String str) {
//		char[] strChars = str.toCharArray();
//		String longestPalindrome = "";
//		for (int i = 0; i < strChars.length; i++) {
//			for (int j = i + 1; j < strChars.length; j++) {
//				if (isPalindrome(strChars, i, j)) {
//					if (j - i + 1 > longestPalindrome.length()) {
//						longestPalindrome = new String(Arrays.copyOfRange(strChars, i, j + 1));
//					}
//				}
//			}
//		}
//		return longestPalindrome;
//	}
//
//	public static boolean isPalindrome(String str) {
//		char[] strChars = str.toCharArray();
//		boolean isPalindrome = true;
//		for (int i = 0, j = strChars.length - 1; i < j; i++, j--) {
//			if (strChars[i] != strChars[j]) {
//				isPalindrome = false;
//			}
//		}
//		return isPalindrome;
//	}
//
//	public static boolean isPalindrome(char[] charArr, int startIndex, int endIndex) {
//		boolean isPalindrome = true;
//		for (int i = startIndex, j = endIndex; i < j; i++, j--) {
//			if (charArr[i] != charArr[j]) {
//				isPalindrome = false;
//			}
//		}
//		return isPalindrome;
//	}

}
