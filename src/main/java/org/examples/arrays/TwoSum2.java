package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 167. Two Sum II - Input array is sorted
 * 
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * Your returned answers (both index1 and index2) are not zero-based. You may
 * assume that each input would have exactly one solution and you may not use
 * the same element twice.
 * 
 * 
 * Example 1:
 * 
 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The sum
 * of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. Example 2:
 * 
 * Input: numbers = [2,3,4], target = 6 Output: [1,3] Example 3:
 * 
 * Input: numbers = [-1,0], target = -1 Output: [1,2]
 * 
 * 
 * @author rkata
 *
 */

public class TwoSum2 {

	public static void main(String[] args) {
		TwoSum2 solver = new TwoSum2();
		ArraysUtil.printIntArr(solver.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		ArraysUtil.printIntArr(solver.twoSum(new int[] { 2, 3, 4 }, 6));
		ArraysUtil.printIntArr(solver.twoSum(new int[] { -1, 0 }, -1));
	}

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> numsMap = new HashMap<>();
		numsMap.put(nums[0], 0);

		for (int i = 1; i < nums.length; i++) {
			int leftover = target - nums[i];

			if (numsMap.containsKey(leftover) && numsMap.get(leftover) < i) {
				return new int[] { numsMap.get(leftover) + 1, i + 1 };
			}
			numsMap.put(nums[i], i);
		}

		return new int[] {};
	}

	/**
	 * As the input array is in sorted order use the left and right pointer approach
	 * where the leftpointer will point to lowest element and the right pointer will
	 * point to highest element.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSumUsingTwoPointers(int[] nums, int target) {

		int leftPointer = 0;
		int rightPointer = nums.length - 1;

		while (leftPointer < rightPointer) {
			int curSum = nums[leftPointer] + nums[rightPointer];

			if (curSum == target) {
				return new int[] { leftPointer + 1, rightPointer + 1 };
			} else if (curSum > target) {
				rightPointer--;
			} else {
				leftPointer++;
			}
		}

		return new int[] { -1, -1 };
	}

}
