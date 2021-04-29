package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 697. Degree of an Array
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,3,1] Output: 2 Explanation: The input array has a degree
 * of 2 because both elements 1 and 2 appear twice. Of the subarrays that have
 * the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2,
 * 2, 3], [2, 2] The shortest length is 2. So return 2. Example 2:
 * 
 * Input: nums = [1,2,2,3,1,4,2] Output: 6 Explanation: The degree is 3 because
 * the element 2 is repeated 3 times. So [2,2,3,1,4,2] is the shortest subarray,
 * therefore returning 6.
 * 
 * 
 * Constraints:
 * 
 * nums.length will be between 1 and 50,000. nums[i] will be an integer between
 * 0 and 49,999.
 * 
 * 
 * @author rkata
 *
 */
public class DegreeOfAnArray {

	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> firstPosMap = new HashMap<>();
		Map<Integer, Integer> numCountMap = new HashMap<>();

		int degree = 0;
		int shortestLength = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			numCountMap.put(nums[i], numCountMap.getOrDefault(nums[i], 0) + 1);
			firstPosMap.putIfAbsent(nums[i], i);

			if (numCountMap.get(nums[i]) > degree) {
				shortestLength = i - firstPosMap.get(nums[i]) + 1;
				degree = numCountMap.get(nums[i]);
			} else if (numCountMap.get(nums[i]) == degree) {
				shortestLength = Math.min(shortestLength, i - firstPosMap.get(nums[i]) + 1);
			}
		}

		return shortestLength;
	}

}
