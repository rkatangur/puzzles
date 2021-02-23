package org.examples.arrays;

/**
 * 
 * Find the smallest subarray with the given sum
 * 
 * find the smallest subarray size greater than or equal to sum.
 * 
 * 
 * @author rkata
 *
 */

public class SmallestSubarrayGivenSum {

	public static void main(String[] args) {
		System.out.println(findSmallestSumSubArrayWithGivenSum(new int[] { 4, 2, 2, 7, 8, 1, 2, 8, 1, 0 }, 8));
	}

	public static int findSmallestSumSubArrayWithGivenSum(int[] arr, int minSum) {

		int minWinSize = Integer.MAX_VALUE;
		int curWinSum = 0;

		int winStartIndex = 0;
		int curRunningSum = 0;

		for (int winEndIndex = 0; winEndIndex < arr.length; winEndIndex++) {
			curRunningSum += arr[winEndIndex];

			while (curRunningSum >= minSum) {
				if ((winEndIndex - winStartIndex + 1) <= minWinSize) {
					minWinSize = winEndIndex - winStartIndex + 1;
					curWinSum = curRunningSum;
				}
				curRunningSum -= arr[winStartIndex++];
			}
		}
		System.out.println("minSubArraySum " + curWinSum + ", minSubArrSize " + minWinSize);
		return minWinSize;
	}

}
