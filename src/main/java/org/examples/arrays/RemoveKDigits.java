package org.examples.arrays;

import java.util.Stack;

/**
 * 402. Remove K Digits
 * 
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 * 
 * 
 * Example 1: Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove
 * the three digits 4, 3, and 2 to form the new number 1219 which is the
 * smallest.
 * 
 * Example 2: Input: num = "10200", k = 1 Output: "200" Explanation: Remove the
 * leading 1 and the number is 200. Note that the output must not contain
 * leading zeroes.
 * 
 * Example 3: Input: num = "10", k = 2 Output: "0" Explanation: Remove all the
 * digits from the number and it is left with nothing which is 0.
 * 
 * @author rkata
 *
 */
public class RemoveKDigits {

	// "9"
	// 1
	public static void main(String[] args) {
		RemoveKDigits solver = new RemoveKDigits();
//		String num = "1432219";
		System.out.println(solver.removeKdigits("112", 1));
//		System.out.println(solver.removeKdigits("10200", 1));
//
//		System.out.println(solver.removeKdigits("9", 1));
//
//		System.out.println(solver.removeKdigits("1234567890", 9));
	}

	public String removeKdigits(String num, int k) {
		if (k == num.length()) {
			return "0";
		}
		Stack<Character> stackOfInts = new Stack<Character>();
		for (int i = 0; i < num.length(); i++) {
			while (!stackOfInts.isEmpty() && stackOfInts.peek() > num.charAt(i) && k > 0) {
				stackOfInts.pop();
				k--;
			}
			stackOfInts.add(num.charAt(i));
		}

		for (int i = 0; i < k; i++) {
			stackOfInts.pop();
		}

		StringBuilder ret = new StringBuilder();
		boolean leadingZero = true;
		for (Character popedChar : stackOfInts) {
			if (leadingZero && popedChar == '0') {
				continue;
			} else {
				leadingZero = false;
			}
			ret.append(popedChar);
		}

		if (ret.length() == 0)
			return "0";
		return ret.toString();
	}

}
