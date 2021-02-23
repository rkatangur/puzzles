package org.examples.arrays;

public class MatrixProblems {

	/*
	 * Count number of ways to reach a given score in a Matrix Given a N x N matrix
	 * mat[][] consisting of non-negative integers, the task is to find the number
	 * of ways to reach a given score M starting from the the cell (0, 0) and
	 * reaching the cell (N – 1, N – 1) by going only down(from (i, j) to (i + 1,
	 * j)) or right(from (i, j) to (i, j + 1)). Whenever a cell (i, j) is reached,
	 * total score is updated by currentScore + mat[i][j].
	 * 
	 * Input: mat[][] = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, M = 4 Output: 0 All the
	 * paths will result in a score of 5.
	 * 
	 * Input: mat[][] = { {1, 1, 1}, {1, 1, 1}, {1, 1, 1} }, M = 5 Output: 6
	 */

	private static int numOfWays = 0;

	public static void main(String[] args) {
		int mat[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		findCount(mat, 0, 0, 5);
		System.out.println("Num of ways " + numOfWays);
	}

	static void findCount(int mat[][], int i, int j, int m) {
		if (i >= mat.length || j >= mat[0].length) {
			return;
		}

		m = m - mat[i][j];
		if (i < mat.length) {
			findCount(mat, i + 1, j, m);
		}

		if (j < mat[0].length) {
			findCount(mat, i, j + 1, m);
		}

		if (m == 0 && i == mat.length - 1 && j == mat[0].length - 1) {
			numOfWays++;
		}
	}
}
