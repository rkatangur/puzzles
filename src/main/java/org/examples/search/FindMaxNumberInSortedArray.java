package org.examples.search;

public class FindMaxNumberInSortedArray {

	// 1,3, 5, 8, 9, 10, 11, 11, 13, 20
	// Find the index of the element in the arr[i] which is >= elem
	public int binarySearch(int[] arr, int l, int r, int elem) {

		// if i =0, j=2, next greater element between indexes of 3 to 9 that is greater
		// than 1+5(6) is 8 at index 3
		while (l <= r) {
			int mid = l + (r - l) / 2;
			System.out.println("l " + l + ", r " + r + ", mid " + mid);
			if (arr[mid] >= elem) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return l;
	}

	public static void main(String[] args) {
		FindMaxNumberInSortedArray solver = new FindMaxNumberInSortedArray();
		System.out.println(solver.binarySearch(new int[] { 1, 3, 5, 8, 9, 10, 11, 11, 13, 20 }, 2, 9, 6));
	}

}
