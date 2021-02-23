package org.examples.arrays;

 
		
public class LargestContiguousSumInArray {

	public static void main(String[] args) {

	}

	public static int findMaxSum(int[] arr) {
		//initialize the max_so_far to Integer.MIN_VALUE
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;

		for (int i = 0; i < arr.length; i++) {
			max_ending_here = max_ending_here + arr[i];

			// Update max_so_far with max_ending_here if it is less.
			// For -ve numbers, lowest -ve value is the one with a greater sum, so the max_so_far should pick a number that is closer to Zero.
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
		}

		return max_so_far;
	}

}
