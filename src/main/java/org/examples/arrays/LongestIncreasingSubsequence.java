package org.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 300. Longest Increasing Subsequence
 * 
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * 
 * A subsequence is a sequence that can be derived from an array by deleting
 * some or no elements without changing the order of the remaining elements. For
 * example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
 * increasing subsequence is [2,3,7,101], therefore the length is 4. Example 2:
 * 
 * Input: nums = [0,1,0,3,2,3] Output: 4 Example 3:
 * 
 * Input: nums = [7,7,7,7,7,7,7] Output: 1
 * 
 * @author rkata
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence solver = new LongestIncreasingSubsequence();
//		int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
//
////		0,3,1,6,2,2,7
//		System.out.println(solver.lengthOfLIS(nums));
		System.out.println(solver.lengthOfLIS(new int[] { 0, 3, 1, 6, 2, 2, 7 }));
	}

	public int lengthOfLIS(int[] nums) {
		// int[][] memo = new int[nums.length + 1][nums.length];
		int memo[][] = new int[nums.length + 1][nums.length];
		for (int[] l : memo) {
			Arrays.fill(l, -1);
		}
		return lengthOfLISHelperDP(nums, -1, 0, memo);
	}

	public int lengthOfLISHelperDP(int[] nums, int prevIndex, int curIndex, int[][] memo) {
		if (curIndex >= nums.length) {
			return 0;
		}

		if (memo[prevIndex + 1][curIndex] >= 0) {
			return memo[prevIndex + 1][curIndex];
		}

		int taken = 0;
		if (prevIndex < 0 || nums[curIndex] > nums[prevIndex]) {
			taken = 1 + lengthOfLISHelperDP(nums, curIndex, curIndex + 1, memo);
		}

		int notTaken = lengthOfLISHelperDP(nums, prevIndex, curIndex + 1, memo);
		memo[prevIndex + 1][curIndex] = Math.max(taken, notTaken);
		return memo[prevIndex + 1][curIndex];
	}

	List<Integer> longestList = new ArrayList<Integer>();
	List<List<Integer>> allPossibleLis = new ArrayList<List<Integer>>();

	public void lengthOfLISHelper(int[] nums, int prevVal, int curIndex, List<Integer> lisElements) {
		if (curIndex >= nums.length) {
			List<Integer> newLis = new ArrayList<Integer>(lisElements);
			allPossibleLis.add(newLis);
			if (newLis.size() > longestList.size()) {
				longestList = newLis;
			}
			return;
		}

		if (nums[curIndex] > prevVal) {
			lisElements.add(nums[curIndex]);
			lengthOfLISHelper(nums, nums[curIndex], curIndex + 1, lisElements);
			lisElements.remove(lisElements.size() - 1);
		}

		lengthOfLISHelper(nums, prevVal, curIndex + 1, lisElements);
	}

//	public int lengthOfLIS(int[] nums) {
//		int[] dp = new int[nums.length];
//		dp[0] = 1;
//		
//		int maxLIS = 1;
//		for (int i = 0; i < nums.length; i++) {
//			int maxSubSeqLength = 1;
//			for (int j = 0; j < i; j++) {
//				if(nums[i] >nums[j]) {
//					maxSubSeqLength  = Math.max(maxSubSeqLength, dp[j] +1);
//				}
//			}
//			
//			dp[i] = maxSubSeqLength;			
//			maxLIS = Math.max(maxLIS, maxSubSeqLength); 
//		}
//
//		return maxLIS;
//	}
}
