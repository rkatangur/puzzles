package org.examples.arrays;

import java.util.Arrays;

/**
 * 
 * 
 * Given an array of n integers nums and an integer target, find the number of
 * index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition
 * nums[i] + nums[j] + nums[k] < target.
 * 
 * Follow up: Could you solve it in O(n2) runtime?
 * 
 * Example 1:
 * 
 * Input: nums = [-2,0,1,3], target = 2 Output: 2 Explanation: Because there are
 * two triplets which sums are less than 2: [-2,0,1] [-2,0,3]
 * 
 * 
 * 
 * @author rkata
 *
 */

public class ThreeSumSmaller {

//	public int threeSumSmaller(int[] nums, int target) {
//		return threeSumHelper(0, nums.length - 1, nums, new int[3], 0, target);
//	}
//
//	private int threeSumHelper(int startIndex, int endIndex, int[] nums, int[] subArr, int subArrIndex, int targetSum) {
//
//		if (subArrIndex >= 3) {
//			int subArrSum = subArr[0] + subArr[1] + subArr[2];
//			if (subArrSum < targetSum) {
//				// record the array.
//				return 1;
//			}
//			return 0;
//		}
//
//		if (startIndex > endIndex) {
//			return 0;
//		}
//
//		subArr[subArrIndex] = nums[startIndex];
//		return threeSumHelper(startIndex + 1, endIndex, nums, subArr, subArrIndex + 1, targetSum)
//				+ threeSumHelper(startIndex + 1, endIndex, nums, subArr, subArrIndex, targetSum);
//	}
//
//	private int threeSumSmallerUsingPointers(int[] nums, int target) {
//		int numOfSmallerTriplets = 0;
//		Arrays.sort(nums);
//		for (int i = 0; i < nums.length; i++) {
//			int leftPointer = i + 1;
//			int rightPointer = nums.length - 1;
//
//			while (leftPointer < rightPointer) {
//				int curSum = nums[i] + nums[leftPointer] + nums[rightPointer];
//
//				if (curSum < target) {
//					numOfSmallerTriplets++;
//					rightPointer--;
//				} else {
//					leftPointer++;
//				}
//			}
//		}
//
//		return numOfSmallerTriplets;
//	}

	public static void main(String[] args) {
		ThreeSumSmaller solver = new ThreeSumSmaller();
		System.out.println(solver.threeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
//		System.out.println(solver.threeSumClosest(new int[] { 0, 0, 0 }, 1));
//		System.out.println(solver.threeSumClosest(new int[] { 1, 1, 1, 0 }, -100));
	}

//	public int threeSumSmaller(int[] nums, int target) {
//		Arrays.sort(nums);
//		int sum = 0;
//		for (int i = 0; i < nums.length - 2; i++) {
//			sum += twoSumSmaller(nums, i + 1, target - nums[i]);
//		}
//		return sum;
//	}
//
//	private int twoSumSmaller(int[] nums, int startIndex, int target) {
//		int sum = 0;
//		int left = startIndex;
//		int right = nums.length - 1;
//		while (left < right) {
//			if (nums[left] + nums[right] < target) {
//				sum += right - left;
//				left++;
//			} else {
//				right--;
//			}
//		}
//		return sum;
//	}

	public int threeSumSmallerUsingBinarySearch(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			sum += twoSumSmallerUsingBinarySearch(nums, i + 1, target - nums[i]);
		}
		return sum;
	}

	private int twoSumSmallerUsingBinarySearch(int[] nums, int index, int targetSum) {
		int left = index;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < targetSum) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}

		return left - index;
	}

}
