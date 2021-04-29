package org.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 1380. Lucky Numbers in a Matrix
 * 
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the
 * matrix in any order. A lucky number is an element of the matrix such that it
 * is the minimum element in its row and maximum in its column.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]] Output: [15] Explanation: 15
 * is the only lucky number since it is the minimum in its row and the maximum
 * in its column Example 2:
 * 
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]] Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row
 * and the maximum in its column. Example 3:
 * 
 * Input: matrix = [[7,8],[1,2]] Output: [7]
 * 
 * 
 * Constraints:
 * 
 * m == mat.length n == mat[i].length 1 <= n, m <= 50 1 <= matrix[i][j] <= 10^5.
 * All elements in the matrix are distinct.
 * 
 * @author rkata
 *
 */
public class LuckyNumbersInMatrix {

	public List<Integer> luckyNumbers(int[][] matrix) {

		int[] minElems = new int[matrix.length];
		Arrays.fill(minElems, Integer.MAX_VALUE);

		int[] maxElems = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				minElems[i] = Math.min(minElems[i], matrix[i][j]);
				maxElems[j] = Math.max(maxElems[j], matrix[i][j]);
			}
		}

		System.out.println(minElems[0]);
		System.out.println(maxElems[0]);

		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < minElems.length; i++) {
			for (int j = 0; j < maxElems.length; j++) {
				if (minElems[i] == maxElems[j]) {
					results.add(minElems[i]);
					break;
				}
			}
		}

		return results;
	}

}
