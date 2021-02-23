package org.examples.arrays;
/*Given a 2D matrix mat[][], the task is to find the maximum sum of a cocktail glass.

A Cocktail glass is made of 6 cells in the following form:
X   X
  X
X X X */

public class MaxSumOfCocktailGlass {
	/*
	 * Input: mat[][] = { {1, 0, 4, 0, 0}, {0, 3, 0, 0, 0}, {1, 1, 1, 0, 0}, {0, 0,
	 * 0, 0, 0}, {0, 0, 0, 0, 0}} Output: 11 Below is the cocktail glass with
	 * maximum sum: 1 4 3 1 1 1
	 */
	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 4, 0, 0 }, { 0, 3, 0, 0, 0 }, { 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		System.out.println(findMaxCoctailSum(mat));
	}

	public static int findMaxCoctailSum(int[][] arr) {
		int maxCoctailSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int rowPos = i;
				int colPos = j;
				int coctailSum = 0;
				if (colPos + 2 < arr[0].length && rowPos + 2 < arr.length) {
					// can do a coctail sum
					coctailSum += arr[rowPos][colPos] + arr[rowPos][colPos + 2];
					coctailSum += arr[rowPos + 1][colPos + 1];
					coctailSum += arr[rowPos + 2][colPos] + arr[rowPos + 2][colPos + 1] + arr[rowPos + 2][colPos + 2];
					if (coctailSum > maxCoctailSum) {
						maxCoctailSum = coctailSum;
					}
				}
			}
		}
		return maxCoctailSum;
	}

	// Function to return the maximum sum
	// of a cocktail glass
	static int findMaxCock(int ar[][], int R, int C) {

		// If no cocktail glass is possible
		if (R < 3 || C < 3)
			return -1;

		// Initialize max_sum with the mini
		int max_sum = Integer.MIN_VALUE;

		// Here loop runs (R-2)*(C-2) times considering
		// different top left cells of cocktail glasses
		for (int i = 0; i < R - 2; i++) {
			for (int j = 0; j < C - 2; j++) {

				// Considering mat[i][j] as the top left
				// cell of the cocktail glass
				int sum = (ar[i][j] + ar[i][j + 2]) + (ar[i + 1][j + 1])
						+ (ar[i + 2][j] + ar[i + 2][j + 1] + ar[i + 2][j + 2]);

				// Update the max_sum
				max_sum = Math.max(max_sum, sum);
			}
		}
		return max_sum;
	}

}
