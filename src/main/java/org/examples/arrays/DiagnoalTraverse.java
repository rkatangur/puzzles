package org.examples.arrays;

/**
 * 
 * 498. Diagonal Traverse Given a matrix of M x N elements (M rows, N columns),
 * return all elements of the matrix in diagonal order as shown in the below
 * image.
 * 
 * 
 * 
 * Example:
 * 
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
 * 
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 * 
 */
public class DiagnoalTraverse {

	public static void main(String[] args) {
		DiagnoalTraverse solver = new DiagnoalTraverse();
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] targetArr = solver.findDiagonalOrder(matrix);
		ArraysUtil.printIntArr(targetArr);

		int[][] matrix2 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int[] targetArr2 = solver.findDiagonalOrder(matrix2);
		ArraysUtil.printIntArr(targetArr2);

	}

	public int[] findDiagonalOrder(int[][] matrix) {
		int maxRows = matrix.length;
		int maxCols = matrix[0].length;

		int[] targetArr = new int[maxRows * maxCols];
		int rowPos = 0;
		int colPos = 0;
		int targetArrIndex = 0;
		boolean facingUp = true;

		while (rowPos < matrix.length && colPos < matrix[0].length) {
			targetArr[targetArrIndex++] = matrix[rowPos][colPos];

			if (rowPos == maxRows - 1 && colPos == maxCols - 1) {
				break;
			}

			if (facingUp) {
				colPos = colPos + 1;
				if (rowPos == 0 || colPos == maxCols) {
					if (colPos >= maxCols) {
						colPos = maxCols - 1;
						rowPos = rowPos + 1;
					}
					facingUp = false;
				} else {
					rowPos = rowPos - 1;
				}
			} else {
				rowPos = rowPos + 1;

				// change the face when the colPos ==0 or rowPos== maxRows
				if (colPos == 0 || rowPos == maxRows) {
					if (rowPos >= maxRows) {
						rowPos = maxRows - 1;
						colPos = colPos + 1;
					}
					facingUp = true;
				} else {
					// decrement the colPos on moving down
					colPos = colPos - 1;
				}
			}
		}
		return targetArr;
	}

}
