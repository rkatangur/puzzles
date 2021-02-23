package org.examples.arrays;

/**
 * 45. Jump Game II
 * 
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * 
 * Example 1: Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum
 * number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.
 * 
 * Example 2:
 * 
 * Input: nums = [2,3,0,1,4] Output: 2
 * 
 * 
 * @author rkata
 *
 */
public class JumpGame2 {

	public int jump(int[] nums) {
		int[] memo = new int[nums.length];
		return jump(nums, 0, memo);
	}

	public int jump(int[] nums, int position, int[] memo) {

		if (position >= nums.length - 1) {
			return 0;
		}

		if (memo[position] != 0) {
			return memo[position];
		}

		int furthestJump = Math.min(nums.length - 1, position + nums[position]);
		int numOfJumps = Integer.MAX_VALUE;

		for (int i = furthestJump; i > position; i--) {
			int curNumOfJumps = jump(nums, i, memo);
			if (curNumOfJumps >= 0) {
				numOfJumps = Math.min(curNumOfJumps + 1, numOfJumps);
			}
		}

		if (numOfJumps == Integer.MAX_VALUE) {
			memo[position] = -1;
		}
		return memo[position];
	}

//	public boolean canJumpBottomUp(int[] nums) {
//		int[] memo = new int[nums.length];
//		memo[nums.length - 1] = 1;
//
//		for (int i = nums.length - 2; i >= 0; i--) {
//			int furthestMove = Math.min(i + nums[i], nums.length - 1);
//			for (int j = i + 1; j <= furthestMove; j++) {
//				if (memo[j] == 1) {
//					memo[i] = 1;
//					break;
//				}
//			}
//		}
//
//		return (memo[0] == 1);
//	}

}
