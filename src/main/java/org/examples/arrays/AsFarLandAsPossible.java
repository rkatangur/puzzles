package org.examples.arrays;

import java.util.LinkedList;

/**
 *
 * 1162. As Far from Land as Possible
 * 
 * Given an n x n grid containing only values 0 and 1, where 0 represents water
 * and 1 represents land, find a water cell such that its distance to the
 * nearest land cell is maximized, and return the distance. If no land or water
 * exists in the grid, return -1.
 * 
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * Output: 2 Explanation: The cell (1, 1) is as far as possible from all the
 * land with distance 2.
 * 
 * 
 * Example 2:
 * 
 * Input: grid = [[1,0,0],[0,0,0],[0,0,0]] Output: 4
 * 
 * Explanation: The cell (2, 2) is as far as possible from all the land with
 * distance 4.
 * 
 * 
 * @author rkata
 *
 */
public class AsFarLandAsPossible {

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		AsFarLandAsPossible solver = new AsFarLandAsPossible();
		System.out.println(solver.maxDistance(grid));
	}

	public int maxDistance(int[][] grid) {
		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		LinkedList<int[]> bfsQofPos = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// this is land cell.
				if (grid[i][j] == 1) {
					bfsQofPos.add(new int[] { i, j });
				}
			}
		}

		boolean[][] isVisited = new boolean[grid.length][grid[0].length];
		int level = -1;
		while (!bfsQofPos.isEmpty()) {
			level++;
			int curSize = bfsQofPos.size();
			for (int i = 0; i < curSize; i++) {
				int[] pos = bfsQofPos.poll();
				for (int[] dir : directions) {
					int rowPos = pos[0] + dir[0];
					int colPos = pos[1] + dir[1];
					if (rowPos >= 0 && rowPos < grid.length && colPos >= 0 && colPos < grid[0].length
							&& grid[rowPos][colPos] == 0 && !isVisited[rowPos][colPos]) {
						isVisited[rowPos][colPos] = true;
						bfsQofPos.add(new int[] { rowPos, colPos });
					}
				}
			}
		}

		if (level == 0) {
			return -1;
		}

		return level;
	}

}
