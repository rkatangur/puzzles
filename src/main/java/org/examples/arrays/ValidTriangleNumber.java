package org.examples.arrays;

import java.util.Arrays;

/**
 * 
 * 611. Valid Triangle Number
 * 
 * Given an array consists of non-negative integers, your task is to count the
 * number of triplets chosen from the array that can make triangles if we take
 * them as side lengths of a triangle.
 * 
 * Example 1: Input: [2,2,3,4] Output: 3
 * 
 * Explanation: Valid combinations are: 2,3,4 (using the first 2) 2,3,4 (using
 * the second 2) 2,2,3
 * 
 * Note: The length of the given array won't exceed 1000. The integers in the
 * given array are in the range of [0, 1000].
 * 
 * @author rkata
 *
 */
public class ValidTriangleNumber {

	public static void main(String[] args) {
		ValidTriangleNumber solver = new ValidTriangleNumber();
//		System.out.println(solver.triangleNumber(new int[] { 2, 2, 3, 4 }));
		System.out.println(solver.triangleNumber(new int[] { 1, 3, 5, 8, 9, 10, 11, 11, 13, 20 }));
	}

	public int triangleNumber(int[] nums) {

		Arrays.sort(nums);

		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length && nums[i] != 0; j++) {
				while (k < nums.length && nums[i] + nums[j] > nums[k]) {
					k++;
				}

				count += k - j - 1;
			}
		}

		return count;
	}

}
