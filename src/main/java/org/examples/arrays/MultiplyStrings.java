package org.examples.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MultiplyStrings {

	public static void main(String[] args) {
		MultiplyStrings solver = new MultiplyStrings();

//		System.out.println(solver.multiply("123", "456"));
		System.out.println(solver.multiply("0", "0"));
		System.out.println(solver.multiply("0000", "0"));
		System.out.println(solver.multiply("0000", "4"));
//		solver.multiplyHelper1("123", 6, 1);
//		System.out.println(solver.multiply("428", "5"));

		System.out.println(solver.multiply("408", "108"));
		System.out.println(408 * 108);
	}

	public String multiply(String num1, String num2) {
		if (num1.length() >= num2.length()) {
			return multiplyHelper(num1, num2);
		} else {
			return multiplyHelper(num2, num1);
		}
	}

	private String multiplyHelper(String num1, String num2) {
		int numOfZeroes = 0;

		List<Queue<Byte>> listOfStacks = new ArrayList<>();
		int maxNumOfDigits = 0;
		for (int i = num2.length() - 1; i >= 0; i--) {
			int strChar = num2.charAt(i) - 48;
			Queue<Byte> product = multiplyHelper1(num1, strChar, numOfZeroes);

			if (product != null) {
				listOfStacks.add(product);
				maxNumOfDigits = Math.max(maxNumOfDigits, product.size());
			}

			numOfZeroes++;
		}

		Stack<Byte> completeProd = new Stack<Byte>();

		int carry = 0;
		for (int i = 0; i < maxNumOfDigits; i++) {
			int totalSum = 0;
			for (Queue<Byte> stackOfByte : listOfStacks) {
				if (!stackOfByte.isEmpty()) {
					totalSum += stackOfByte.poll();
				}
			}
			totalSum += carry;
			completeProd.push((byte) (totalSum % 10));
			carry = totalSum / 10;
		}

		if (carry > 0) {
			completeProd.push((byte) carry);
		}

		StringBuilder sb = new StringBuilder();
		while (!completeProd.isEmpty()) {
			sb.append(completeProd.pop());
		}

		if (sb.length() <= 0) {
			return "0";
		}
		return sb.toString();
	}

	private Queue<Byte> multiplyHelper1(String num, int multiplier, int numOfZeros) {
		int carry = 0;
		LinkedList<Byte> chars = new LinkedList<Byte>();
		while (numOfZeros > 0) {
			chars.add((byte) 0);
			numOfZeros--;
		}

		for (int i = num.length() - 1; i >= 0; i--) {
			byte charNum = (byte) (num.charAt(i) - 48);
			int product = charNum * multiplier;
			product = (product + carry);
			byte numAtIndex = (byte) (product % 10);
			chars.add(numAtIndex);
			carry = product / 10;
		}

		if (carry > 0) {
			chars.add((byte) carry);
		} else {
			if (chars.peekLast() == 0) {
				return null;
			}
		}

		return chars;
	}

}
