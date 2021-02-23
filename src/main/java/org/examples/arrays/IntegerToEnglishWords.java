package org.examples.arrays;

public class IntegerToEnglishWords {

	public static void main(String[] args) {
		IntegerToEnglishWords solver = new IntegerToEnglishWords();
		System.out.println(solver.numberToWords(123));
//		System.out.println(solver.numberToWords(1003));
	}

	public String numberToWords(int num) {
		if (num <= 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();

		int avail = num / 1000;
		int leftOver = num % 1000;
		if (avail > 0) {
			sb.append(numberToWords(avail)).append(" Thousand");

			if (leftOver > 0) {
				sb.append(numberToWords(leftOver));
			}
		}

		avail = leftOver / 100;
		leftOver = leftOver % 100;
		if (avail > 0) {
			sb.append(numberUnitToString(avail)).append(" Hundred");
			if (leftOver > 0) {
				sb.append(numberToWords(leftOver));
			}
		}

		avail = leftOver / 10;
		if (avail > 0) {
			if (leftOver >= 10 && leftOver < 20) {
				sb.append(convertTensToString(avail));
			} else {
				sb.append(convertTensToString(avail));
			}

			leftOver = leftOver % 10;
			if (leftOver > 0) {
				sb.append(numberToWords(leftOver));
			}
		} else if (leftOver > 0) {
			sb.append(numberUnitToString(leftOver));
		}

		return sb.toString();
	}

	private String convertTensToString(int num) {
		if (num == 1) {
			return "One";
		} else if (num == 2) {
			return "Two";
		}
		return null;
	}

	public String numberUnitToString(int num) {
		if (num == 1) {
			return "One";
		} else if (num == 2) {
			return "Two";
		}
		return "XXX";
	}

}
