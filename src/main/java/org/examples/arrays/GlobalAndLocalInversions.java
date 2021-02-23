package org.examples.arrays;

public class GlobalAndLocalInversions {

	public static void main(String[] args) {
		GlobalAndLocalInversions solver = new GlobalAndLocalInversions();
		System.out.println(solver.isIdealPermutation(new int[] { 2, 0, 1 }));
	}

	public boolean isIdealPermutation(int[] A) {

		int localInv = findLocalInversions(A);
		int globalInv = findInversions(A, 0, A.length - 1);

		if (localInv == globalInv) {
			return true;
		}

		return false;
	}

	public int findLocalInversions(int[] arr) {
		int numOfLocalInv = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				numOfLocalInv++;
			}
		}

		return numOfLocalInv;
	}

	public int findInversions(int[] arr, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			return 0;
		}

		int mid = (startIndex + endIndex) / 2;
		int inv1 = findInversions(arr, startIndex, mid);
		int inv2 = findInversions(arr, mid + 1, endIndex);

		// merge two sub arrays
		int splitInv = findSplitInversions(arr, startIndex, endIndex, mid);
		return inv1 + inv2 + splitInv;
	}

	private int findSplitInversions(int[] arr, int startIndex, int endIndex, int mid) {
		int j = startIndex;
		int k = mid + 1;
		int[] sortedArr = new int[endIndex - startIndex + 1];
		int i = 0;
		int numOfSplitInversions = 0;
		while (j <= mid && k <= endIndex) {
			if (arr[j] < arr[k]) {
				sortedArr[i] = arr[j];
				j++;
			} else {
				sortedArr[i] = arr[k];
				numOfSplitInversions += mid - j + 1;
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

		return numOfSplitInversions;
	}
}
