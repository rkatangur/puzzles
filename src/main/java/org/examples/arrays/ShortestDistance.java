package org.examples.arrays;

import java.util.LinkedList;

/**
 * 
 * 
 * Shortest Distance from All Buildings You want to build a house on an empty
 * land which reaches all buildings in the shortest amount of distance. You can
 * only move up, down, left and right. You are given a 2D grid of values 0, 1 or
 * 2, where: Each 0 marks an empty land which you can pass by freely. Each 1
 * marks a building which you cannot pass through. Each 2 marks an obstacle
 * which you cannot pass through.
 * 
 * Example:
 * 
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * 
 * 1 - 0 - 2 - 0 - 1 | | | | | 0 - 0 - 0 - 0 - 0 | | | | | 0 - 0 - 1 - 0 - 0
 * 
 * Output: 7
 * 
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at
 * (0,2), the point (1,2) is an ideal empty land to build a house, as the total
 * travel distance of 3+3+1=7 is minimal. So return 7.
 * 
 * Note: There will be at least one building. If it is not possible to build
 * such house according to the above rules, return -1.
 * 
 * @author rkata
 *
 */

public class ShortestDistance {

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
		ShortestDistance solver = new ShortestDistance();
		System.out.println(solver.shortestDistance(grid));
	}

	public int shortestDistance(int[][] grid) {
		int[][] dist = new int[grid.length][grid[0].length];
		int numOfBuildings = 0;
		int[][] moves = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int[][] reach = new int[grid.length][grid[0].length];
		LinkedList<int[]> queueOfPos = new LinkedList<int[]>();

		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				if (grid[i][j] == 1) {

					boolean[][] isVisited = new boolean[grid.length][grid[0].length];
					numOfBuildings++;
					queueOfPos.add(new int[] { i, j });
					int level = 0;

					while (!queueOfPos.isEmpty()) {
						int qSize = queueOfPos.size();
						level++;
						for (int k = 0; k < qSize; k++) {
							int[] posFromQ = queueOfPos.poll();
							for (int[] move : moves) {
								int rowPos = posFromQ[0] + move[0];
								int colPos = posFromQ[1] + move[1];
								if (rowPos >= 0 && rowPos < grid.length && colPos >= 0 && colPos < grid[0].length
										&& grid[rowPos][colPos] == 0 && !isVisited[rowPos][colPos]) {
									dist[rowPos][colPos] += level;
									reach[rowPos][colPos]++;
									isVisited[rowPos][colPos] = true;
									queueOfPos.add(new int[] { rowPos, colPos });
								}
							}
						}
					}
				}
			}
		}

		int shortestDist = Integer.MAX_VALUE;
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				if (grid[i][j] == 0 && reach[i][j] == numOfBuildings) {
					shortestDist = Math.min(shortestDist, dist[i][j]);
				}
			}
		}

		if (shortestDist == Integer.MAX_VALUE) {
			return -1;
		}
		return shortestDist;
	}
}
