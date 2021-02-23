package org.examples.arrays.traversal;

import java.util.LinkedList;

/**
 * 
 * Number of Islands:
 * 
 * Solution: Given an m x n 2d grid map of '1's (land) and '0's (water), return
 * the number of islands. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically. You may assume all four
 * edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"],
 * ["1","1","0","0","0"], ["0","0","0","0","0"] ] Output: 1 Example 2:
 * 
 * Input: grid = [ ["1","1","0","0","0"], ["1","1","0","0","0"],
 * ["0","0","1","0","0"], ["0","0","0","1","1"] ] Output: 3
 * 
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 300 grid[i][j] is '0' or
 * '1'.
 * 
 * @param grid
 * @return
 */

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		int numOfIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					numOfIslands += numIslandsHelper(grid, i, j);
				}
			}
		}
		return numOfIslands;
	}

	public int numIslandsHelper(char[][] grid, int i, int j) {
		int numOfRows = grid.length;
		int numOfCols = grid[0].length;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		fill(i, j, grid, queue);
		
		int island = 0;
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int k = 0; k < qSize; k++) {
				int cord = queue.poll();

				int row = cord / numOfCols;
				int col = cord % numOfCols;
				if (grid[row][col] == '1') {
					grid[row][col] = '0';
				}
				fill(row + 1, col, grid, queue);
				fill(row - 1, col, grid, queue);
				fill(row, col + 1, grid, queue);
				fill(row, col - 1, grid, queue);
			}
			island = 1;
		}

		return island;
	}

	private void fill(int i, int j, char[][] grid, LinkedList<Integer> queue) {
		int numOfRows = grid.length;
		int numOfCols = grid[0].length;

		if (i < 0 || i >= numOfRows || j < 0 || j >= numOfCols || grid[i][j] == '0') {
			return;
		}

		queue.add(i * numOfCols + j);
	}

	public static void main(String[] args) {

		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };

		NumberOfIslands solver = new NumberOfIslands();
		System.out.println("Number of islands in grid: " + solver.numIslands(grid));

		char[][] grid1 = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println("Number of islands in grid1: " + solver.numIslands(grid1));
	}
}