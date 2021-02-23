package org.examples.sort;

public class MergeSort {

	public static void sort1(int[] numarr) {
		mergeSort(numarr, 0, numarr.length - 1);
	}
	
	private static void mergeSort(int[] numArr, int startPos, int endPos) {
		if (startPos >= endPos) {
			return;
		}

		int mid = (startPos + endPos) / 2;

		mergeSort(numArr, startPos, mid);
		mergeSort(numArr, mid + 1, endPos);

		int startInFistHalf = startPos;
		int startInSecHalf = mid + 1;
		int posinSortedArr = 0;
		int[] sortedArr = new int[endPos - startPos + 1];
		while (startInFistHalf <= mid || startInSecHalf <= endPos) {
			if (startInFistHalf <= mid && startInSecHalf <= endPos) {
				if (numArr[startInFistHalf] <= numArr[startInSecHalf]) {
					sortedArr[posinSortedArr++] = numArr[startInFistHalf++];
				} else {
					sortedArr[posinSortedArr++] = numArr[startInSecHalf++];
				}
			} else if (startInFistHalf <= mid) {
				sortedArr[posinSortedArr++] = numArr[startInFistHalf++];
			} else if (startInSecHalf <= endPos) {
				sortedArr[posinSortedArr++] = numArr[startInSecHalf++];
			}
		}

		int indexPosInNumArr = startPos;
		for (int elem : sortedArr) {
			numArr[indexPosInNumArr++] = elem;
		}
	}

	public static void main(String[] args) {
		int[] arrayToSort = new int[] { 64, 21, 33, 70, 12, 85, 44, 3, 99, 0, 108, 36 };
		sort1(arrayToSort);
		
		for (int num : arrayToSort) {
			System.out.print(num + ",");
		}
	}

	public static void sort(int[] arrayToSort, int lowerBound, int upperBound, int[] sortedArray) {

		if (lowerBound == upperBound) {
			return;
		}

		int mid = (lowerBound + upperBound) / 2;

		sort(arrayToSort, lowerBound, mid, sortedArray);

		sort(arrayToSort, mid + 1, upperBound, sortedArray);

		merge(arrayToSort, lowerBound, mid + 1, upperBound, sortedArray);
	}

	private static void merge(int[] arrayToSort, int lowPtr, int highPtr, int upperBound, int[] sortedArray) {

		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1; // # of items

		while (lowPtr <= mid && highPtr <= upperBound) {
			if (arrayToSort[lowPtr] < arrayToSort[highPtr]) {
				sortedArray[j++] = arrayToSort[lowPtr++];
			} else if (arrayToSort[lowPtr] > arrayToSort[highPtr]) {
				sortedArray[j++] = arrayToSort[highPtr++];
			}
		}

		while (lowPtr <= mid) {
			sortedArray[j++] = arrayToSort[lowPtr++];
		}

		while (highPtr <= upperBound) {
			sortedArray[j++] = arrayToSort[highPtr++];
		}

		for (j = 0; j < n; j++)
			arrayToSort[lowerBound + j] = sortedArray[j];
	}

}
