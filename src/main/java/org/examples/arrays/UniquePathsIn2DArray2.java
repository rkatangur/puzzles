package org.examples.arrays;

/**
 * 
 * 63. Unique Paths II
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 * 
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] Output: 2
 * 
 * Explanation: There is one obstacle in the middle of the 3x3 grid above. There
 * are two ways to reach the bottom-right corner: 1. Right -> Right -> Down ->
 * Down 2. Down -> Down -> Right -> Right
 * 
 * @author rkata
 *
 */
public class UniquePathsIn2DArray2 {

	public static void main(String[] args) {
		UniquePathsIn2DArray2 solver = new UniquePathsIn2DArray2();
		System.out.println(solver.uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
//		System.out.println(solver.uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } }));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] minPath = new int[obstacleGrid.length][obstacleGrid[0].length];
		if (obstacleGrid[0][0] == 0) {
			minPath[0][0] = 1;
		}

		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					// this is an obstacle can't go here
					minPath[i][j] = 0;
				} else {
					int minPathSum = minPath[i][j];
					// prevRow
					if (i - 1 >= 0) {
						minPathSum += minPath[i - 1][j];
					}

					if (j - 1 >= 0) {
						minPathSum += minPath[i][j - 1];
					}

					minPath[i][j] = minPathSum;
				}
			}
		}

		return minPath[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

}
