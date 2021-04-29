package org.examples.arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * 136. Single Number
 * 
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * Follow up: Could you implement a solution with a linear runtime complexity
 * and without using extra memory?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,2,1] Output: 1 Example 2:
 * 
 * Input: nums = [4,1,2,1,2] Output: 4 Example 3:
 * 
 * Input: nums = [1] Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 -3 * 104 <= nums[i] <= 3 * 104 Each element in
 * the array appears twice except for one element which appears only once.
 * 
 * 
 * @author rkata
 *
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		int totalSum = 0;
		int totalUniqNumSum = 0;
		HashSet<Integer> uniqNums = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!uniqNums.contains(nums[i])) {
				totalUniqNumSum += nums[i];
				uniqNums.add(nums[i]);
			}
			totalSum += nums[i];
		}

		return totalUniqNumSum * 2 - totalSum;
	}

	/**
	 * 137. Single Number II
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumberII(int[] nums) {
		long totalSum = 0;
		long totalUniqNumSum = 0;
		HashSet<Integer> uniqNums = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!uniqNums.contains(nums[i])) {
				totalUniqNumSum += nums[i];
				uniqNums.add(nums[i]);
			}
			totalSum += nums[i];
		}

		long result = (totalUniqNumSum * 3 - totalSum) / 2;

		return (int) result;
	}

	/**
	 * 
	 * 260. Single Number III
	 * 
	 * @param nums
	 * @return
	 */
	public int[] singleNumberIII(int[] nums) {

		HashMap<Integer, Integer> numCountMap = new HashMap<>();

		for (int num : nums) {
			numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
		}

		int[] twoNums = new int[2];
		int twoNumIndex = 0;
		for (int num : nums) {
			if (numCountMap.get(num) == 1) {
				twoNums[twoNumIndex++] = num;
			}
		}

		return twoNums;
	}

}
