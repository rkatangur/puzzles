package org.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 368. Largest Divisible Subset
 * 
 * Given a set of distinct positive integers nums, return the largest subset
 * answer such that every pair (answer[i], answer[j]) of elements in this subset
 * satisfies:
 * 
 * answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0 If there are
 * multiple solutions, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [1,2] Explanation: [1,3] is also accepted.
 * Example 2:
 * 
 * Input: nums = [1,2,4,8] Output: [1,2,4,8]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 1 <= nums[i] <= 2 * 109 All the integers in nums are
 * unique.
 * 
 * @author rkata
 *
 */
public class LargestDivisibleSubset {

	public List<Integer> largestDivisibleSubset(int[] nums) {

		Arrays.sort(nums);
		Map<Integer, List<Integer>> mapOfSubsets = new HashMap<>();

		List<Integer> maxSubSet = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> subSet = largestDivisibleSubset(nums, mapOfSubsets, i);
			if (maxSubSet.size() < subSet.size()) {
				maxSubSet = subSet;
			}
		}

		return maxSubSet;
	}

	public List<Integer> largestDivisibleSubset(int[] nums, Map<Integer, List<Integer>> mapOfSubsets, int index) {
		if (mapOfSubsets.containsKey(index)) {
			return mapOfSubsets.get(index);
		}

		List<Integer> maxSubSet = new ArrayList<Integer>();
		for (int k = 0; k < index; k++) {
			if (nums[k] % nums[index] == 0) {
				List<Integer> curSubSet = largestDivisibleSubset(nums, mapOfSubsets, k);
				if (maxSubSet.size() < curSubSet.size()) {
					maxSubSet = curSubSet;
				}
			}
		}

		// Extend the found subset with the element itself.
		List<Integer> newEntry = new ArrayList<>();
		newEntry.addAll(maxSubSet);
		newEntry.add(nums[index]);
		mapOfSubsets.put(index, newEntry);

		return newEntry;
	}

}
