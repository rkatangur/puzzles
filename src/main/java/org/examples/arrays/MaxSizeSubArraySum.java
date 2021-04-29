package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. Maximum Size Subarray Sum Equals k
 * 
 * Given an integer array nums and an integer k, return the maximum length of a
 * subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,-1,5,-2,3], k = 3 Output: 4 Explanation: The subarray [1,
 * -1, 5, -2] sums to 3 and is the longest. Example 2:
 * 
 * Input: nums = [-2,-1,2,1], k = 1 Output: 2 Explanation: The subarray [-1, 2]
 * sums to 1 and is the longest.
 * 
 * @author rkata
 *
 */
public class MaxSizeSubArraySum {

	public int maxSubArrayLen(int[] nums, int k) {
		int maxSubArrayLength = Integer.MIN_VALUE;
		Map<Integer, Integer> prefSumMap = new HashMap<>();
		prefSumMap.put(0, 0);
		int curSum = 0;

		for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];

			if (prefSumMap.containsKey(curSum - k)) {
				maxSubArrayLength = Math.max(maxSubArrayLength, (i - prefSumMap.get(curSum - k)));
			}

			if (!prefSumMap.containsKey(curSum)) {
				prefSumMap.put(curSum, i);
			}
//			prefSums[i + 1] = prefSums[i] + nums[i];
		}

		return maxSubArrayLength;
	}

}
