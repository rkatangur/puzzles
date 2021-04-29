package org.examples.arrays;

public class ConvertToBase2 {

	public String base2(int N) {

		String base2Str = "";
		int num = N;
		while (num > 0) {
			int remainder = num % 2;
			base2Str = remainder + base2Str;
			num = num / 2;
		}

		return base2Str;
	}

	public String baseNeg2(int N) {
		return baseNeg2(N, -2);
	}

	public String baseNeg2(int N, int base) {
		if (N == 0) {
			return "0";
		}

		String base2Str = "";
		while (N != 0) {
			int remN = N % base;
			N = N / base;
			if (remN < 0) {
				remN = remN + Math.abs(base);
				N++;
			}

			base2Str = String.valueOf(remN) + base2Str;
		}
		return base2Str;
	}

	public String baseNeg2Helper(int n) {
		if (n == 1 || n == 0) {
			return Integer.toString(n);
		}
		int rem = n % 2;
		return baseNeg2Helper(n / 2 * -1) + "" + rem;
	}

	public static void main(String[] args) {
		ConvertToBase2 solver = new ConvertToBase2();
//		System.out.println(solver.baseNeg2(1));
//		System.out.println(solver.baseNeg2(2));
//		System.out.println(solver.baseNeg2(3));
//		System.out.println(solver.baseNeg2(4));
//		
//		System.out.println(solver.baseNeg2(3));
//		System.out.println(solver.baseNeg2(4));
		System.out.println(solver.baseNeg2(5));
	}

}
