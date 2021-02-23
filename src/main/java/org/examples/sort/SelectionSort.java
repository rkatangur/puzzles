package org.examples.sort;

/**
 * 
 * Selection Sort The selection sort algorithm sorts an array by repeatedly
 * finding the minimum element (considering ascending order) from unsorted part
 * and putting it at the beginning. The algorithm maintains two subarrays in a
 * given array.
 * 
 * 1) The subarray which is already sorted. 2) Remaining subarray which is
 * unsorted.
 * 
 * In every iteration of selection sort, the minimum element (considering
 * ascending order) from the unsorted subarray is picked and moved to the sorted
 * subarray.
 * 
 * 
 * 
 * @author rkata
 *
 */

public class SelectionSort {

	public static void selectionSort1(int[] numArr) {

		for (int i = 0; i < numArr.length; i++) {
			int minElem = numArr[i];
			int minElemIndex = i;
			for (int j = i + 1; j < numArr.length; j++) {
				if (numArr[j] < minElem) {
					minElemIndex = j;
				}
			}
			int tempElem = numArr[i];
			numArr[i] = numArr[minElemIndex];
			numArr[minElemIndex] = tempElem;
		}

	}

	public static void main(String[] args) {
		int[] numArray = new int[] { 9, 4, 6, 3, 7, 2 };
		selectionSort1(numArray);
		for (int i : numArray) {
			System.out.print(i + ",");
		}
	}

	public static void selectionSort(int[] numArray) {
		for (int i = 0; i < numArray.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < numArray.length; j++) {
				if (numArray[j] < numArray[minIdx]) {
					minIdx = j;
				}
			}
			int tmp = numArray[i];
			numArray[i] = numArray[minIdx];
			numArray[minIdx] = tmp;
		}
	}

}
