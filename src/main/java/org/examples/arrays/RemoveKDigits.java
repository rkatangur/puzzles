package org.examples.arrays;

public class RemoveKDigits {

	// "9"
	// 1
	public static void main(String[] args) {
		RemoveKDigits solver = new RemoveKDigits();
//		String num = "1432219";
//		System.out.println(solver.removeKdigits("112", 1));
//		System.out.println(solver.removeKdigits("10200", 1));
//
//		System.out.println(solver.removeKdigits("9", 1));
//
		System.out.println(solver.removeKdigits("1234567890", 9));
	}

	public String removeKdigits(String num, int k) {
		if (k == num.length()) {
			return "0";
		}

		// 14
		// 13
		// 12
		// 122
		// 121
		// 1219
		char[] numChars = num.toCharArray();
		int newNumIdx = 0;
		char[] newNum = new char[num.length()];
		newNum[newNumIdx] = numChars[0];
		for (int i = 1; i < numChars.length; i++) {
			if ((int) numChars[i] < ((int) newNum[newNumIdx]) && k > 0) {
				k--;
				newNum[newNumIdx] = numChars[i];
			} else {
				if (newNumIdx == 0 && newNum[newNumIdx] == '0') {
					newNum[newNumIdx] = numChars[i];
				} else {
					newNum[++newNumIdx] = numChars[i];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = newNumIdx; i >=0; i--) {
			if (k > 0) {
				k--;
			} else {
				sb.append(newNum[i]);
			}
		}

		return sb.reverse().toString();
	}

}
