package org.examples.arrays;

/**
 * 41. First Missing Positive
 * 
 * Given an unsorted integer array nums, find the smallest missing positive
 * integer.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,0] Output: 3 Example 2:
 * 
 * Input: nums = [3,4,-1,1] Output: 2 Example 3:
 * 
 * Input: nums = [7,8,9,11,12] Output: 1
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 300 -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses
 * constant extra space?
 * 
 * @author rkata
 *
 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {

		boolean isOneAval = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0 || nums[i] > nums.length) {
				nums[i] = 1;
			} else if (nums[i] == 1) {
				isOneAval = true;
			}
		}

		if (!isOneAval) {
			return 1;
		}

		for (int i = 0; i < nums.length; i++) {
			int iThVal = Math.abs(nums[i]);
			if (nums[iThVal - 1] > 0) {
				nums[iThVal - 1] = nums[iThVal - 1] * -1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int iThVal = nums[i];
			if (iThVal > 0) {
				return i + 1;
			}
		}

		return nums.length + 1;
	}

}
