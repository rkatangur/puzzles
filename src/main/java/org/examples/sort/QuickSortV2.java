package org.examples.sort;

import org.examples.arrays.ArraysUtil;

public class QuickSortV2 {

	public static void main(String[] args) {
		QuickSortV2 solver = new QuickSortV2();
		int[] nums = new int[] { 15, 3, 2, 1, 9, 5, 7, 8, 6 };
		solver.quickSort(nums);
		ArraysUtil.printIntArr(nums);
	}

	private void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}

	private void quickSort(int[] nums, int i, int j) {
		if (i >= j) {
			return;
		}

		int pivotIndex = (i + j) / 2;
		int partitionIndex = partion(nums, i, j, pivotIndex);
		quickSort(nums, i, partitionIndex - 1);
		quickSort(nums, partitionIndex + 1, j);
	}

	private int partion(int[] nums, int left, int right, int pivotIndex) {
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

	private void swap(int[] nums, int pivotIndex, int right) {
		int temp = nums[pivotIndex];
		nums[pivotIndex] = nums[right];
		nums[right] = temp;
	}

}
