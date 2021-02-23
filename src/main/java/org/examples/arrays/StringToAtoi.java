package org.examples.arrays;

public class StringToAtoi {

	public static void main(String[] args) {
		StringToAtoi solver = new StringToAtoi();
		System.out.println(solver.myAtoi("   -42"));
		System.out.println(solver.myAtoi("   42"));
		System.out.println(solver.myAtoi("words and 987"));
		System.out.println(solver.myAtoi("4193 with words"));
		System.out.println(solver.myAtoi("-91283472332"));
		System.out.println(Integer.MIN_VALUE);
	}

	public int myAtoi(String str) {
		char[] sChars = str.toCharArray();
//		byte[] bytes = new byte[8];

		boolean isSpaceRead;
		boolean isSignRead = false;
		boolean isNegative = false;
		long retVal = 0;
		// 220
		for (char c : sChars) {
			if (c == ' ') {
				continue;
			}

			if (c == '-') {
				isSignRead = true;
				isNegative = true;
			} else if ((int) c >= 49 && (int) c <= 57) {
				// number seen
				retVal = retVal * 10 + (int) c - 48;
			} else {
				break;
			}
		}

		if (isNegative) {			
			return retVal * -1;
		}
		
		return retVal;

	}

}
