package org.examples.arrays;

import java.util.Arrays;

/**
 * 
 * 1099. Two Sum Less Than K
 * 
 * 
 * Given an array nums of integers and integer k, return the maximum sum such
 * that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j
 * exist satisfying this equation, return -1.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [34,23,1,24,75,33,54,8], k = 60 Output: 58 Explanation: We can
 * use 34 and 24 to sum 58 which is less than 60.
 * 
 * Example 2:
 * 
 * Input: nums = [10,20,30], k = 15 Output: -1 Explanation: In this case it is
 * not possible to get a pair sum less that 15.
 * 
 * 
 * @author rkata
 *
 */
public class TwoSumLessThanK {

	public int twoSumLessThanK(int[] nums, int k) {

		Arrays.sort(nums);
		int left = 0, right = nums.length - 1, maxSum = -1;

		while (left < right) {
			int curSum = nums[left] + nums[right];
			if (curSum < k) {
				left++;
				maxSum = Math.max(curSum, maxSum);
			} else {
				right--;
			}
		}

		return maxSum;
	}

}
