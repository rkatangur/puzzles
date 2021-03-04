package org.examples.graph;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1
 * represents land and grid[i][j] = 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e., one
 * or more connected land cells).
 * 
 * The island doesn't have "lakes", meaning the water inside isn't connected to
 * the water around the island. One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * 
 * 
 * @author rkata
 *
 */

public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		IslandPerimeter solver = new IslandPerimeter();
		System.out.println(solver.islandPerimeter(grid));
	}

	public int islandPerimeter(int[][] grid) {
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					// started land
					return calculatePerimeterHelper(new int[] { i, j }, grid, dirs);
				}
			}
		}

		return 0;
	}

	public int calculatePerimeterHelper(int[] pos, int[][] grid, int[][] dirs) {
		if (pos[0] < 0 || pos[0] >= grid.length || pos[1] < 0 || pos[1] >= grid[0].length
				|| grid[pos[0]][pos[1]] == 0) {
			return 1;
		}

		if (grid[pos[0]][pos[1]] == -1) {
			return 0;
		}

		grid[pos[0]][pos[1]] = -1;
		int numOfwaters = 0;
		for (int[] dir : dirs) {
			int rowPos = pos[0] + dir[0];
			int colPos = pos[1] + dir[1];
			numOfwaters += calculatePerimeterHelper(new int[] { rowPos, colPos }, grid, dirs);
		}
		return numOfwaters;
	}

}
