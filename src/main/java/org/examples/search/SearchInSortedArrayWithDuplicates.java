package org.examples.search;

/**
 * 
 * You are given an integer array nums sorted in ascending order (not
 * necessarily distinct values), and an integer target. Suppose that nums is
 * rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,4,4,5,6,6,7]
 * might become [4,5,6,6,7,0,1,2,4,4]). If target is found in the array return
 * its index, otherwise, return -1.
 * 
 * @author rkata
 *
 */
public class SearchInSortedArrayWithDuplicates {

	public static void main(String[] args) {
		float a =1f;
		float b = 0.00000000001f;
		
		float c = 0.0001f;
		
		System.out.println(a);
		System.out.println(a+b);
		System.out.println(a == (a+b));
		System.out.println(c);
		float df = (c+b);
		System.out.println((float)(c+b));
		System.out.println(c == (c+b));
		
//		SearchInSortedArrayWithDuplicates solver = new SearchInSortedArrayWithDuplicates();
////		System.out.println(solver.search(new int[] { 0, 1, 2, 4, 4, 4, 5, 6, 6, 7 }, 4));
////		System.out.println(solver.search(new int[] { 4, 5, 6, 6, 7, 0, 1, 2, 4, 4 }, 4));
////		System.out.println(solver.search(new int[] { 0, 1, 2, 4, 4, 5, 6, 6, 7, 0 }, 4));
////		System.out.println(solver.search(new int[] { 1, 0, 1, 1, 1 }, 0));
////		System.out.println(solver.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0));
////		System.out.println(solver.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3));
////		System.out.println(solver.search(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 }, 0));
////////
////		System.out.println(
////				solver.search(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 13));
////		System.out.println(solver.search(new int[] { 1, 2, 1 }, 1));
////////		
////		System.out.println(solver.search(new int[] { 3, 5, 1 }, 3));
//////
////		System.out.println(solver.search(new int[] { 0, 1, 1, 2, 0, 0 }, 2));
////		System.out.println(solver.search(new int[] { 3, 1, 2, 2, 2 }, 1));
////
//		int[] arr = new int[] { -9, -9, -9, -8, -8, -7, -7, -7, -7, -6, -6, -6, -6, -6, -6, -6, -6, -6, -5, -5, -5, -5,
//				-5, -4, -4, -4, -3, -3, -3, -3, -3, -3, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -1, -1, -1, -1, -1, -1,
//				0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7,
//				7, 8, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, -10, -9, -9, -9, -9 };
//		System.out.println(solver.search(arr, 2));
//
//		System.out.println(solver.search(new int[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 }, 25));

	}

	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return true;
			} else if (nums[left] == target || nums[right] == target) {
				return true;
			}

			if (nums[left] == nums[right]) {
				left++;
				right--;
				continue;
			}

			if (nums[left] == nums[mid]) {
				left = mid + 1;
			} else if (nums[right] == nums[mid]) {
				right = mid - 1;
			}
			// left half of the array is sorted rotated
			else if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid])
					right = mid - 1;
				else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] <= target && target < nums[right])
					left = mid + 1;
				else {
					right = mid - 1;
				}
			}
		}

		return false;
	}

}
