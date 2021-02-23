package org.examples.graph;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		int numOfIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					numOfIslands += numIslandsHelperDFS(grid, i, j);
				}
			}
		}
		return numOfIslands;
	}

	public int numIslandsHelperDFS(char[][] grid, int i, int j) {
		int numOfRows = grid.length;
		int numOfCols = grid[0].length;

		if (i < 0 || i >= numOfRows || j < 0 || j >= numOfCols || grid[i][j] == '0') {
			return 0;
		}

		if (grid[i][j] == '1') {
			grid[i][j] = '0';
		}

		numIslandsHelperDFS(grid, i + 1, j);
		numIslandsHelperDFS(grid, i - 1, j);
		numIslandsHelperDFS(grid, i, j + 1);
		numIslandsHelperDFS(grid, i, j - 1);

		return 1;
	}
}
