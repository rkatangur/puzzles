package org.examples.recursion;

import java.util.ArrayList;
import java.util.List;

import org.examples.arrays.ArraysUtil;

/**
 * Used backtracking with recursion to solve unique caps combinaiton problem.
 * @author rkata
 */
public class FindUniqueCapsCombinations {

//	5 100 1     // Collection of the first person.
//	2           // Collection of the second person.
//	5 100       // Collection of the third person.
//	Output:
//	4
//	Explanation: All valid possible ways are (5, 2, 100),  (100, 2, 5), (1, 2, 5) and  (1, 2, 100)
	public static void main(String[] args) {
		int[][] capsAllPersons = new int[][] { { 5, 100, 1 }, { 2 }, { 5, 100 } };
		List<int[]> allCombinations = new ArrayList<int[]>();

		int[] combination = new int[3];

		findAllCombinations(capsAllPersons, allCombinations, combination, 0, 0);
//		ArraysUtil.printMatrix(allCombinations);
	}

	static boolean findAllCombinations(int[][] capsOfAllPersons, List<int[]> allCombinations, int[] combination,
			int personIndex, int combinationIndex) {

		if (combinationIndex >= combination.length) {
			ArraysUtil.printIntArr(combination);
			allCombinations.add(combination.clone());
			return true;
		}

		int i = personIndex;
		if (i < capsOfAllPersons.length) {
			for (int j = 0; j < capsOfAllPersons[i].length; j++) {
				if (isValid(combination, capsOfAllPersons[i][j])) {
					combination[combinationIndex] = capsOfAllPersons[i][j];
					findAllCombinations(capsOfAllPersons, allCombinations, combination, i + 1, combinationIndex + 1);
					combination[combinationIndex] = 0;
				}
			}
		}

		return true;
	}

	private static boolean isValid(int[] caps, int capToAdd) {
		for (int i = 0; i < caps.length; i++) {
			if (caps[i] == capToAdd) {
				return false;
			}
		}
		return true;
	}

}
