package org.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Implement the following method: //Return all possible Lists containing one
 * element from each input list public static <T> List<List<T>>
 * getAllCombinations(List<List<T>> input);
 * 
 * 
 * Example input: {{1, 2, 3}, {1, 2}, {4, 5}} Example output: {{1,1,0}, {1,1,0},
 * {2,1,0}, {2,1,0}, {3,1,0}, {3,1,0}}
 * 
 * i= 0--1 firstCollection=0 --> 0 secCollection=1 --> 0 thirdCollection=2 --> 0
 * 
 * {0, 0,0} thirdCollection =2 --> 1 {0, 0, 1}
 * 
 * exit; i=0, 2 i=
 * 
 */
public class FindAllCombinations {

	public static void main(String[] args) {
		List<List<Integer>> input = Arrays.asList(Arrays.asList(6, 7), Arrays.asList(2, 3), Arrays.asList(8, 9),
				Arrays.asList(4, 5));
		List<List<Integer>> output = getAllCombinations(input);
		for (List<Integer> oneRes : output) {
			for (Integer resElem : oneRes) {
				System.out.print(resElem + ", ");
			}
			System.out.println();

		}
	}

//		{
//		{1, 2},
//		{3, 4}, 
//		{5, 6},
//		{7, 8}
//		} 

	public static <T> List<List<T>> getAllCombinations(List<List<T>> input) {

		int[] inputIndexes = new int[input.size()];
		List<List<T>> result = new ArrayList<>();

		// need to construct a newResultList
		boolean endOfRun = false;
		Object[] objResult = new Object[input.size()];

		while (!endOfRun) {
			int n = input.size();
			for (int i = 0; i < n; i++) {
				int curIndex = inputIndexes[i];
				objResult[i] = input.get(i).get(curIndex);
			}

			int listIndex = n - 1;
			result.add((List<T>) Arrays.asList(objResult.clone()));

			// Find the rightmost array that has more
			// elements left after the current element
			// in that array
			while (listIndex >= 0) {
				if (inputIndexes[listIndex] + 1 >= input.get(listIndex).size()) {
					listIndex--;
				} else {
					break;
				}
			}

			// No such array is found so no more
			// combinations left
			if (listIndex < 0) {
				break;
			}

			// If found move to next element in that
			// array
			inputIndexes[listIndex] = inputIndexes[listIndex] + 1;

			// For all arrays to the right of this array adjust the current index again
			// first element
			for (int j = listIndex + 1; j < n; j++) {
				inputIndexes[j] = 0;
			}
		}

		return result;
	}

}
