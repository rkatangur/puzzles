package org.examples.arrays;

import java.util.TreeSet;

/**
 * 414. Third Maximum Number Given integer array nums, return the third maximum
 * number in this array. If the third maximum does not exist, return the maximum
 * number.
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,1] Output: 1 Explanation: The third maximum is 1.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2] Output: 2 Explanation: The third maximum does not exist,
 * so the maximum (2) is returned instead.
 * 
 * Example 3: Input: nums = [2,2,3,1] Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number. Both numbers with value 2 are both considered as second
 * maximum.
 * 
 * @author rkata
 *
 */
public class ThirdMaxNumber {

	public int thirdMax(int[] nums) {
		TreeSet<Integer> maximums = new TreeSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			maximums.add(nums[i]);
			if (maximums.size() > 3) {
				maximums.pollFirst();
			}
		}
		if (maximums.size() == 3) {
			return maximums.pollFirst();
		} else {
			return maximums.pollLast();
		}
	}
}
