package org.examples.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.examples.arrays.ArraysUtil;
import org.examples.util.FileUtil;

public class QuickSort {

	public static void main(String[] args) {
//		int[] arrayToSort = new int[] { 64, 21, 33, 70, 12, 85, 44, 3, 99, 0, 108, 36 };
////		sort(arrayToSort);
//		System.out.println(quickSort(arrayToSort, 0, 11));
//		ArraysUtil.printIntArr(arrayToSort);

		List<Integer> numList = loadNumsFromFile();
		System.out.println(quickSort(numList));

//		arrayToSort = new int[] { 3, 8, 2, 5, 1, 4, 7, 6 };
//		int pivotIndex = choosePivotIndex(arrayToSort, 0, 7, true, false);
//		partitionAroungPivotUsingLeftPos(arrayToSort, pivotIndex, 0, 7);
//		ArraysUtil.printIntArr(arrayToSort);
		// 1 2 3 5 8 4 7 6
//--162085 -- using left element as pivot

//		System.out.println(quickSort(arrayToSort, 0, arrayToSort.length -1));

//		partitionAroungPivotUsingRightPos(arrayToSort, 7, 0, 7);
//		partitionAroungPivotUsingLeftPos(arrayToSort, 7, 0, 7);
//		ArraysUtil.printIntArr(arrayToSort);
//		3 2 5 1 4 6 7 8 
//--164123 -- using right element as index

//-- 138382 -- Using the middle or median as the pivot

	}

	private static int quickSort(List<Integer> numList) {
		int[] numArr = numList.stream().mapToInt(i -> i).toArray();
		return quickSort(numArr, 0, numList.size() - 1);
	}

	private static int quickSort(int[] numsArr, int leftPos, int rightPos) {
		if (numsArr.length == 1 || leftPos >= rightPos) {
			return 0;
		}

//		using first index as pivot
//		int pivotIndex = choosePivotIndex(numsArr, leftPos, rightPos, false, true);

//		using last  index as pivot
//		int pivotIndex = choosePivotIndex(numsArr, leftPos, rightPos, false, false);

		// using median as pivot
		int pivotIndex = choosePivotIndex(numsArr, leftPos, rightPos, true, false);

		int partionIndex = partitionAroungPivotUsingLeftPos(numsArr, pivotIndex, leftPos, rightPos);
//		int partionIndex = partitionAroungPivotUsingRightPos(numsArr, pivotIndex, leftPos, rightPos);

		int numOfComparisions = rightPos - leftPos;
		numOfComparisions += quickSort(numsArr, leftPos, partionIndex - 1);
		numOfComparisions += quickSort(numsArr, partionIndex + 1, rightPos);

		return numOfComparisions;
	}

	public static int choosePivotIndex(int[] numsArr, int leftPos, int rightPos, boolean useMedian, boolean useFirst) {
		if (useMedian) {
			int median = (rightPos - leftPos) / 2 + leftPos;
			if ((numsArr[leftPos] >= numsArr[median] && numsArr[leftPos] <= numsArr[rightPos])
					|| (numsArr[leftPos] >= numsArr[rightPos] && numsArr[leftPos] <= numsArr[median])) {
				return leftPos;
			} else if ((numsArr[median] >= numsArr[leftPos] && numsArr[median] <= numsArr[rightPos])
					|| (numsArr[median] >= numsArr[rightPos] && numsArr[median] <= numsArr[leftPos])) {
				return median;
			} else if ((numsArr[rightPos] >= numsArr[leftPos] && numsArr[rightPos] <= numsArr[median])
					|| (numsArr[rightPos] >= numsArr[median] && numsArr[rightPos] <= numsArr[leftPos])) {
				return rightPos;
			}
			return median;
		} else if (useFirst) {
			return leftPos;
		} else {
			return rightPos;
		}
	}

	public static int partitionAroungPivotUsingLeftPos(int[] numsArr, int pivotIndex, int leftPos, int rightPos) {
		int pivotVal = numsArr[pivotIndex];
		numsArr[pivotIndex] = numsArr[leftPos];
		numsArr[leftPos] = pivotVal;

		System.out.println("Partioning using " + pivotVal + "pivotIndex: " + pivotIndex + ", left " + leftPos
				+ ", rightPos " + rightPos);

		int partionIndex = leftPos + 1;
		for (int j = partionIndex; j <= rightPos; j++) {
			if (numsArr[j] < pivotVal) {
				int temp = numsArr[partionIndex];
				numsArr[partionIndex++] = numsArr[j];
				numsArr[j] = temp;
			}
		}

		if (partionIndex > leftPos + 1 && pivotVal > numsArr[partionIndex - 1]) {
			int temp = numsArr[partionIndex - 1];
			numsArr[partionIndex - 1] = pivotVal;
			numsArr[leftPos] = temp;
		}

		return partionIndex - 1;
	}

//	public static int partitionAroungPivotUsingRightPos(int[] numsArr, int pivotIndex, int leftPos, int rightPos) {
//
//		int pivotVal = numsArr[pivotIndex];
//		numsArr[pivotIndex] = numsArr[leftPos];
//		numsArr[leftPos] = pivotVal;
//
//		int partionIndex = leftPos + 1;
//		for (int j = partionIndex; j <= rightPos; j++) {
//
//			if (numsArr[j] < pivotVal) {
//				int temp = numsArr[partionIndex];
//				numsArr[partionIndex++] = numsArr[j];
//				numsArr[j] = temp;
//			}
//		}
//		
//		if (partionIndex > leftPos + 1 && pivotVal > numsArr[partionIndex - 1]) {
//			int temp = numsArr[partionIndex - 1];
//			numsArr[partionIndex - 1] = pivotVal;
//			numsArr[leftPos] = temp;
//		}
//
//		return partionIndex - 1;
//	}

	public static int[] partitionUsingExtraSpaceAroungPivot(int[] numsArr, int pivotIndex) {
		int[] numsArrCopy = new int[numsArr.length];
		int leftIndex = 0;
		int rightIndex = numsArr.length - 1;
		int pivotVal = numsArr[pivotIndex];
		for (int i = 0; i < numsArr.length; i++) {
			if (numsArr[i] > pivotVal) {
				numsArrCopy[rightIndex--] = numsArr[i];
			} else if (numsArr[i] < pivotVal) {
				numsArrCopy[leftIndex++] = numsArr[i];
			}
		}
		numsArrCopy[leftIndex] = pivotVal;

		return numsArrCopy;
	}

	private static List<Integer> loadNumsFromFile() {
		List<Integer> numList = new ArrayList<Integer>();

		String quickSortFile = "QuickSort.txt";
		InputStream quickSortIS = null;
		BufferedReader br = null;
		try {
			quickSortIS = FileUtil.findFile(quickSortFile);
			br = new BufferedReader(new InputStreamReader(quickSortIS));
			String line;
			try {
				line = br.readLine();
				while (line != null) {
					numList.add(Integer.parseInt(line));
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (quickSortIS != null) {
					quickSortIS.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return numList;
	}

}
