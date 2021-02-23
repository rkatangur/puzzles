package org.examples.arrays;

public class Print2DArray {
	/*
	 * Input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 Output: 1 2 3 4 8 12 16 15 14
	 * 13 9 5 6 7 11 10
	 * 
	 * 
	 * Input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 Output: 1 2 3 4 5 6 12 18
	 * 17 16 15 14 13 7 8 9 10 11
	 */
	public static void print2DArrayInSpiralOrder(int[][] array) {
		int k = 0, l = 0;
		int last_row = array.length - 1;
		int last_col = array[0].length - 1;

		while (k <= last_row && l <= last_col) {
			// print the first row
			for (int i = l; i <= last_col; i++) {
				System.out.print(array[k][i] + " ");
			}
			k++;

			// print the last column
			for (int i = k; i <= last_row; i++) {
				System.out.print(array[i][last_col] + " ");
			}
			last_col--;

			// print the last row
			if (k <= last_row) {
				for (int i = last_col; i >= l; i--) {
					System.out.print(array[last_row][i] + " ");
				}
				last_row--;
			}

			// print the values around the first column
			if (l <= last_col) {
				for (int i = last_row; i >= k; i--) {
					System.out.print(array[i][l] + " ");
				}
				l++;
			}
		}
	}

	// driver program
	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		print2DArrayInSpiralOrder(a);
	}
}
