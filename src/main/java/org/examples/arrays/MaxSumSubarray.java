package org.examples.arrays;

/**
 * Find the max sum subarray of a fixed size k
 * 
 * Example input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
 * 
 * 
 * @author rkata
 *
 */
public class MaxSumSubarray {

	public static void main(String[] args) {
		System.out.println(findMaxSumSubarray(new int[] { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 }, 3));
	}

	public static int findMaxSumSubarray(int[] arr, int k) {

		int maxSumSoFar = 0;
		int curMaxSum = 0;

		int winStartIndex = 0;
		int winEndIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			if (winEndIndex - winStartIndex < k - 1) {
				maxSumSoFar += arr[i];
				curMaxSum = maxSumSoFar;
				winEndIndex = i;
			} else {
				curMaxSum = curMaxSum + arr[i];
				curMaxSum = curMaxSum - arr[winStartIndex];
				if (curMaxSum > maxSumSoFar) {
					maxSumSoFar = curMaxSum;
				}
				winEndIndex = i;
				winStartIndex++;
			}
		}

		return maxSumSoFar;
	}

}
