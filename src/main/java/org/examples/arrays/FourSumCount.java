package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 454. 4Sum II
 * 
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j,
 * k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * 
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 <=
 * N <= 500. All integers are in the range of -228 to 228 - 1 and the result is
 * guaranteed to be at most 231 - 1.
 * 
 * Example:
 * 
 * Input: A = [ 1, 2] B = [-2,-1] C = [-1, 2] D = [ 0, 2]
 * 
 * Output: 2
 * 
 * Explanation: The two tuples are: 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1]
 * = 1 + (-2) + (-1) + 2 = 0 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 +
 * (-1) + (-1) + 0 = 0
 * 
 * 
 * @author rkata
 *
 */

public class FourSumCount {

	public static void main(String[] args) {
		FourSumCount solver = new FourSumCount();
		int[] A = new int[] { 1, 2 };
		int[] B = new int[] { -2, -1 };
		int[] C = new int[] { -1, 2 };
		int[] D = new int[] { 0, 2 };

		System.out.println(solver.fourSumCount(A, B, C, D));
	}

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int[][] dataArr = new int[][] { A, B, C, D };
//		int[] fourElemArr = new int[4];
//		return fourSumCountHelper(dataArr, 0, 0, 0);

		return kSumCount(A, B, C, D, 0);
	}

	public int kSumCount(int[] A, int[] B, int[] C, int[] D, int targetSum) {
		int[][] dataArr = new int[][] { A, B, C, D };
		Map<Integer, Integer> mapofSums = new HashMap<Integer, Integer>();
		kSumCountHelper(dataArr, 0, dataArr.length / 2, 0, mapofSums);

		return compliment(dataArr, dataArr.length / 2, dataArr.length, 0, 0, mapofSums);
	}

	public void kSumCountHelper(int[][] dataArr, int startIndex, int endIndex, int sum,
			Map<Integer, Integer> mapofSums) {
		if (startIndex >= endIndex) {
			mapofSums.put(sum, mapofSums.getOrDefault(sum, 0) + 1);
			return;
		}

		int[] dataSubArr = dataArr[startIndex];
		for (int i = 0; i < dataSubArr.length; i++) {
			kSumCountHelper(dataArr, startIndex + 1, endIndex, sum + dataSubArr[i], mapofSums);
		}
	}

	public int compliment(int[][] dataArr, int startIndex, int endIndex, int curSum, int targetSumOffset,
			Map<Integer, Integer> mapofSums) {
		if (startIndex >= endIndex) {
			int lookupVal = targetSumOffset - curSum;
			return mapofSums.getOrDefault(lookupVal, 0);
		}

		int count = 0;
		int[] dataSubArr = dataArr[startIndex];
		for (int i = 0; i < dataSubArr.length; i++) {
			count += compliment(dataArr, startIndex + 1, endIndex, curSum + dataSubArr[i], targetSumOffset, mapofSums);
		}
		return count;
	}

	public int fourSumCountHelper(int[][] dataArr, int curSum, int dataArrIndex, int targetSum) {
		if (dataArrIndex >= dataArr.length) {
			if (curSum == targetSum) {
				return 1;
			} else {
				return 0;
			}
		}

		int result = 0;
		int[] dataSubArr = dataArr[dataArrIndex];
		for (int i = 0; i < dataSubArr.length; i++) {
//			combArr[combIndex] = dataSubArr[i];
			result += fourSumCountHelper(dataArr, curSum + dataSubArr[i], dataArrIndex + 1, targetSum);
		}

		return result;
	}

	public void generateCombinations(int[] A, int[] B, int[] C, int[] D) {
		int[][] dataArr = new int[][] { A, B, C, D };
		int[] fourElemArr = new int[4];
		generateCombinationsHelper(dataArr, fourElemArr, 0, 0);
	}

	public void generateCombinationsHelper(int[][] dataArr, int[] combArr, int dataArrIndex, int combIndex) {
		if (dataArrIndex >= dataArr.length || combIndex >= combArr.length) {
			ArraysUtil.printIntArr(combArr);
			return;
		}

		int[] dataSubArr = dataArr[dataArrIndex];
		for (int i = 0; i < dataSubArr.length; i++) {
			combArr[combIndex] = dataSubArr[i];
			generateCombinationsHelper(dataArr, combArr, dataArrIndex + 1, combIndex + 1);
		}
	}

}
