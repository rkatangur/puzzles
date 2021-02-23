package org.examples.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * Example 2:
 * 
 * Input: nums = [0,1] Output: [[0,1],[1,0]]
 * 
 * Example 3:
 * 
 * Input: nums = [1] Output: [[1]]
 * 
 * @param nums
 * @return
 */
public class PermutationsNumber {

	public static void main(String[] args) {
		PermutationsNumber solver = new PermutationsNumber();
		List<List<Integer>> resList = solver.permute(new int[] { 1, 2, 3 });
		for (List<Integer> res : resList) {
			for (Integer num : res) {
				System.out.print(num + ",");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		backtrack(nums, 0, result);
		return result;
	}

	public void backtrack(int[] nums, int startIndex, List<List<Integer>> result) {
		if (startIndex == nums.length) {
			List<Integer> permList = new ArrayList<Integer>();
			for (int num : nums) {
				permList.add(num);
			}
			result.add(permList);
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			swap(nums, i, startIndex);
			backtrack(nums, startIndex + 1, result);
			swap(nums, i, startIndex);
		}
	}

	private void swap(int[] nums, int i, int startIndex) {
		int temp = nums[i];
		nums[i] = nums[startIndex];
		nums[startIndex] = temp;
	}

}
