package org.examples.arrays;

public class RangeSumQuery2D {

	private int[][] prefixSumGrid;

	public RangeSumQuery2D(int[][] matrix) {
		prefixSumGrid = new int[matrix.length + 1][matrix[0].length + 1];

		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				prefixSumGrid[i][j] = prefixSumGrid[i][j - 1] + prefixSumGrid[i - 1][j] - prefixSumGrid[i - 1][j - 1]
						+ matrix[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return prefixSumGrid[row2 + 1][col2 + 1] - prefixSumGrid[row2 + 1][col1] - prefixSumGrid[row1][col2 + 1]
				+ prefixSumGrid[row1][col1];
	}

	public static void main(String[] args) {

		int[][] numMatrix = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
//		 2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]

		RangeSumQuery2D solver = new RangeSumQuery2D(numMatrix);
		System.out.println(solver.sumRegion(0, 0, 1, 1));

	}

	/**
	 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
	 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
	 */

	class NumMatrix {

		private int[][] prefixSumGrid;

		public NumMatrix(int[][] matrix) {
			prefixSumGrid = new int[matrix.length + 1][matrix[0].length + 1];

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					prefixSumGrid[i + 1][j + 1] = prefixSumGrid[i][j + 1] + prefixSumGrid[i + 1][j]
							- prefixSumGrid[i][j] + matrix[i][j];
				}
			}
		}
		
		public int sumRegion(int row1, int col1, int row2, int col2) {
			return prefixSumGrid[row2 + 1][col2 + 1] - prefixSumGrid[row2 + 1][col1] - prefixSumGrid[row1][col2 + 1]
					+ prefixSumGrid[row1][col1];
		}
		
	}

}
