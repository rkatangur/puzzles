package org.examples.arrays;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome. Example 1:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: true Example 2:
 * 
 * Input: "race a car" Output: false
 * 
 * 
 * 
 * 
 * @author rkata
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		ValidPalindrome solver = new ValidPalindrome();
//		System.out.println(solver.isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(solver.isPalindrome("race a car"));
//		System.out.println(solver.isPalindrome("a."));
		System.out.println(solver.validPalindrome("eedede"));
	}

	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}

		int leftPointer = 0;
		int rightPointer = s.length() - 1;

		for (; leftPointer < rightPointer; leftPointer++, rightPointer--) {

			// left char is available
			while (leftPointer < rightPointer && !isAlphaNumericChar(s.charAt(leftPointer))) {
				leftPointer++;
			}

			// right char is available
			while (leftPointer < rightPointer && !isAlphaNumericChar(s.charAt(rightPointer))) {
				rightPointer--;
			}

			if (Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))) {
				return false;
			}
		}

		return true;
	}

	public boolean isAlphaNumericChar(char ch) {
		int chIntVal = ch;
		if ((chIntVal >= 48 && chIntVal <= 57) || (chIntVal >= 65 && chIntVal <= 90)
				|| (chIntVal >= 97 && chIntVal <= 122)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 680. Valid Palindrome II Given a non-empty string s, you may delete at most
	 * one character. Judge whether you can make it a palindrome.
	 * 
	 * Example 1: Input: "aba" Output: True Example 2: Input: "abca" Output: True
	 * Explanation: You could delete the character 'c'.
	 * 
	 * 
	 */
	public boolean isPalindrome(String s, int startPointer, int endPointer) {
		for (int i = startPointer; i <= startPointer + (endPointer - startPointer) / 2; i++) {
			if (s.charAt(i) != s.charAt(endPointer - i + startPointer)) {
				return false;
			}
		}
		return true;
	}

	public boolean validPalindrome(String s) {
		int leftPointer = 0;
		int rightPointer = s.length() - 1;

		while (leftPointer < rightPointer) {
			if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
				return isPalindrome(s, leftPointer + 1, rightPointer) || isPalindrome(s, leftPointer, rightPointer - 1);
			} else {
				leftPointer++;
				rightPointer--;
			}
		}

		return true;
	}

}
