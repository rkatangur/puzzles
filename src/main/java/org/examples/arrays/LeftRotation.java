package org.examples.arrays;

import java.util.Scanner;

public class LeftRotation {

//  5 1
//  1 2 3 4 5

	static int[] leftRotation(int[] a, int d) {
		if (d <= 0) {
			return a;
		}

		int prevNum = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			if (i == a.length - 1) {
				prevNum = a[i];
				a[i] = a[0];
			} else {
				int temp = a[i];
				a[i] = prevNum;
				prevNum = temp;
			}
		}

		d--;
		return leftRotation(a, d);
	}

	static int[] leftRotation1(int[] a, int d) {
		if (d <= 0) {
			return a;
		}

		int elemAtIndexZero = a[0];
		for (int i = 1; i < a.length; i++) {
			a[i - 1] = a[i];
			;
		}
		a[a.length - 1] = elemAtIndexZero;
		d--;
		return leftRotation(a, d);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] result = leftRotation(a, d);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");
		
		int[] result1 = leftRotation1(a, d);
		for (int i = 0; i < result1.length; i++) {
			System.out.print(result1[i] + (i != result1.length - 1 ? " " : ""));
		}
		System.out.println("");


		in.close();
	}
}
