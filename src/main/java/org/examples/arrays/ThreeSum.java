package org.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Example 2:
 * 
 * Input: nums = [] Output: [] Example 3:
 * 
 * Input: nums = [0] Output: []
 * 
 * 
 * 
 * @author rkata
 *
 */

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum solver = new ThreeSum();
		solver.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
	}

//	public List<List<Integer>> threeSum(int[] nums) {
//		Set<List<Integer>> subArrays = new HashSet<>();
//		Set<Integer> dups = new HashSet<>();
//
//		threeSumHelper(0, nums.length - 1, nums, new int[3], 0, subArrays, 0, dups);
//
//		return new ArrayList<>(subArrays);
//	}
//
//	private void threeSumHelper(int startIndex, int endIndex, int[] nums, int[] subArr, int subArrIndex,
//			Set<List<Integer>> subArrays, int curSum, Set<Integer> dups) {
//
//		if (subArrIndex >= 2) {
//			if (curSum == 0) {
//				// record the array.
//				Arrays.sort(subArr);
//				subArrays.add(Arrays.asList(subArr[0], subArr[1], subArr[2]));
//			}
//			return;
//		}
//
//		if (startIndex > endIndex || dups.contains(nums[startIndex])) {
//			return;
//		}
//
//		subArr[subArrIndex] = nums[startIndex];
//		dups.add(nums[startIndex]);
//		threeSumHelper(startIndex + 1, endIndex, nums, subArr, subArrIndex + 1, subArrays, curSum + nums[startIndex],
//				dups);
//		threeSumHelper(startIndex + 1, endIndex, nums, subArr, subArrIndex, subArrays, curSum, dups);
//	}

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		Set<Integer> dups = new HashSet<>();
		Map<Integer, Integer> seen = new HashMap<>();
		for (int i = 0; i < nums.length; ++i)
			if (dups.add(nums[i])) {
				for (int j = i + 1; j < nums.length; ++j) {
					int complement = -nums[i] - nums[j];
					if (seen.containsKey(complement) && seen.get(complement) == i) {
						List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
						Collections.sort(triplet);
						res.add(triplet);
					}
					seen.put(nums[j], i);
				}
			}
		return new ArrayList<>(res);
	}

}
