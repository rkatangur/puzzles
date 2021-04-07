package org.examples.arrays;

/**
 * 
 * 741. Cherry Pickup
 * 
 * You are given an n x n grid representing a field of cherries, each cell is
 * one of three possible integers.
 * 
 * 0 means the cell is empty, so you can pass through, 1 means the cell contains
 * a cherry that you can pick up and pass through, or -1 means the cell contains
 * a thorn that blocks your way. Return the maximum number of cherries you can
 * collect by following the rules below:
 * 
 * Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right
 * or down through valid path cells (cells with value 0 or 1). After reaching (n
 * - 1, n - 1), returning to (0, 0) by moving left or up through valid path
 * cells. When passing through a path cell containing a cherry, you pick it up,
 * and the cell becomes an empty cell 0. If there is no valid path between (0,
 * 0) and (n - 1, n - 1), then no cherries can be collected.
 * 
 * Example 1: Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]] Output: 5 Explanation:
 * The player started at (0, 0) and went down, down, right right to reach (2,
 * 2). 4 cherries were picked up during this single trip, and the matrix becomes
 * [[0,1,-1],[0,0,-1],[0,0,0]]. Then, the player went left, up, up, left to
 * return home, picking up one more cherry. The total number of cherries picked
 * up is 5, and this is the maximum possible.
 * 
 * Example 2: Input: grid = [[1,1,-1],[1,-1,1],[-1,1,1]] Output: 0
 * 
 * @author rkata
 *
 */
public class CherryPickup {

	public static void main(String[] args) {
		CherryPickup solver = new CherryPickup();
		System.out.println(solver.cherryPickup(new int[][] { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } }));
	}

	int[][] movingDownDirs = new int[][] { { 0, 1 }, { 1, 0 } };
	int[][] movingUpDirs = new int[][] { { 0, -1 }, { -1, 0 } };

	public int cherryPickup(int[][] grid) {
		int N = grid.length;
		int M = grid[0].length;
		int[][] bestPath = buildBestPath(grid);

		updateGridBasedOnBestPath(grid, bestPath);

		int[][] bestPath1 = buildBestPath(grid);

		updateGridBasedOnBestPath(grid, bestPath1);

		return grid[N - 1][M - 1];
	}

	private void updateGridBasedOnBestPath(int[][] grid, int[][] bestPath) {
		int N = grid.length;
		int M = grid[0].length;
		int i = 0, j = 0;
		while (i < N && j < M) {
			boolean moveDown = false;
			boolean moveRight = false;
			if (j + 1 < grid[0].length && i + 1 < grid.length) {
				// can move right and down pick that has more cherries
				if (bestPath[i][j + 1] > bestPath[i + 1][j]) {
					// move right
					moveRight = true;
				} else {
					// move down
					moveDown = true;
				}
			} else if (i + 1 < grid.length && bestPath[i + 1][j] >= 0) {
				// can move down
				moveDown = true;
			} else if (j + 1 < grid[0].length && bestPath[i][j + 1] >= 0) {
				// can move right
				moveRight = true;
			}

			if (moveRight) {
				// move right
				grid[i][j + 1] += grid[i][j];
				grid[i][j] = 0;
				j++;
			} else if (moveDown) {
				// move down
				grid[i + 1][j] += grid[i][j];
				grid[i][j] = 0;
				i++;
			} else {
				i++;
				j++;
			}
		}
	}

	private int[][] buildBestPath(int[][] grid) {
		int N = grid.length;
		int M = grid[0].length;
		int[][] bestPath = new int[N][M];

		bestPath[N - 1][M - 1] = grid[N - 1][M - 1];
		int i = N - 1;
		int j = M - 1;

		while (i >= 0 && j >= 0) {
			// moving left
			if (j - 1 >= 0) {
				if (grid[i][j - 1] >= 0) {
					bestPath[i][j - 1] = Math.max(bestPath[i][j - 1], grid[i][j - 1] + bestPath[i][j]);
				} else {
					bestPath[i][j - 1] = grid[i][j - 1];
				}
				j--;
			}

			// moving top
			if (i - 1 >= 0) {
				if (grid[i - 1][j] >= 0) {
					bestPath[i - 1][j] = Math.max(bestPath[i - 1][j], grid[i - 1][j] + bestPath[i][j]);
				} else {
					bestPath[i - 1][j] = grid[i - 1][j];
				}
				i--;
			}
		}

		return bestPath;
	}
}
