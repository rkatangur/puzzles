package org.examples.arrays;

/**
 * 
 * 64. Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example 1: Input: grid = [[1,3,1],[1,5,1],[4,2,1]] Output: 7 Explanation:
 * Because the path 1 -> 3 ->1 -> 1 -> 1 minimizes the sum.
 * 
 * Example 2: Input: grid = [[1,2,3],[4,5,6]] Output: 12
 * 
 * 
 * @author rkata
 *
 */
public class MinSumPathIn2DArray {

	public static void main(String[] args) {
		MinSumPathIn2DArray solver = new MinSumPathIn2DArray();
//		System.out.println(solver.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
		System.out.println(solver.minPathSumUsingDP(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
	}

	public int minPathSumUsingDP(int[][] grid) {
		int[][] minPathsum = new int[grid.length][grid[0].length];
		minPathsum[0][0] = grid[0][0];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int minSum1 = Integer.MAX_VALUE;
				if (j - 1 >= 0) {
					minSum1 = minPathsum[i][j - 1];
				}
				int minSum2 = Integer.MAX_VALUE;
				if (i - 1 >= 0) {
					minSum2 = minPathsum[i - 1][j];
				}

				if (minSum1 != Integer.MAX_VALUE || minSum2 != Integer.MAX_VALUE) {
					minPathsum[i][j] = grid[i][j] + Math.min(minSum1, minSum2);
				}
			}
		}

		return minPathsum[grid.length - 1][grid[0].length - 1];
	}

	public int minPathSum(int[][] grid) {
		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 } };
		int[][] minPathsum = new int[grid.length][grid[0].length];

		return minPathSumHelper(grid, directions, new int[] { 0, 0 }, minPathsum);
	}

	private int minPathSumHelper(int[][] grid, int[][] directions, int[] curPos, int[][] minPathsum) {

		if (minPathsum[curPos[0]][curPos[1]] > 0) {
			return minPathsum[curPos[0]][curPos[1]];
		}

		int minPathSum = Integer.MAX_VALUE;
		for (int[] dir : directions) {
			int[] newPos = new int[] { curPos[0] + dir[0], curPos[1] + dir[1] };
			if (newPos[0] < grid.length && newPos[1] < grid[0].length) {
				int newMinPathSum = grid[curPos[0]][curPos[1]] + minPathSumHelper(grid, directions, newPos, minPathsum);
				minPathSum = Math.min(minPathSum, newMinPathSum);
			}
		}

		if (minPathSum == Integer.MAX_VALUE) {
			minPathsum[curPos[0]][curPos[1]] = grid[curPos[0]][curPos[1]];
		} else {
			minPathsum[curPos[0]][curPos[1]] = minPathSum;
		}

		return minPathsum[curPos[0]][curPos[1]];
	}

}
