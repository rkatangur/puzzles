package org.examples.search;

/**
 * 
 * Suppose an array of length n sorted in ascending order is rotated between 1
 * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * 
 * [4,5,6,7,0,1,2] if it was rotated 4 times. [0,1,2,4,5,6,7] if it was rotated
 * 7 times. Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
 * results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums, return the minimum element of this
 * array.
 * 
 * 
 * 
 * @author rkata
 *
 */
public class FindMinNumberInSortedArray {

	public static void main(String[] args) {
		FindMinNumberInSortedArray solver = new FindMinNumberInSortedArray();
//		int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
//		System.out.println(solver.findMin(arr));
//		int[] arr = new int[] {2,3,4,5,1};
//		System.out.println(solver.findMin(arr));
//		System.out.println(solver.findMin(new int[] {2,2,2,0,1}));
		System.out.println(solver.findMin(new int[] { 1, 1, 1 }));
	}

	public int findMin(int[] nums) {
		int startPos = 0;
		int endPos = nums.length - 1;

		while (startPos <= endPos) {
			int pivot = startPos + (endPos - startPos) / 2;

			if (nums[pivot] < nums[endPos]) {
				endPos = pivot;
			} else if (nums[pivot] > nums[endPos]) {
				startPos = pivot + 1;
			} else {
				endPos = endPos - 1;
			}
		}

		return nums[startPos];
	}


}
