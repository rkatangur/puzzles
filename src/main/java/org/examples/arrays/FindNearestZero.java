package org.examples.arrays;

/**
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * Example 1:
 * 
 * Input: [[0,0,0], [0,1,0], [0,0,0]]
 * 
 * Output: [[0,0,0], [0,1,0], [0,0,0]]
 * 
 * 
 * @author rkata
 *
 */
public class FindNearestZero {

	public static void main(String[] args) {
		FindNearestZero solver = new FindNearestZero();
//		int[][] mat = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
//		solver.updateMatrix(mat);
//		ArraysUtil.printMatrix(mat);

		int[][] mat1 = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		ArraysUtil.printMatrix(solver.updateMatrix(mat1));

	}

	public int[][] updateMatrix(int[][] matrix) {

		int[][] visitedNodes = new int[matrix.length][matrix[0].length];
		int[][] dist = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != 0) {
					updateMatrixRec(matrix, i, j, dist, visitedNodes);
				} else {
					dist[i][j] = 0;
				}
			}
		}

		return dist;
	}

	public int updateMatrixRec(int[][] matrix, int sr, int sc, int[][] dist, int[][] visitedNodes) {
		if (matrix[sr][sc] == 0) {
			return 0;
		}

		int distance = matrix[sr][sc];
		distance = Math.max(distance, dist[sr][sc]);
		visitedNodes[sr][sc] = 1;
		int computedDis = Integer.MAX_VALUE;
		if (sr + 1 < matrix.length && visitedNodes[sr + 1][sc] == 0) {
			computedDis = Math.min(computedDis, 1 + updateMatrixRec(matrix, sr + 1, sc, dist, visitedNodes));
		}

		if (sr - 1 >= 0 && visitedNodes[sr - 1][sc] == 0) {
			computedDis = Math.min(computedDis, 1 + updateMatrixRec(matrix, sr - 1, sc, dist, visitedNodes));
		}

		if (sc + 1 < matrix[0].length && visitedNodes[sr][sc + 1] == 0) {
			computedDis = Math.min(computedDis, 1 + updateMatrixRec(matrix, sr, sc + 1, dist, visitedNodes));
		}

		if (sc - 1 >= 0 && visitedNodes[sr][sc - 1] == 0) {
			computedDis = Math.min(computedDis, 1 + updateMatrixRec(matrix, sr, sc - 1, dist, visitedNodes));
		}

		if (computedDis != Integer.MAX_VALUE) {
			distance = computedDis;
			dist[sr][sc] = Math.max(distance, computedDis);
		}
		
		visitedNodes[sr][sc] = 0;
		return distance;
	}

}
