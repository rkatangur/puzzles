package org.examples.arrays;

import java.util.Arrays;

/**
 * 
 * 
 * 1122. Relative Sort Array
 * 
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
 * elements in arr2 are also in arr1.
 * 
 * Sort the elements of arr1 such that the relative ordering of items in arr1
 * are the same as in arr2. Elements that don't appear in arr2 should be placed
 * at the end of arr1 in ascending order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6] Output:
 * [2,2,2,1,4,3,3,9,6,7,19]
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr1.length, arr2.length <= 1000 0 <= arr1[i], arr2[i] <= 1000 All the
 * elements of arr2 are distinct. Each arr2[i] is in arr1.
 * 
 * 
 * @author rkata
 *
 */
public class RelativeSortArray {

	public static void main(String[] args) {
		RelativeSortArray solver = new RelativeSortArray();
		int[] sortedArr1 = solver.relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 },
				new int[] { 2, 1, 4, 3, 9, 6 });
		ArraysUtil.printIntArr(sortedArr1);
	}

	public int[] relativeSortArray(int[] arr1, int[] arr2) {

		int sortedPos = 0;
		for (int i = 0; i < arr2.length; i++) {
			int num = arr2[i];
			for (int j = sortedPos; j < arr1.length; j++) {
				if (arr1[j] == num && j >= sortedPos) {
					int temp = arr1[sortedPos];
					arr1[sortedPos] = arr1[j];
					arr1[j] = temp;
					sortedPos++;
				}
			}
		}

		Arrays.sort(arr1, sortedPos, arr1.length);

		return arr1;
	}

}
