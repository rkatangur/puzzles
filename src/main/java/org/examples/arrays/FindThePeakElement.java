package org.examples.arrays;

/**
 * 
 * 162. Find Peak Element A peak element is an element that is strictly greater
 * than its neighbors.
 * 
 * Given an integer array nums, find a peak element, and return its index. If
 * the array contains multiple peaks, return the index to any of the peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -Infinity.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
 * function should return the index number 2. Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 5 Explanation: Your function can return
 * either index number 1 where the peak element is 2, or index number 5 where
 * the peak element is 6.
 * 
 * @author rkata
 *
 */
public class FindThePeakElement {

	public static void main(String[] args) {
		FindThePeakElement solver = new FindThePeakElement();
		System.out.println(solver.findPeakElement(new int[] { 1, 2, 3, 1 }));
		System.out.println(solver.findPeakElementUsingBinarySearch(new int[] { 1, 2, 3, 1 }));

		System.out.println(solver.findPeakElement(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(solver.findPeakElementUsingBinarySearch(new int[] { 5, 4, 3, 2, 1 }));

		System.out.println(solver.findPeakElement(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(solver.findPeakElementUsingBinarySearch(new int[] { 1, 2, 3, 4, 5 }));

		System.out.println(solver.findPeakElement(new int[] { 2, 3, 4, 5, 1 }));
		System.out.println(solver.findPeakElementUsingBinarySearch(new int[] { 2, 3, 4, 5, 1 }));
	}

	public int findPeakElement(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return i;
			}
		}
		return nums.length - 1;
	}

	public int findPeakElementUsingBinarySearch(int[] nums) {
		int l = 0;
		int r = nums.length - 1;

		while (l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] > nums[mid + 1]) {
				r = mid;
			} else {
				l = mid+1;
			}
		}

		return l;
	}

}
