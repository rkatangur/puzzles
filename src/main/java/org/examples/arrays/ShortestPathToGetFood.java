package org.examples.arrays;

import java.util.LinkedList;

/**
 * 
 * 1730. Shortest Path to Get Food
 * 
 * You are starving and you want to eat food as quickly as possible. You want to
 * find the shortest path to arrive at any food cell.
 * 
 * You are given an m x n character matrix, grid, of these different types of
 * cells:
 * 
 * '*' is your location. There is exactly one '*' cell. '#' is a food cell.
 * There may be multiple food cells. 'O' is free space, and you can travel
 * through these cells. 'X' is an obstacle, and you cannot travel through these
 * cells. You can travel to any adjacent cell north, east, south, or west of
 * your current location if there is not an obstacle.
 * 
 * Return the length of the shortest path for you to reach any food cell. If
 * there is no path for you to reach food, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid =
 * [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
 * Output: 3 Explanation: It takes 3 steps to reach the food. Example 2:
 * 
 * 
 * Input: grid =
 * [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
 * Output: -1 Explanation: It is not possible to reach the food. Example 3:
 * 
 * 
 * Input: grid =
 * [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
 * Output: 6 Explanation: There can be multiple food cells. It only takes 6
 * steps to reach the bottom food. Example 4:
 * 
 * Input: grid = [["O","*"],["#","O"]] Output: 2 Example 5:
 * 
 * Input: grid = [["X","*"],["#","X"]] Output: -1
 * 
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 200 grid[row][col] is '*',
 * 'X', 'O', or '#'. The grid contains exactly one '*'.
 * 
 * 
 * @author rkata
 *
 */
public class ShortestPathToGetFood {

	public int getFood(char[][] grid) {
		int[] startLoc = new int[2];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '*') {
					// start
					startLoc = new int[] { i, j };
				}
			}
		}

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		LinkedList<int[]> bfsQOfPos = new LinkedList<int[]>();
		bfsQOfPos.add(startLoc);

		int[][] posPostions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int steps = 0;
		int minSteps = Integer.MAX_VALUE;
		while (!bfsQOfPos.isEmpty()) {
			int length = bfsQOfPos.size();
			for (int i = 0; i < length; i++) {
				int[] curPos = bfsQOfPos.poll();
				visited[curPos[0]][curPos[1]] = true;

				if (grid[curPos[0]][curPos[1]] == '#') {
					minSteps = Math.min(steps, minSteps);
					break;
				}

				for (int[] pos : posPostions) {
					int newRow = curPos[0] + pos[0];
					int newCol = curPos[1] + pos[1];

					if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
							|| visited[newRow][newCol]) {
						continue;
					}

					if (grid[newRow][newCol] != 'X') {
						visited[newRow][newCol] = true;
						bfsQOfPos.add(new int[] { newRow, newCol });
					}
				}
			}
			steps++;
		}

		return steps;
	}

}
