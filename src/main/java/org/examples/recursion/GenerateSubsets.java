package org.examples.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * Example 2:
 * 
 * Input: nums = [0] Output: [[],[0]]
 * 
 * @author rkata
 *
 */

public class GenerateSubsets {

	public static void main(String[] args) {
		GenerateSubsets solver = new GenerateSubsets();
		solver.subsets(new int[] { 1, 2, 3 });
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		resList.add(new ArrayList<Integer>());
		for (int i = 1; i <= nums.length; i++) {
			generateSubsets(nums, i, resList);
		}
		return resList;
	}

	private void generateSubsets(int[] nums, int subSetSize, List<List<Integer>> resList) {
		if (subSetSize == 1) {
			for (int num : nums) {
				resList.add(Arrays.asList(num));
			}
		} else {
			int[] subSet = new int[subSetSize];
			generateSubsetsHelper(nums, subSet, 0, 0, resList);
		}
	}

	private void generateSubsetsHelper(int[] nums, int[] subSet, int numIndex, int subSetIndex,
			List<List<Integer>> resList) {
		if (subSetIndex == subSet.length) {
			List<Integer> subSetElems = new ArrayList<Integer>();
			for (int elem : subSet) {
				subSetElems.add(elem);
			}
			resList.add(subSetElems);
			return;
		}

		int n = nums.length;
		int max = Math.min(n, n - subSet.length + subSetIndex);
		for (int i = numIndex; i <= max; i++) {
			subSet[subSetIndex] = nums[i];
			generateSubsetsHelper(nums, subSet, i + 1, subSetIndex + 1, resList);
		}

	}
}
