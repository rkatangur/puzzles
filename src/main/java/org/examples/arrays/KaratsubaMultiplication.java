package org.examples.arrays;

import java.math.BigDecimal;
import java.util.Arrays;

public class KaratsubaMultiplication {

	public static void main(String[] args) {
		String num1Str = "3141592653589793238462643383279502884197169399375105820974944592";
		String num2Str = "2718281828459045235360287471352662497757247093699959574966967627";

		System.out.println(karatsubaMultiplication(num1Str.toCharArray(), num2Str.toCharArray()));
//		System.out.println(simpleMultiplication(new char[] { 3, 1 }, new char[] { 2, 7 }));

		System.out.println(computeSimpleMultiplication(num1Str, num2Str));
	}

	private static BigDecimal karatsubaMultiplication(char[] num1, char[] num2) {
		if (num1.length > 2 && num2.length > 2) {
			char[] a = Arrays.copyOfRange(num1, 0, num1.length/2);
			char[] b = Arrays.copyOfRange(num1, num1.length/2, num1.length);

			char[] c = Arrays.copyOfRange(num2, 0, num2.length/2);
			char[] d = Arrays.copyOfRange(num2, num2.length/2, num2.length);
			
			BigDecimal ac = karatsubaMultiplication(a, c);		
			BigDecimal bd = karatsubaMultiplication(b, d);
			
			BigDecimal aPlusB = new BigDecimal(a).add(new BigDecimal(b));
			BigDecimal cPlusD = new BigDecimal(c).add(new BigDecimal(d));
			
			BigDecimal adPlusBc = karatsubaMultiplication(aPlusB.toString().toCharArray(), cPlusD.toString().toCharArray()).subtract(ac).subtract(bd);
			
			BigDecimal elem2 =new BigDecimal(10).pow(num1.length/2).multiply(adPlusBc);
			
			return new BigDecimal(10).pow(num1.length).multiply(ac).add(elem2).add(bd);			
		} else {
			return new BigDecimal(num1).multiply(new BigDecimal(num2));
		}
	}

//	private static long simpleMultiplication(byte[] num1, byte[] num2) {
//		long number1 = 0;
//		for (int i = 0; i < num1.length; i++) {
//			number1 += num1[i] * (int) Math.pow(10, num1.length - 1 - i);
//		}
//
//		long number2 = 0;
//		for (int i = 0; i < num2.length; i++) {
//			number2 += num2[i] * (int) Math.pow(10, num1.length - 1 - i);
//		}
//
//		return number1 * number2;
//	}

	public static BigDecimal computeSimpleMultiplication(String num1, String num2) {
		return new BigDecimal(num1).multiply(new BigDecimal(num2));
	}
}
