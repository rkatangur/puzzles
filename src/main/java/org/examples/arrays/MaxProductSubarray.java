package org.examples.arrays;

/**
 * 
 * 
 * 152. Maximum Product Subarray Given an integer array nums, find a contiguous
 * non-empty subarray within the array that has the largest product, and return
 * the product.
 * 
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product
 * 6. Example 2:
 * 
 * Input: nums = [-2,0,-1] Output: 0 Explanation: The result cannot be 2,
 * because [-2,-1] is not a subarray.
 * 
 * 
 * @author rkata
 *
 */
public class MaxProductSubarray {

	public static void main(String[] args) {
		MaxProductSubarray solver = new MaxProductSubarray();
		System.out.println(solver.maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(solver.maxProduct(new int[] { -2, 0, -1 }));
	}

	public int maxProduct(int[] nums) {

		int max_so_far = nums[0];
		int min_so_far = nums[0];
		int result = max_so_far;
		for (int i = 1; i < nums.length; i++) {
			int temp_max_so_far = Math.max(nums[i], Math.max(nums[i] * max_so_far, nums[i] * min_so_far));
			min_so_far = Math.min(nums[i], Math.min(nums[i] * max_so_far, nums[i] * min_so_far));
			max_so_far = temp_max_so_far;
			
			result = Math.max(result, max_so_far);
		}

		return result;
	}

}
