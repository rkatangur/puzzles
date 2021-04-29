package org.examples.arrays;

/**
 * 
 * 303. Range Sum Query - Immutable Given an integer array nums, find the sum of
 * the elements between indices left and right inclusive, where (left <= right).
 * Implement the NumArray class:
 * 
 * NumArray(int[] nums) initializes the object with the integer array nums. int
 * sumRange(int left, int right) returns the sum of the elements of the nums
 * array in the range [left, right] inclusive (i.e., sum(nums[left], nums[left +
 * 1], ... , nums[right])).
 * 
 * 
 * Example 1:
 * 
 * Input ["NumArray", "sumRange", "sumRange", "sumRange"] [[[-2, 0, 3, -5, 2,
 * -1]], [0, 2], [2, 5], [0, 5]] Output [null, 1, -1, -3]
 * 
 * Explanation NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3) numArray.sumRange(2, 5);
 * // return -1 (3 + (-5) + 2 + (-1)) numArray.sumRange(0, 5); // return -3
 * ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 -105 <= nums[i] <= 105 0 <= left <= right <
 * nums.length At most 104 calls will be made to sumRange.
 * 
 */
public class RangeSumQuery1D_Immutable {

	int[] prefSumArr = null;

	public RangeSumQuery1D_Immutable(int[] nums) {
		prefSumArr = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			prefSumArr[i + 1] = prefSumArr[i] + nums[i];
		}
	}

	public int sumRange(int left, int right) {
		int sumTillLeftIndex = prefSumArr[left];
		int sumTillRightIndex = prefSumArr[right + 1];
		return sumTillRightIndex - sumTillLeftIndex;
	}

}
