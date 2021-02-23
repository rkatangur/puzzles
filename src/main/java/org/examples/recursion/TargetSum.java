package org.examples.recursion;

/**
 * 
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 Explanation:
 * 
 * -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * Constraints:
 * 
 * The length of the given array is positive and will not exceed 20. The sum of
 * elements in the given array will not exceed 1000. Your output answer is
 * guaranteed to be fitted in a 32-bit integer.
 * 
 * 
 * 
 * 
 * @author rkata
 *
 */
public class TargetSum {

	int totalNumOfWays=0;
	public static void main(String[] args) {
		TargetSum solver = new TargetSum();
		System.out.println(solver.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
		System.out.println("totalNumOfWays "+solver.totalNumOfWays);
	}

	public int findTargetSumWays(int[] nums, int S) {
		return findTargetSumWays(nums, 0, 0, S);
	}

	public int findTargetSumWays(int[] nums, int index, int targetSum, int S) {
		if (index >= nums.length) {
			totalNumOfWays++;
			if (targetSum == S) {
				return 1;
			}
			return 0;
		}

//		return  findTargetSumWays(nums, index + 1, targetSum + nums[index], S);
		return findTargetSumWays(nums, index + 1, targetSum + nums[index], S)
				+ findTargetSumWays(nums, index + 1, targetSum - nums[index], S);
	}
}
