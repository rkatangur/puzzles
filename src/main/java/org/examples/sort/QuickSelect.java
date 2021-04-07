package org.examples.sort;

import java.util.Random;

public class QuickSelect {

	public static void main(String[] args) {
//		[3,2,1,5,6,4]
//				2
		QuickSelect solver = new QuickSelect();
		System.out.println(solver.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
	}

	Random random_num = new Random();
    public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, nums.length - k);
	}

	public int findKthSmallest(int[] nums, int k) {
		return quickSelect(nums, k);
	}

	private int quickSelect(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, k);
	}

	private int quickSelect(int[] nums, int left, int right, int k) {
		if (left >= right) {
			return nums[left];
		}

//		int pivotIndex = left + (right - left) / 2;

		// select a random pivot_index
		// Random random_num = new Random();
		int pivotIndex = left + random_num.nextInt(right - left);

		pivotIndex = partition(nums, left, right, pivotIndex);

		if (k < pivotIndex) {
			return quickSelect(nums, left, pivotIndex - 1, k);
		} else if (k > pivotIndex) {
			return quickSelect(nums, pivotIndex+1, right, k);
		} else {
			return nums[pivotIndex];
		}
	}

//	private int partition(int[] nums, int left, int right, int pivotIndex) {
//		int pivotVal = nums[pivotIndex];
//		while (left <= right) {
//			while (nums[left] < pivotVal) {
//				left++;
//			}
//
//			while (nums[right] > pivotVal) {
//				right--;
//			}
//
//			if (left <= right) {
//				// swap elements
//				swap(nums, left, right);
//				left++;
//				right--;
//			}
//		}
//
//		return left;
//	}

	private int partition(int[] nums, int left, int right, int pivotIndex) {
		int pivotVal = nums[pivotIndex];
		swap(nums, pivotIndex, right);
		int partionIndex = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] < pivotVal) {
				swap(nums, i, partionIndex);
				partionIndex++;
			}
		}
		swap(nums, partionIndex, right);
		return partionIndex;
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}
