package org.examples.arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		MergeSortedArrays solver = new MergeSortedArrays();
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		int n = 3;

		solver.mergeV1(nums1, nums2);
	}

	public void merge(int[] nums1, int[] nums2, int n) {

	}

	public void mergeV1(int[] nums1, int[] nums2) {

		int[] nums1Copy = new int[nums1.length - nums2.length];
		for (int i = 0; i < nums1Copy.length; i++) {
			nums1Copy[i] = nums1[i];
		}

		int p1 = 0;
		int p2 = 0;
		int p = 0;

		while (p1 < nums1Copy.length || p2 < nums2.length) {
			if (p1 < nums1Copy.length && p2 < nums2.length) {
				if (nums1Copy[p1] < nums2[p2]) {
					nums1[p++] = nums1Copy[p1++];
				} else if (nums1Copy[p1] > nums2[p2]) {
					nums1[p++] = nums2[p2++];
				} else {
					nums1[p++] = nums1Copy[p1++];
					nums1[p++] = nums2[p2++];
				}
			} else if (p1 < nums1Copy.length) {
				nums1[p++] = nums1Copy[p1++];
			} else {
				nums1[p++] = nums2[p2++];
			}
		}
	}

	/**
	 * Merge using the back pointers
	 * 
	 * @param nums1
	 * @param nums2
	 */
	public void mergeV2(int[] nums1, int[] nums2) {

		int p1 = nums1.length - nums2.length - 1;
		int p2 = nums2.length - 1;
		int p = nums1.length - 1;

		while (p1 >= 0 || p2 >= 0) {
			if (p1 >= 0 && p2 >= 0) {
				if (nums1[p1] > nums2[p2]) {
					nums1[p--] = nums1[p1--];
				} else if (nums1[p1] < nums2[p2]) {
					nums1[p--] = nums2[p2--];
				} else {
					nums1[p--] = nums1[p1--];
					nums1[p--] = nums2[p2--];
				}
			} else if (p1 >= 0) {
				nums1[p--] = nums1[p1--];
			} else {
				nums1[p--] = nums2[p2--];
			}
		}
	}

}
