package org.examples.recursion;

public class TriangleNumbers {

	public static void main(String[] args) {
		System.out.println(findTriangleSum(5));
		System.out.println(findTriangleSum1(5));
	}

	public static int findTriangleSum(int n) {
		if (n <= 0) {
			return n;
		}
		int totalSum = n + findTriangleSum(n - 1);
		return totalSum;
	}

	public static int findTriangleSum1(int n) {
		int totalSum = 0;

		while (n > 0) {
			totalSum += n;
			n--;
		}
		return totalSum;
	}

}
