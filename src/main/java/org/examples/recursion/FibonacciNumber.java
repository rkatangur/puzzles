package org.examples.recursion;

public class FibonacciNumber {

	public static void main(String[] args) {
		System.out.println(fibonacci(5));
		System.out.println(fibonacciUsingDPTopDown(5));
		System.out.println(fibonacciUsingDPBottomUp(5));
		System.out.println(fibonacciUsingDPBottomUpWithoutMomization(5));
	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int fibonacciUsingDPTopDown(int n) {
		int[] lookup = new int[n + 1];

		return fibonacciUsingDPTopDownMemoization(n, lookup);
	}

	public static int fibonacciUsingDPTopDownMemoization(int n, int[] lookup) {
		if (n <= 1) {
			return n;
		}

		if (lookup[n] != 0) {
			return lookup[n];
		}

		lookup[n - 1] = fibonacci(n - 1);
		lookup[n - 2] = fibonacci(n - 2);
		return lookup[n - 1] + lookup[n - 2];
	}

	public static int fibonacciUsingDPBottomUp(int n) {
		int[] lookup = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i <= 1) {
				lookup[i] = i;
			} else {
				lookup[i] = lookup[i - 1] + lookup[i - 2];
			}
		}

		return lookup[n];
	}

	public static int fibonacciUsingDPBottomUpWithoutMomization(int n) {
		 if (n <= 1)
			 return n;
		 
		int prevFibVal = 0;
		int curFibVal = 1;
		for (int i = 0; i < n-1; i++) {
			int newFibVal = curFibVal + prevFibVal;
			prevFibVal = curFibVal;
			curFibVal = newFibVal;
		}

		return curFibVal;
	}
}
