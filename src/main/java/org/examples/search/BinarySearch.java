package org.examples.search;

import java.util.Arrays;

public class BinarySearch {

	public int binarySearch(int[] inputArr, int key) {
		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				System.out.println(inputArr[mid]);
				return mid;
			}

			System.out.println(inputArr[mid]);
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public int binarySearch(int[] intArr, int key, int lowerBound, int upperBound) {

		if (lowerBound >= upperBound) {
			return -1;
		}

		int mid = (lowerBound + upperBound) / 2;
		if (intArr[mid] == key) {
			// found the element
			return intArr[mid];
		} else if (intArr[mid] < key) {
			return binarySearch(intArr, key, mid + 1, upperBound);
		} else {
			return binarySearch(intArr, key, lowerBound, mid - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.binarySearch(new int[] {}, 1));

		System.out.println(Arrays.binarySearch(new int[] { 2, 3, 6, 7, 8, 9 }, 4));

		int[] arr = new int[] { -4, -2, 1, 3 };
		System.out.println(Arrays.binarySearch(arr, 6));
		System.out.println(Arrays.binarySearch(arr, -7));

//    BinarySearch bs = new BinarySearch();
//    int[] arr = {3, 8, 22, 29, 43, 55, 61, 74, 78, 95, 96};
//    // System.out.println("Key position: " + bs.binarySearch(arr, 29));
//    // System.out.println("Key position: " + bs.binarySearch(arr, 21));
//
//    System.out.println("Key position " + bs.binarySearch(arr, 29, 0, arr.length - 1));
	}
}
