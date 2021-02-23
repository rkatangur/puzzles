package org.examples.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.examples.arrays.ArraysUtil;

public class Combination {

	/**
	 * Partitioning by Elements in the Entire Set.
	 * 
	 * C(n,r) = C(n-1, r-1) + C(n-1, r);
	 * 
	 * @return
	 */
	private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
		// base condition is when the index == data.length clone the array
		if (index == data.length) {
			int[] combination = data.clone();
			combinations.add(combination);
			// base condition is when the index == data.length clone the array
		} else if (start <= end) {
			data[index] = start;
			helper(combinations, data, start + 1, end, index + 1);
			helper(combinations, data, start + 1, end, index);
		}
	}

	public static List<int[]> generate(int n, int r) {
		List<int[]> combinations = new ArrayList<>();
		helper(combinations, new int[r], 0, n - 1, 0);
		return combinations;
	}

	/**
	 * Partitioning by Elements in the Combination Instead of tracking the elements
	 * in the input set, we'll divide the task by tracking the items in the
	 * selection.
	 * 
	 */

	private static void helper1(List<int[]> combinations, int data[], int start, int end, int index) {
		// base condition is when the index == data.length clone the array
		if (index == data.length) {
			int[] combination = data.clone();
			combinations.add(combination);
		} else {
			// at any index the max is computed by using the formula of n - r +1
			int max = Math.min(end, end + 1 - data.length + index);
			for (int i = start; i < max; i++) {
				data[index] = start;
				helper1(combinations, data, i + 1, end, index + 1);
			}
		}
	}

	public static List<int[]> generate1(int n, int r) {
		List<int[]> combinations = new ArrayList<>();
		helper(combinations, new int[r], 0, n - 1, 0);
		return combinations;
	}

	public static List<int[]> generateIteratively(int n, int r) {
		List<int[]> combinations = new ArrayList<>();
		int[] combination = new int[r];

		// initialize with lowest lexicographic combination
		for (int i = 0; i < r; i++) {
			combination[i] = i;
		}

		while (combination[r - 1] < n) {
			combinations.add(combination.clone());

			// generate next combination in lexicographic order
			int t = r - 1;
			while (t != 0 && combination[t] == n - r + t) {
				t--;
			}
			combination[t]++;
			for (int i = t + 1; i < r; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		return combinations;
	}

	public static void main(String[] str) {
		List<int[]> combinations = generate(5, 3);
		for (int[] combination : combinations) {
			System.out.println(Arrays.toString(combination));
		}
		System.out.printf("generated %d combinations of %d items from %d", combinations.size(), 3, 5);
		System.out.println("");
		System.out.println("----------generating combinations1 using n-r+1 formula-------------");
		List<int[]> combinations1 = generate1(5, 3);
		for (int[] combination : combinations1) {
			System.out.println(Arrays.toString(combination));
		}
		System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), 3, 5);

		System.out.println("");
		System.out.println("---------- generating combinations Iteratively -------------");
		List<int[]> combinations2 = generateIteratively(5, 3);
		for (int[] combination : combinations2) {
			System.out.println(Arrays.toString(combination));
		}
		System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), 3, 5);

//		printAllPossibleCombinations(arr, data, 0, arr.length - 1, 0, r);
//
//		/*
//		 * output: 123 124 125 134 135 145
//		 * 
//		 * 234 235 245
//		 * 
//		 * 345
//		 * 
//		 */
//		findAllCombinations(arr, data, 0, arr.length - 1, 0, r);
////		123
////		124
////		125
////		134
////		135
////		145
////		234
////		235
////		245
////		345
//		System.out.println("--------------------------");
//		findAllCombinations1(arr, data, 0, arr.length, 0, r);
	}

	/*
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination start & end ---> Staring and Ending indexes in arr[] index --->
	 * Current index in data[] r ---> Size of a combination to be printed
	 */
	private static void findAllCombinations(int[] arr, int[] data, int startIndex, int endIndex, int dataIdx, int r) {

		if (dataIdx == r) {
			ArraysUtil.printIntArr(data);
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = startIndex; i <= endIndex && endIndex - i + 1 >= r - dataIdx; i++) {
			data[dataIdx] = arr[i];
			findAllCombinations(arr, data, i + 1, endIndex, dataIdx + 1, r);
		}
	}

	/*
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination arrIndex & endIndex ---> Staring and Ending indexes in arr[]
	 * dataIdx ---> Current index in data[] r ---> Size of a combination to be
	 * printed
	 */
	private static void findAllCombinations1(int[] arr, int[] data, int arrIndex, int endIndex, int dataIdx, int r) {

		// Current combination is ready to be printed, print it
		if (dataIdx == r) {
			ArraysUtil.printIntArr(data);
			return;
		}

		// When no more elements are there to put in data[]
		if (arrIndex >= endIndex) {
			return;
		}

		// current is included, put next at next location
		data[dataIdx] = arr[arrIndex];
		findAllCombinations1(arr, data, arrIndex + 1, endIndex, dataIdx + 1, r);

		// current is excluded, replace it with next (Note that
		// arrIndex+1 is passed, but dataIdx is not changed)
		findAllCombinations1(arr, data, arrIndex + 1, endIndex, dataIdx, r);
	}
}
