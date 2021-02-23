package org.examples.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 18. 4Sum
 * 
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Notice that the solution set must not contain duplicate quadruplets.
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,-1,0,-2,2], target = 0 Output:
 * [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * Example 2: Input: nums = [], target = 0 Output: []
 * 
 * @author rkata
 */

public class FourSum {

	public static void main(String[] args) {
		FourSum solver = new FourSum();
		List<List<Integer>> resulList = solver.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
		System.out.println("---------------");

		for (List<Integer> result : resulList) {
			for (Integer resElem : result) {
				System.out.print(resElem + ", ");
			}
			System.out.println();
		}

//		solver.fourSum(new int[] { 1, 2, 3 }, 0);
//		solver.generateCombinations(new int[] { 1, 2, 3 }, 2);
	}

	public void generateCombinations(int[] nums, int numOfCombs) {
		int[] comb = new int[numOfCombs];
		generateCombinationsHelper(nums, comb, 0, 0);
	}

	public void generateCombinationsHelper(int[] nums, int[] comb, int numIndex, int combIndex) {

		if (combIndex >= comb.length) {
			ArraysUtil.printIntArr(comb);
			return;
		}

		int n = nums.length - 1;
		int max = Math.min(n, n + 1 - comb.length + combIndex);
		for (int i = numIndex; i <= max; i++) {
			comb[combIndex] = nums[i];
			generateCombinationsHelper(nums, comb, i + 1, combIndex + 1);
		}
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		return fourSum(nums, target, 4);
	}

	public List<List<Integer>> fourSum(int[] nums, int target, int numOfCombs) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		int[] comb = new int[numOfCombs];
		fourSumHelper(nums, comb, 0, 0, target, resultList);

		return resultList;
	}

	public void fourSumHelper(int[] nums, int[] comb, int numIndex, int combIndex, int target,
			List<List<Integer>> resultList) {

		if (comb.length == combIndex) {
			int totalSum = 0;
			List<Integer> res = new ArrayList<Integer>();
			for (int elem : comb) {
				res.add(elem);
				totalSum += elem;
			}
			if (totalSum == target) {
				resultList.add(res);
			}

			ArraysUtil.printIntArr(comb);
			return;
		}

		int n = nums.length - 1;
		int max = Math.min(n, n + 1 - comb.length + combIndex);
		for (int i = numIndex; i <= max; i++) {
			comb[combIndex] = nums[i];
			fourSumHelper(nums, comb, i + 1, combIndex + 1, target, resultList);
		}
	}

}
