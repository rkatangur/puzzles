package org.examples.arrays;

import java.util.Collection;

public class ArraysUtil {

	public static void printMatrix(int mat[][]) {
		int i, j;
		for (i = 0; i < mat.length; i++) {
			for (j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printMatrixUsingRecursion(int mat[][]) {
		printMatrixUsingRecursion(mat, 0, 0);
	}

	public static int printMatrixUsingRecursion(int mat[][], int row, int col) {

		// If the entire row is traversed
		if (row >= mat.length) {
			// rowEnded
			return 1;
		}

		// If the entire column is traversed
		if (col >= mat[row].length) {
			// rowEnded
			return 0;
		}

		System.out.print(mat[row][col] + " ");

		// Recursive call to traverse the matrix

		// in the Horizontal direction
		if (printMatrixUsingRecursion(mat, row, col + 1) == 1) {
			System.out.println("");
			return 1;
		}

		// Recursive call for changing the
		// Row of the matrix
		return printMatrixUsingRecursion(mat, row + 1, 0);
	}

	// Driver code
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 } };

		printMatrixUsingRecursion(arr, 0, 0);
	}

	public static void printMatrix(int mat[][], int R, int C) {
		int i, j;
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void displayWord(char[] charArray) {
		for (char c : charArray) {
			System.out.print(c);
		}
		System.out.println();
	}

	public static void printIntArr(int[] data) {
		for (int i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static <T> void printIterables(Collection<? extends Collection<T>> resList) {
		for (Collection<T> res : resList) {
			for (T t : res) {
				System.out.print(t + ",");
			}
			System.out.println();
		}
	}

}
