package org.examples.arrays;

/**
 * 
 * 209. Minimum Size Subarray Sum
 * 
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ...,
 * numsr-1, numsr] of which the sum is greater than or equal to target. If there
 * is no such subarray, return 0 instead.
 * 
 * Example 1:
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: The subarray
 * [4,3] has the minimal length under the problem constraint. Example 2:
 * 
 * Input: target = 4, nums = [1,4,4] Output: 1 Example 3:
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= target <= 109 1 <= nums.length <= 105 1 <= nums[i] <= 105
 * 
 * @author rkata
 *
 */
public class MinimumSizeSubArraySum {

	public int minSubArrayLen(int target, int[] nums) {

		int leftIndex = 0, rightIndex = 0, sum = 0;
		int minSubarrayLength = Integer.MAX_VALUE;

		while (rightIndex < nums.length) {
			sum += nums[rightIndex];
			while (sum >= target) {
				minSubarrayLength = Math.min(minSubarrayLength, rightIndex - leftIndex + 1);
				sum = sum - nums[leftIndex];
				leftIndex++;
			}
			rightIndex++;
		}

		if (minSubarrayLength == Integer.MAX_VALUE)
			return 0;

		return minSubarrayLength;
	}

}
