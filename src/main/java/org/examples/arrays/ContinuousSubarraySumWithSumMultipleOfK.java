package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 523. Continuous Subarray Sum Given a list of non-negative numbers and a
 * target integer k, write a function to check if the array has a continuous
 * subarray of size at least 2 that sums up to a multiple of k, that is, sums up
 * to n*k where n is also an integer.
 * 
 * Example 1:
 * 
 * Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2, 4] is a
 * continuous subarray of size 2 and sums up to 6. Example 2:
 * 
 * Input: [23, 2, 6, 4, 7], k=6 Output: True Explanation: Because [23, 2, 6, 4,
 * 7] is an continuous subarray of size 5 and sums up to 42.
 * 
 * 
 * @author rkata
 *
 */
public class ContinuousSubarraySumWithSumMultipleOfK {

	public static void main(String[] args) {
		ContinuousSubarraySumWithSumMultipleOfK solver = new ContinuousSubarraySumWithSumMultipleOfK();
//		System.out.println(solver.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
//		System.out.println(solver.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
//		
//		System.out.println(solver.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 0));
//		
		System.out.println(solver.checkSubarraySum(new int[] { 0, 0 }, 0));
	}

	public boolean checkSubarraySumOptimized(int[] nums, int k) {
		Map<Integer, Integer> sumsToIndex = new HashMap<>();
		sumsToIndex.put(0, -1);

		int workingSum = 0;
		for (int i = 0; i < nums.length; i++) {
			workingSum += nums[i];
			int rem = workingSum % k;
			if (sumsToIndex.containsKey(rem)) {
				if ((i - sumsToIndex.get(rem)) > 1) {
					return true;
				}
			} else {
				sumsToIndex.put(rem, i);
			}
		}

		return false;
	}

	public boolean checkSubarraySum(int[] nums, int sum) {

		return checkSubarraySum(nums, sum, 2);
	}

	public boolean checkSubarraySum(int[] nums, int sum, int minSubArrSize) {

		int curRunningSum = 0;
		int subArrStartIdx = 0;
		int curMinSubArrSize = Integer.MAX_VALUE;

		for (int subArrEndIdx = 0; subArrEndIdx < nums.length; subArrEndIdx++) {
			curRunningSum += nums[subArrEndIdx];

			// it is a multiple of sum
			int workingSum = curRunningSum;
			int workingStartIdx = subArrStartIdx;
			while ((subArrEndIdx - workingStartIdx + 1) >= 2) {
				if (workingSum == sum || (sum != 0 && workingSum % sum == 0)) {
					curMinSubArrSize = Math.min(curMinSubArrSize, subArrEndIdx - workingStartIdx + 1);

					return true;
				}
				workingSum -= nums[workingStartIdx++];
			}
		}

		if (curMinSubArrSize != Integer.MAX_VALUE) {
			return true;
		}

		return false;
	}

}
