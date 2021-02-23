package org.examples.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> allUniquePermutations = new ArrayList<List<Integer>>();
		Set<String> uniqPerms = new HashSet<String>();
		permuteUniqueHelper(nums, 0, allUniquePermutations, uniqPerms);
		return allUniquePermutations;
	}

	public void permuteUniqueHelper(int[] nums, int startIndex, List<List<Integer>> allPermutations,
			Set<String> uniqPerms) {
		if (startIndex == nums.length) {
			StringBuilder sb = new StringBuilder();

			List<Integer> permRes = new ArrayList<Integer>();
			for (int num : nums) {
				permRes.add(num);
				sb.append(num);
			}

			if (!uniqPerms.contains(sb.toString())) {
				uniqPerms.add(sb.toString());
				allPermutations.add(permRes);
			}

			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			swap(nums, startIndex, i);
			permuteUniqueHelper(nums, startIndex + 1, allPermutations, uniqPerms);
			swap(nums, startIndex, i);
		}
	}

	private void swap(int[] nums, int startIndex, int i) {
		int temp = nums[startIndex];
		nums[startIndex] = nums[i];
		nums[i] = temp;
	}

}
