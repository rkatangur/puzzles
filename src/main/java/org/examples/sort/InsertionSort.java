package org.examples.sort;

/**
 * 
 * Insertion Sort Insertion sort is a simple sorting algorithm that works
 * similar to the way you sort playing cards in your hands. The array is
 * virtually split into a sorted and an unsorted part.
 * 
 * Values from the unsorted part are picked and placed at the correct position
 * in the sorted part. Algorithm To sort an array of size n in ascending order:
 * 1: Iterate from arr[1] to arr[n] over the array. 2: Compare the current
 * element (key) to its predecessor. 3: If the key element is smaller than its
 * predecessor, compare it to the elements before. Move the greater elements one
 * position up to make space for the swapped element.
 * 
 * @author rkata
 *
 */

public class InsertionSort {

	public static void insertionSort1(int[] numArr) {
		for (int i = 1; i < numArr.length; i++) {
			// sort the array starting from 0 to the ith position which is the left side of
			// the array.
			int numToSwap = numArr[i];
			int j = i;
			while (j > 0) {
				if (numArr[j - 1] > numToSwap) {
					numArr[j] = numArr[j - 1];
					j--;
				} else {
					break;
				}
			}
			numArr[j] = numToSwap;
		}
	}

	public static void main(String[] args) {
		int[] numArray = new int[] { 9, 4, 6, 3, 7, 2 };
		insertionSort1(numArray);
		for (int i : numArray) {
			System.out.print(i + ",");
		}
	}

	public static void insertionSort(int[] numArray) {
		for (int i = 1; i < numArray.length; i++) {
			int numToSwap = numArray[i];
			int j = i;
			while (j > 0) {
				if (numArray[j - 1] >= numToSwap) {
					numArray[j] = numArray[j - 1];
					j--;
				} else {
					break;
				}
			}
			numArray[j] = numToSwap;
		}
	}

}
