package org.examples.graph;

import java.util.LinkedList;

public class NumberOfIslandsBFS {

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
					// System.out.println(String.format("Setting a[%s][%s] val to 0.", row, col));
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

}
