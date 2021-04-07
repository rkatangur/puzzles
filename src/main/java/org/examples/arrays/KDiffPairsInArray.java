package org.examples.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array.
 * 
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are
 * true:
 * 
 * 0 <= i, j < nums.length i != j |nums[i] - nums[j]| == k Notice that |val|
 * denotes the absolute value of val.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,4,1,5], k = 2 Output: 2 Explanation: There are two 2-diff
 * pairs in the array, (1, 3) and (3, 5). Although we have two 1s in the input,
 * we should only return the number of unique pairs. Example 2:
 * 
 * Input: nums = [1,2,3,4,5], k = 1 Output: 4 Explanation: There are four 1-diff
 * pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5). Example 3:
 * 
 * Input: nums = [1,3,1,5,4], k = 0 Output: 1 Explanation: There is one 0-diff
 * pair in the array, (1, 1). Example 4:
 * 
 * Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3 Output: 2 Example 5:
 * 
 * Input: nums = [-1,-2,-3], k = 1 Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 -107 <= nums[i] <= 107 0 <= k <= 107
 * 
 * 
 * 
 * @author rkata
 *
 */

public class KDiffPairsInArray {

	public static void main(String[] args) {
		KDiffPairsInArray solver = new KDiffPairsInArray();
		int[] numsArr = new int[] { 1, 1, 1, 1 };
		System.out.println(solver.findPairs(numsArr, 0));
		System.out.println(solver.findPairsUsingTwoPointers(numsArr, 0));

		int[] numsArr1 = new int[] { 3, 1, 4, 1, 5 };
		System.out.println(solver.findPairs(numsArr1, 2));
		System.out.println(solver.findPairsUsingTwoPointers(numsArr1, 2));
	}

	public int findPairs(int[] nums, int k) {
		Map<Integer, Integer> numsMap = new HashMap<>();
		for (int num : nums) {
			numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
		}

		int result = 0;
		for (Map.Entry<Integer, Integer> numsMapEntry : numsMap.entrySet()) {
			int numVal = numsMapEntry.getKey();
			int numCount = numsMapEntry.getValue();
			if (numsMap.containsKey(numVal + k)) {
				result++;
			} else if (k == 0 && numCount > 0) {
				result++;
			}
		}

		return result;
	}

	/**
	 * 
	 * Approach 2: Two Pointers
	 * 
	 * 
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairsUsingTwoPointers(int[] nums, int k) {
		Arrays.sort(nums);
		int leftPointer = 0;
		int rightPointer = 1;

		int result = 0;

		while (leftPointer < nums.length && rightPointer < nums.length) {

			if (leftPointer == rightPointer || nums[rightPointer] - nums[leftPointer] < k) {
				rightPointer++;
			} else if (nums[rightPointer] - nums[leftPointer] > k) {
				leftPointer++;
			} else {
				result++;
				leftPointer++;

				while (leftPointer < nums.length && nums[leftPointer] == nums[leftPointer - 1]) {
					leftPointer++;
				}
			}
		}

		return result;
	}

}
