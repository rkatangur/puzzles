package org.examples.arrays;

import java.util.Arrays;

/**
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Example 2:
 * 
 * Input: nums = [] Output: [] Example 3:
 * 
 * Input: nums = [0] Output: []
 * 
 * 
 * 
 * @author rkata
 *
 */

public class ThreeSumCloset {

	int[] subArr = null;
	int subArrSum = Integer.MAX_VALUE;
	int prevDiff = Integer.MAX_VALUE;

	// -1, 2, 1, -4 , target =1
	// after sort: -4, -1, 1, 2, target =1

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int leftPointer = i + 1;
			int rightPointer = nums.length - 1;
			while (leftPointer < rightPointer) {
				int newSubArrSum = nums[i] + nums[leftPointer] + nums[rightPointer];
				int newDiff = newSubArrSum - target;
				if (Math.abs(newDiff) < Math.abs(diff)) {
					diff = newDiff;
				}

				if (newSubArrSum < target) {
					rightPointer--;
				} else {
					leftPointer++;
				}
			}
		}
		return target - diff;
	}

	public int threeSumClosestUsingPointers(int[] nums, int target) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {

			int leftPointer = i + 1;
			int rightPointer = nums.length - 1;

			while (leftPointer < rightPointer) {
				int newSubArrSum = nums[i] + nums[leftPointer] + nums[rightPointer];
				int newDiff = newSubArrSum - target;
				if (Math.abs(newDiff) < Math.abs(diff)) {
					diff = newDiff;
				}

				if (newSubArrSum < target) {
					rightPointer--;
				} else {
					leftPointer++;
				}
			}
		}
		return target - diff;
	}

	public static void main(String[] args) {
		ThreeSumCloset solver = new ThreeSumCloset();
		System.out.println(solver.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
//		System.out.println(solver.threeSumClosest(new int[] { 0, 0, 0 }, 1));
//		System.out.println(solver.threeSumClosest(new int[] { 1, 1, 1, 0 }, -100));
	}
}
