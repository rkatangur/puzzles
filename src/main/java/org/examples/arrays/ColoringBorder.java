package org.examples.arrays;

/**
 * 
 * 1034. Coloring A Border
 * 
 * Given a 2-dimensional grid of integers, each value in the grid represents the
 * color of the grid square at that location.
 * 
 * Two squares belong to the same connected component if and only if they have
 * the same color and are next to each other in any of the 4 directions.
 * 
 * The border of a connected component is all the squares in the connected
 * component that are either 4-directionally adjacent to a square not in the
 * component, or on the boundary of the grid (the first or last row or column).
 * 
 * Given a square at location (r0, c0) in the grid and a color, color the border
 * of the connected component of that square with the given color, and return
 * the final grid.
 * 
 * 
 * 
 * @author rkata
 *
 */
public class ColoringBorder {

	public static void main(String[] args) {
		ColoringBorder solver = new ColoringBorder();
		int[][] grid = new int[][] { { 1, 1 }, { 1, 2 } };
		solver.colorBorder(grid, 0, 0, 3);
	}

	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

		int[][] positions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		colorBorder(grid, r0, c0, positions, grid[r0][c0]);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] < 0) {
					grid[i][j] = color;
				}
			}
		}

		return grid;
	}

	public void colorBorder(int[][] grid, int r0, int c0, int[][] positions, int origColor) {
		if (r0 < 0 || c0 < 0 || r0 >= grid.length || c0 >= grid[0].length || grid[r0][c0] != origColor) {
			return;
		}

		grid[r0][c0] = origColor * -1;
		for (int[] pos : positions) {
			int newRowPos = r0 + pos[0];
			int newColPos = c0 + pos[1];
			colorBorder(grid, newRowPos, newColPos, positions, origColor);
		}

		if (r0 > 0 && c0 > 0 && r0 < grid.length - 1 && c0 < grid[0].length - 1
				&& Math.abs(grid[r0 + 1][c0]) == origColor && Math.abs(grid[r0 - 1][c0]) == origColor
				&& Math.abs(grid[r0][c0 + 1]) == origColor && Math.abs(grid[r0][c0 - 1]) == origColor) {
			grid[r0][c0] = origColor;
		}
	}

}
