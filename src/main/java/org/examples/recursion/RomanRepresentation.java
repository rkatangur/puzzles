package org.examples.recursion;

public class RomanRepresentation {
//	Symbol 	I	V	X	L	C	D	M
//	Value	1	5	10	50	100	500	1,000

	public static void main(String[] args) {
//		System.out.println(convertToRoman(349, ""));
		System.out.println(convertToRoman(1000, ""));
		System.out.println(convertToRoman(1990, ""));
		System.out.println(convertToRoman(2008, ""));
		System.out.println(convertToRoman(1666, ""));
	}

	public static String convertToRoman(int num, String romanStr) {
		if (num == 0) {
			return romanStr;
		}

		if (num >= 1000) {
			int quotient = num / 1000;
			num = num % 1000;
			romanStr = romanStr + buildString(quotient, "M");
			romanStr = convertToRoman(num, romanStr);
		} else if (num >= 500) {
			if (num >= 900) {
				num = num % 900;
				romanStr = romanStr + buildString(1, "CM");
				romanStr = convertToRoman(num, romanStr);
			} else {
				int quotient = num / 500;
				num = num % 500;
				romanStr = romanStr + buildString(quotient, "D");
				romanStr = convertToRoman(num, romanStr);
			}
		} else if (num >= 100) {
			if (num >= 400) {
				num = num % 400;
				romanStr = romanStr + buildString(1, "CD");
				romanStr = convertToRoman(num, romanStr);
			} else {
				int quotient = num / 100;
				num = num % 100;
				romanStr = romanStr + buildString(quotient, "C");
				romanStr = convertToRoman(num, romanStr);
			}
		} else if (num >= 50) {
			if (num >= 90) {
				num = num % 90;
				romanStr = romanStr + buildString(1, "XC");
				romanStr = convertToRoman(num, romanStr);
			} else {
				int quotient = num / 50;
				num = num % 50;
				romanStr = romanStr + buildString(quotient, "L");
				romanStr = convertToRoman(num, romanStr);
			}

		} else if (num >= 10) {
			if (num >= 40) {
				num = num % 40;
				romanStr = romanStr + buildString(1, "XL");
				romanStr = convertToRoman(num, romanStr);
			} else {
				int quotient = num / 10;
				num = num % 10;
				romanStr = romanStr + buildString(quotient, "X");
				romanStr = convertToRoman(num, romanStr);
			}
		} else if (num >= 5) {
			if (num >= 9) {
				num = num % 9;
				romanStr = romanStr + buildString(1, "IX");
				romanStr = convertToRoman(num, romanStr);
			} else {
				int quotient = num / 5;
				num = num % 5;
				romanStr = romanStr + buildString(quotient, "V");
				romanStr = convertToRoman(num, romanStr);
			}
		} else if (num >= 1) {
			if (num >= 4) {
				num = num % 4;
				romanStr = romanStr + buildString(1, "IV");
				romanStr = convertToRoman(num, romanStr);
			} else {
				int quotient = num / 1;
				num = num % 1;
				romanStr = romanStr + buildString(quotient, "I");
				romanStr = convertToRoman(num, romanStr);
			}
		}

		return romanStr;
	}

	private static String buildString(int quotient, String str) {
		String curStr = "";
		for (int i = 0; i < quotient; i++) {
			curStr = curStr + str;
		}
		return curStr;
	}

}
