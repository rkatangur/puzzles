package org.examples.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * 
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2] Output: [[],[1],[1,2],[1,2,2],[2],[2,2]] Example 2:
 * 
 * Input: nums = [0] Output: [[],[0]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10 -10 <= nums[i] <= 10
 * 
 * 
 * @author rkata
 *
 */
public class GenerateSubsetsII {

	public static void main(String[] args) {
		GenerateSubsetsII solver = new GenerateSubsetsII();
		List<List<Integer>> subsets = solver.subsetsWithDup(new int[] { 1, 2, 2 });
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		subsetsWithDupHelper(nums, 0, new ArrayList<Integer>(), results);
		return results;
	}

	public void subsetsWithDupHelper(int[] nums, int numIndex, List<Integer> subset, List<List<Integer>> results) {
		results.add(new ArrayList<Integer>(subset));

		for (int i = numIndex; i < nums.length; i++) {
			if (i > numIndex && nums[i] == nums[i - 1]) {
				continue;
			}
			subset.add(nums[i]);
			subsetsWithDupHelper(nums, i + 1, subset, results);
			subset.remove(subset.size() - 1);
		}
	}

	public List<List<Integer>> subsetsWithDupV2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		results.add(new ArrayList<Integer>());

		for (int i = 1; i <= nums.length; i++) {
			int[] subset = new int[i];
			subsetsWithDupHelperV2(nums, 0, subset, 0, results);
		}

		return results;
	}

	public void subsetsWithDupHelperV2(int[] nums, int numIndex, int[] subset, int subsetIndex,
			List<List<Integer>> results) {
		if (subsetIndex >= subset.length) {
			List<Integer> res = new ArrayList<Integer>();
			for (int num : subset) {
				res.add(num);
			}
			results.add(res);

			return;
		}

		for (int i = numIndex; i < nums.length; i++) {
			if (i > numIndex && nums[i] == nums[i - 1]) {
				continue;
			}
			subset[subsetIndex] = nums[i];
			subsetsWithDupHelperV2(nums, i + 1, subset, subsetIndex + 1, results);
		}
	}

}
