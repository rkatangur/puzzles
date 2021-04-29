package org.examples.arrays;

import java.util.Arrays;

public class MatrixDistance {

	public static void main(String[] args) {
		MatrixDistance solver = new MatrixDistance();
//		int[][] data = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] data = new int[][] { { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 }, { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
				{ 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 } };
		ArraysUtil.printMatrix(solver.updateMatrix(data));
	}

	public int[][] updateMatrix(int[][] matrix) {

		int[][] dist = new int[matrix.length][matrix[0].length];
		for (int[] d : dist) {
			Arrays.fill(d, -1);
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != 0) {

					int computedDis = Integer.MAX_VALUE;
					// move up
					if (i > 0) {
						computedDis = Math.min(computedDis, 1 + dist[i - 1][j]);
					}

					// move left
					if (j > 0) {
						computedDis = Math.min(computedDis, 1 + dist[i][j - 1]);
					}

					if (computedDis != Integer.MAX_VALUE) {
						dist[i][j] = computedDis;
					} else {
						dist[i][j] = 10000;
					}
				} else {
					dist[i][j] = 0;
				}
			}
		}

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (matrix[i][j] != 0) {
					int computedDis = Integer.MAX_VALUE;
					// check down
					if (i < matrix.length - 1) {
						computedDis = Math.min(computedDis, 1 + dist[i + 1][j]);
					}

					// check right
					if (j < matrix[i].length - 1) {
						computedDis = Math.min(computedDis, 1 + dist[i][j + 1]);
					}

					dist[i][j] = Math.min(dist[i][j], computedDis);
				}
			}
		}

		return dist;
	}

}
