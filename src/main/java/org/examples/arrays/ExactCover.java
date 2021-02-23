package org.examples.arrays;

/**
 *
 *
 * 4. Dancing Links
 * 
 * 4.1. Exact Cover
 * 
 * Let's look at another solution. Sudoku can be described as an Exact Cover
 * problem, which can be represented by incidence matrix showing the
 * relationship between two objects.
 * 
 * For example, if we take numbers from 1 to 7 and the collection of sets S =
 * {A, B, C, D, E, F}, where:
 * 
 * A = {1, 4, 7} B = {1, 4} C = {4, 5, 7} D = {3, 5, 6} E = {2, 3, 6, 7} F = {2,
 * 7} Our goal is to select such subsets that each number is there only once and
 * none is repeated, hence the name.
 * 
 * We can represent the problem using a matrix, where columns are numbers and
 * rows are sets:
 * 
 * | 1 | 2 | 3 | 4 | 5 | 6 | 7 | A | 1 | 0 | 0 | 1 | 0 | 0 | 1 | B | 1 | 0 | 0 |
 * 1 | 0 | 0 | 0 | C | 0 | 0 | 0 | 1 | 1 | 0 | 1 | D | 0 | 0 | 1 | 0 | 1 | 1 | 0
 * | E | 0 | 1 | 1 | 0 | 0 | 1 | 1 | F | 0 | 1 | 0 | 0 | 0 | 0 | 1 |
 * Subcollection S* = {B, D, F} is exact cover:
 * 
 * | 1 | 2 | 3 | 4 | 5 | 6 | 7 | B | 1 | 0 | 0 | 1 | 0 | 0 | 0 | D | 0 | 0 | 1 |
 * 0 | 1 | 1 | 0 | F | 0 | 1 | 0 | 0 | 0 | 0 | 1 | Each column has exactly one 1
 * in all selected rows.
 *
 * 
 * 
 * 
 * @param args
 */

public class ExactCover {

	public static void main(String[] args) {
		int[][] sets = new int[][] { { 1, 4, 7 }, { 1, 4 }, { 4, 5, 7 }, { 3, 5, 6 }, { 2, 3, 6, 7 }, { 2, 7 } };

		int[][] matrix = buildMatrix(sets, 1, 7);
		ArraysUtil.printMatrix(matrix);

		System.out.println("------------------------");
		int[][] uniqElemsMatrix = new int[matrix.length][7];

		for (int i = 0; i < matrix.length; i++) {
			uniqElemsMatrix[i] = matrix[i];
			for (int j = i + 1; j < matrix.length; j++) {
				if (isDisjoint(uniqElemsMatrix[i], matrix[j])) {
					// update
					for (int x = 0; x < uniqElemsMatrix.length; x++) {
//						System.out.println("i " + i + ", j " + j + ", x " + x);
						uniqElemsMatrix[i][x] = uniqElemsMatrix[i][x] | matrix[j][x];
					}
				}
			}
		}

		ArraysUtil.printMatrix(uniqElemsMatrix);
	}

	private static boolean isDisjoint(int[] uniqElemsSet, int[] setToEval) {
		for (int i = 0; i < uniqElemsSet.length; i++) {
			int setVal = setToEval[i];
			if (uniqElemsSet[i] == 1 && (uniqElemsSet[i] ^ setVal) == 0) {
				return false;
			}
		}
		return true;
	}

	private static int[][] buildMatrix(int[][] inputSets, int minNum, int maxNum) {
		int[][] matrix = new int[inputSets.length][maxNum];

		for (int i = 0; i < inputSets.length; i++) {
			for (int j = 0; j < inputSets[i].length; j++) {
				int val = inputSets[i][j];
				matrix[i][val - 1] = 1;
			}
		}

		return matrix;
	}

}
