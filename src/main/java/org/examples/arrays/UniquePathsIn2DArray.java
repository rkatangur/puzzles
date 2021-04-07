package org.examples.arrays;

import java.util.Arrays;

/**
 * 
 * 62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below). The robot can only move either down or right at any point
 * in time. The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below). How many possible unique paths are
 * there?
 * 
 * Example 1: Input: m = 3, n = 7 Output: 28
 * 
 * 
 * Example 2:
 * 
 * Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there
 * are a total of 3 ways to reach the bottom-right corner: 1. Right -> Down ->
 * Down 2. Down -> Down -> Right 3. Down -> Right -> Down
 * 
 * 
 * Example 3:
 * 
 * Input: m = 7, n = 3 Output: 28
 * 
 * 
 * Example 4:
 * 
 * Input: m = 3, n = 3 Output: 6
 * 
 * @author rkata
 *
 */
public class UniquePathsIn2DArray {

	public static void main(String[] args) {
		UniquePathsIn2DArray solver = new UniquePathsIn2DArray();
		System.out.println(solver.uniquePaths(3, 2));
		System.out.println(solver.uniquePathsUsingDp(3, 2));
	}

	public int uniquePaths(int m, int n) {
		if (m < 0 || n < 0) {
			return 0;
		}

		if (m == 1 && n == 1) {
			return 1;
		}

		return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
	}

	public int uniquePathsUsingDp(int m, int n) {
		int[][] pathsArr = new int[m][n];
		Arrays.fill(pathsArr[0], 1);

		for (int i = 1; i < pathsArr.length; i++) {
			pathsArr[i][0] = 1;
			for (int j = 1; j < pathsArr[0].length; j++) {
				pathsArr[i][j] = pathsArr[i - 1][j] + pathsArr[i][j - 1];
			}
		}

		return pathsArr[m - 1][n - 1];
	}
}
