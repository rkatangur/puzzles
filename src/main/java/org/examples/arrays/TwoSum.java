package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. You may assume that each input
 * would have exactly one solution, and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output: Because nums[0] +
 * nums[1] == 9, we return [0, 1].
 * 
 * @author rkata
 *
 */

public class TwoSum {

	/**
	 * O(n^2) solution
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSumV1(int[] nums, int target) {
		int[] indices = new int[2];
		int leftOver = target - nums[0];
		indices[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target == (nums[i] + nums[j])) {
					indices[0] = i;
					indices[1] = j;
					break;
				}
			}
		}

		return indices;
	}

	/**
	 * 
	 * O(n) solution
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<>();
		numsMap.put(nums[0], 0);

		for (int i = 1; i < nums.length; i++) {
			int leftover = target - nums[i];
			if (numsMap.containsKey(leftover)) {
				return new int[] { numsMap.get(leftover), i };
			}
			numsMap.put(nums[i], i);
		}

		return new int[] {};
	}

}
