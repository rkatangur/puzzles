package org.examples.arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InversionsInArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 2, 4, 6 };
//		int[] arr2 = new int[] { 1, 7, 5, 2, 4, 6, 3 };
		int[][] inversionsArr = new int[21][2];

//		try {
//			int[] integers = buildIntegerArray("IntegerArray.txt");
//
			InversionsInArray solver = new InversionsInArray();
//			long[] inversions = solver.findInversions(integers, 0, integers.length - 1);
//			
			long[] inversions = solver.findInversions(new int[] { 2, 0, 1 }, 0, 3 - 1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static int[] buildIntegerArray(String integerArrayFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(integerArrayFile)));
		int i = 0;
		String line = null;

		int[] integers = new int[100000];
		while ((line = br.readLine()) != null) {
			integers[i++] = Integer.parseInt(line);
		}
		return integers;
	}

	public long[] findInversions(int[] arr, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			return new long[] { 0, 0 };
		}

		int mid = (startIndex + endIndex) / 2;
		long[] inv1 = findInversions(arr, startIndex, mid);
		long[] inv2 = findInversions(arr, mid + 1, endIndex);

		long[] inv = new long[] { inv1[0] + inv2[0], inv1[1] + inv2[1] };
		// merge two sub arrays
		findSplitInversions(arr, startIndex, endIndex, mid, inv);
		return inv;
	}

	private void findSplitInversions(int[] arr, int startIndex, int endIndex, int mid, long[] inv) {
		int j = startIndex;
		int k = mid + 1;
		int[] sortedArr = new int[endIndex - startIndex + 1];
		int i = 0;
		int numOfSplitInversions = 0;
		int numOfLocalInversions = 0;
		while (j <= mid && k <= endIndex) {
			if (arr[j] < arr[k]) {
				sortedArr[i] = arr[j];
				j++;
			} else {
				sortedArr[i] = arr[k];
				numOfSplitInversions += mid - j + 1;
				if (j == k - 1) {
					numOfLocalInversions++;
				}

				k++;
			}
			i++;
		}

		while (j <= mid) {
			sortedArr[i] = arr[j];
			j++;
			i++;
		}

		while (k <= endIndex) {
			sortedArr[i] = arr[k];
			k++;
			i++;
		}

		for (int x = 0; x < sortedArr.length; x++) {
			arr[startIndex + x] = sortedArr[x];
		}

		inv[0] = inv[0] + numOfLocalInversions;
		inv[1] = inv[1] + numOfSplitInversions;

// 		return new long[]{numOfLocalInversions, numOfSplitInversions};
	}

	public boolean isIdealPermutation(int[] A) {

		long inv[] = findInversions(A, 0, A.length - 1);

		if (inv[0] == inv[1]) {
			return true;
		}

		return false;
	}

}
