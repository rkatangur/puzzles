package org.examples.arrays;

/**
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * Example 1:
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0], [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0], [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0], [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0], [0,0,0,0,0,0,0,1,1,0,0,0,0]] Given the above
 * grid, return 6. Note the answer is not 11, because the island must be
 * connected 4-directionally.
 * 
 * 
 * @author rkata
 *
 */
public class MaxAreaOfIsland {

	public static void main(String[] args) {
		MaxAreaOfIsland solver = new MaxAreaOfIsland();
		int[][] grid = new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

		System.out.println(solver.maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {
		int area = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int areaAtIAndJ = computeAreaOfIsland(grid, i, j);
					System.out.println("areaAtIAndJ " + areaAtIAndJ + ", i " + i + ", j " + j);
					area = Math.max(area, areaAtIAndJ);

				}
			}
		}
		return area;
	}

	public int computeAreaOfIsland(int[][] grid, int rowPos, int colPos) {
		if (rowPos >= grid.length || rowPos < 0 || colPos >= grid[0].length || colPos < 0
				|| grid[rowPos][colPos] <= 0) {
			return 0;
		}

		int area = 0;
		if (grid[rowPos][colPos] == 1) {
			area = 1;
			grid[rowPos][colPos] = -1;
			area += computeAreaOfIsland(grid, rowPos + 1, colPos);
			area += computeAreaOfIsland(grid, rowPos - 1, colPos);
			area += computeAreaOfIsland(grid, rowPos, colPos + 1);
			area += computeAreaOfIsland(grid, rowPos, colPos - 1);
//			grid[rowPos][colPos] = 1;
		}

		return area;
	}

}
