package org.examples.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: n = 4, k = 2
 * 
 * Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * 
 * Example 2:
 * 
 * Input: n = 1, k = 1
 * 
 * Output: [[1]]
 * 
 * @author rkata
 *
 */

public class CombinationNumber {

	public static void main(String[] args) {
		CombinationNumber solver = new CombinationNumber();
		List<List<Integer>> resList = solver.combine(4, 2);
		for (List<Integer> res : resList) {
			for (Integer num : res) {
				System.out.print(num + ",");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		int[] nums = new int[n];
		for (int i = 1; i <= n; i++) {
			nums[i - 1] = i;
		}
		
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		generateCombinations(nums, k, resList);
		return resList;
	}

	public void generateCombinations(int[] nums, int k, List<List<Integer>> resList) {
		int[] comb = new int[k];
		generateCombinationsHelper(nums, 0, comb, 0, resList);
	}

	public void generateCombinationsHelper(int[] nums, int numIndex, int[] comb, int combIndex,
			List<List<Integer>> resList) {
		if (combIndex == comb.length) {
			List<Integer> combList = new ArrayList<Integer>();
			for (int c : comb) {
				combList.add(c);
			}
			resList.add(combList);
			return;
		}

		int max = Math.min(nums.length, nums.length - comb.length + combIndex);
		for (int i = numIndex; i <= max; i++) {
			comb[combIndex] = nums[i];
			generateCombinationsHelper(nums, i + 1, comb, combIndex + 1, resList);
		}
	}
}
