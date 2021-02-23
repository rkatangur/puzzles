package org.examples.arrays;

/**
 * 
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position. Determine if you are able to reach the last index.
 * 
 * Example 1: Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step
 * from index 0 to 1, then 3 steps to the last index.
 * 
 * 
 * @author rkata
 *
 */
public class JumpGame {

	public boolean canJump(int[] nums) {
		int[] memo = new int[nums.length];
		return canJump(nums, 0, memo);
	}

	public boolean canJump(int[] nums, int position, int[] memo) {

		if (position >= nums.length - 1) {
			return true;
		}

		if (memo[position] == 1) {
			return true;
		} else if (memo[position] == -1) {
			return false;
		}

		boolean canJump = false;
		int furthestJump = Math.min(nums.length - 1, position + nums[position]);

		for (int i = furthestJump; i > position; i--) {
			canJump = canJump(nums, i, memo);
			if (canJump) {
				memo[i] = 1;
				break;
			} else {
				memo[i] = -1;
			}
		}

		return canJump;
	}

	public boolean canJumpBottomUp(int[] nums) {
		int[] memo = new int[nums.length];
		memo[nums.length - 1] = 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			int furthestMove = Math.min(i + nums[i], nums.length - 1);
			for (int j = i + 1; j <= furthestMove; j++) {
				if (memo[j] == 1) {
					memo[i] = 1;
					break;
				}
			}
		}

		return (memo[0] == 1);
	}

}
