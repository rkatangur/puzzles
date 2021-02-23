package org.examples.recursion;

import java.util.ArrayList;
import java.util.List;

import org.examples.arrays.ArraysUtil;

/**
 * 
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used. Each number is used at most once. Return a
 * list of all possible valid combinations. The list must not contain the same
 * combination twice, and the combinations may be returned in any order.
 * 
 * @author rkata
 *
 */

public class CombinationSumIII {

	public static void main(String[] args) {
		CombinationSumIII solver = new CombinationSumIII();
		List<List<Integer>> resList = solver.combinationSum3(3, 7);
		ArraysUtil.printIterables(resList);
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		int[] nums = new int[9];
		for (int i = 1; i <= 9; i++) {
			nums[i - 1] = i;
		}
		int[] comb = new int[k];
		int numIndex = 0;
		int combIndex = 0;
		combinationSum3(nums, numIndex, comb, combIndex, n, resList);
		return resList;
	}

	public void combinationSum3(int[] nums, int numIndex, int[] comb, int combIndex, int targetSum,
			List<List<Integer>> resList) {
		if (targetSum < 0) {
			return;
		}

		if (combIndex == comb.length) {
			if (targetSum == 0) {
				List<Integer> combList = new ArrayList<Integer>();
				for (int combNum : comb) {
					combList.add(combNum);
				}

				resList.add(combList);
			}
			return;
		}

		for (int i = numIndex; i < nums.length; i++) {
			comb[combIndex] = nums[i];
			combinationSum3(nums, i+1, comb, combIndex + 1, targetSum - comb[combIndex], resList);
		}
	}

}
