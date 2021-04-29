package org.examples.arrays;

public class NumOfStepsToReduceNumInBinRepToOne {

	/**
	 * 
	 * Input: s = "1101" Output: 6
	 * 
	 * @param s
	 * @return
	 */
	public int numSteps(String s) {

		int res = 0;
		int carry = 0;
		for (int i = s.length() - 1; i > 0; i--) {
			res++;
			if (s.charAt(i) - '0' + carry == 1) {
				carry = 1;
				res++;
			}
		}

		return res + carry;
	}

	public int numStepsV2(long num) {
		if (num <= 1) {
			return 0;
		}

		if ((num % 2) == 0) {
			// even
			return 1 + numStepsV2(num / 2);
		} else {
			return 1 + numStepsV2(num + 1);
		}
	}

	private long convertBinaryStrToNum(String s) {
		long num = 0;
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			long multiplier = (long) Math.pow(2, j);
			num += multiplier * Character.getNumericValue(s.charAt(i));
			j++;
		}

		return num;
	}

	public static void main(String[] args) {
		NumOfStepsToReduceNumInBinRepToOne solver = new NumOfStepsToReduceNumInBinRepToOne();
		System.out.println(solver.numSteps("1001"));
		System.out.println(solver.numSteps("1010"));
//
//		System.out.println(solver.numSteps("1101"));
//		System.out.println(solver.numSteps("1111"));
//		System.out.println(solver.numSteps("10000"));
//		System.out.println(solver.numSteps("10"));
//		"1111011110000011100000110001011011110010111001010111110001"
//		System.out.println(Long.parseLong("1111011110000011100000110001011011110010111001010111110001",2));
//		System.out.println(solver.convertBinaryStrToNum("1111011110000011100000110001011011110010111001010111110001"));
//		System.out.println(solver.numSteps("1111011110000011100000110001011011110010111001010111110001"));		

//		System.out.println(solver.numSteps("1111110011101010110011100100101110010100101110111010111110110010"));
	}

}
