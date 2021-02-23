package org.examples.recursion;

import java.util.ArrayList;
import java.util.List;

import org.examples.arrays.ArraysUtil;

/**
 * 
 * 39. Combination Sum
 * 
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order. The same
 * number may be chosen from candidates an unlimited number of times. Two
 * combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * It is guaranteed that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7
 * 
 * Output: [[2,2,3],[7]]
 * 
 * Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be
 * used multiple times. 7 is a candidate, and 7 = 7. These are the only two
 * combinations.
 * 
 * 
 * @author rkata
 *
 */

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum solver = new CombinationSum();
		List<List<Integer>> resList = solver.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		ArraysUtil.printIterables(resList);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		List<Integer> combination = new ArrayList<Integer>();
		backtrack(candidates, 0, combination, 0, target, resList);
		return resList;
	}

	public void backtrack(int[] candidates, int pos, List<Integer> combination, int curSum, int target,
			List<List<Integer>> resList) {
		if (curSum == target) {
			resList.add(new ArrayList<Integer>(combination));
			return;
		} else if (curSum > target) {
			return;
		}

		for (int i = pos; i < candidates.length; i++) {
			combination.add(candidates[i]);
			backtrack(candidates, i, combination, candidates[i] + curSum, target, resList);
			combination.remove(combination.size() - 1);
		}
	}

}
