package org.examples.arrays;

import java.util.Arrays;

public class LongestPalindrome {

	public static void main(String[] args) {
//		String str = "xyabayxj";
//		int midPos = str.length() / 2;
//		System.out.println(longestPalindromeBruteForce("xyabayxj"));
		System.out.println(longestPalindrome("xyabayxj"));
		System.out.println(longestPalindrome("xyabayxj"));
	}

	// xyabayx
	// If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a
	// palindrome?
	public static String longestPalindrome(String strToEval) {

		int len = 0, start = 0, end = 0, len1 = 0, len2 = 0;

		for (int i = 0; i < strToEval.length(); i++) {
			len1 = expandAroundCenter(strToEval, i, i);
			len2 = expandAroundCenter(strToEval, i, i + 1);
			len = Math.max(len1, len2);

			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
			System.out
					.println("len1 " + len1 + ", len2 " + len2 + ", len " + len + ", start " + start + ", end " + end);
		}
		return strToEval.substring(start, end + 1);
	}

	public static int expandAroundCenter(String str, int i, int j) {
		while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
			i--;
			j++;
		}

		return j - 1 - i;
	}

	// xyabayx
	// If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a
	// palindrome?

	// xyabayx
	// If “aba” is a palindrome, is “xabax” a palindrome? Similarly is “xabay” a
	// palindrome?
	public static String longestPalindromeBruteForce(String str) {
		char[] strChars = str.toCharArray();
		String longestPalindrome = "";
		for (int i = 0; i < strChars.length; i++) {
			for (int j = i + 1; j < strChars.length; j++) {
				if (isPalindrome(strChars, i, j)) {
					if (j - i + 1 > longestPalindrome.length()) {
						longestPalindrome = new String(Arrays.copyOfRange(strChars, i, j + 1));
					}
				}
			}
		}
		return longestPalindrome;
	}

	public static boolean isPalindrome(String str) {
		char[] strChars = str.toCharArray();
		boolean isPalindrome = true;
		for (int i = 0, j = strChars.length - 1; i < j; i++, j--) {
			if (strChars[i] != strChars[j]) {
				isPalindrome = false;
			}
		}
		return isPalindrome;
	}

	public static boolean isPalindrome(char[] charArr, int startIndex, int endIndex) {
		boolean isPalindrome = true;
		for (int i = startIndex, j = endIndex; i < j; i++, j--) {
			if (charArr[i] != charArr[j]) {
				isPalindrome = false;
			}
		}
		return isPalindrome;
	}

}
