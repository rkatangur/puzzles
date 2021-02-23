package org.examples.arrays;
/*
Input: N = 3
Output: 25
5 4 3
6 1 2
7 8 9
The sum of elements along its two diagonals will be 
1 + 3 + 7 + 5 + 9 = 25

Input: N = 5
Output: 101
*/

public class FindSumOfDiagonalElements {

	public static void main(String[] args) {
		int arr[][] = { { 5, 4, 3 }, { 6, 1, 2 }, { 7, 8, 9 } };
		System.out.println(findSumOfDiagnoalElements(arr));

		int arr4x4[][] = { { 16, 15, 14, 13 }, { 5, 4, 3, 12 }, { 6, 1, 2, 11 }, { 7, 8, 9, 10 } };
		System.out.println(findSumOfDiagnoalElements(arr4x4));

		int arr5x5[][] = { { 25, 24, 23, 22, 21 }, { 10, 9, 8, 7, 20 }, { 11, 2, 1, 6, 19 }, { 12, 3, 4, 5, 18 },
				{ 13, 14, 15, 16, 17 } };
		System.out.println(findSumOfDiagnoalElements(arr5x5));

	}

	public static void buildASpiralMatrix(int n) {

	}

	public static int findSumOfDiagnoalElements(int[][] arr) {
		int starRowIdx = 0;
		int starClmIdx = 0;
		int lastRowIdx = arr.length - 1;
		int lastClmIdx = arr[0].length - 1;
		return findSumOfDiagnoalElements(arr, starRowIdx, starClmIdx, lastRowIdx, lastClmIdx);
	}

	public static int findSumOfDiagnoalElements(int[][] arr, int starRowIdx, int starClmIdx, int lastRowIdx,
			int lastClmIdx) {
		int sum = 0;
		if (starRowIdx > lastRowIdx || starClmIdx > lastClmIdx) {
			return sum;
		} else if (starRowIdx == lastRowIdx && starClmIdx == lastClmIdx) {
			return arr[starRowIdx][starClmIdx];
		} else {
			sum += arr[starRowIdx][starClmIdx] + arr[starRowIdx][lastClmIdx] + arr[lastRowIdx][starClmIdx]
					+ arr[lastRowIdx][lastClmIdx];
			return sum + findSumOfDiagnoalElements(arr, starRowIdx + 1, starClmIdx + 1, lastRowIdx - 1, lastClmIdx - 1);
		}
	}

}
