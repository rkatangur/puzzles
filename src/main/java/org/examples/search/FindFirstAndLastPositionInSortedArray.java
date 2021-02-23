package org.examples.search;

import org.examples.arrays.ArraysUtil;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value. If target is not found in the
 * array, return [-1, -1]. Follow up: Could you write an algorithm with O(log n)
 * runtime complexity?
 * 
 * @author rkata
 *
 */
public class FindFirstAndLastPositionInSortedArray {

	public static void main(String[] args) {
		FindFirstAndLastPositionInSortedArray solver = new FindFirstAndLastPositionInSortedArray();
		ArraysUtil.printIntArr(solver.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
		ArraysUtil.printIntArr(solver.searchRange(new int[] { 5, 6, 7, 8, 9, 10 }, 8));
		ArraysUtil.printIntArr(solver.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
//
		ArraysUtil.printIntArr(solver.searchRange(new int[] { 2, 2 }, 2));

		ArraysUtil.printIntArr(solver.searchRange(new int[] { 1, 2, 3, 3, 3, 3, 4, 5, 9 }, 3));
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}

		int[] pos = new int[] { 0, 0 };
		pos[0] = findStartPosition(nums, target);
		pos[1] = findEndPosition(nums, target);

		return pos;
	}

	public int findStartPosition(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int index = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				index = mid;
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return index;
	}

	public int findEndPosition(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int index = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				index = mid;
				left = mid + 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return index;
	}
	
}
