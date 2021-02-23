package org.examples.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		solver.shortestDistance(grid);
	}

	public int shortestDistance(int[][] grid) {
		int shortestDistance = Integer.MAX_VALUE;
		Set<Integer> buildingsPos = new HashSet<>();
		int numOfColumns = grid[0].length;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					// check all positions.
					int cord = i * numOfColumns + j;
					buildingsPos.add(cord);
				}
			}
		}

		LinkedList<Integer> queueOfInts = new LinkedList<Integer>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					shortestDistanceHelper(grid, i, j, buildingsPos);
				}
			}
		}

		return -1;
	}

	public int shortestDistanceHelper(int[][] grid, int rowPos, int colPos, Set<Integer> buildingsPos,
			Map<Integer, List<Integer>> mapOfLengths) {
		if (rowPos >= grid.length || rowPos < 0 || colPos >= grid[0].length || colPos < 0 || grid[rowPos][colPos] == 2
				|| grid[rowPos][colPos] == -1) {
			return -1;
		}
		
		int numOfColms = grid[0].length;
		int cord = rowPos * numOfColms + colPos;

		if (grid[rowPos][colPos] == 1) {
			return 1;
		}


		grid[rowPos][colPos] = -1;

		int result1 = shortestDistanceHelper(grid, rowPos + 1, colPos, buildingsPos, mapOfLengths);
		if (result1 >= 1) {
			mapOfLengths.get(cord).add(result1 + 1);
		}

		int result2 = shortestDistanceHelper(grid, rowPos - 1, colPos, buildingsPos, mapOfLengths);
		if (result2 == 1) {
			mapOfLengths.get(cord).add(result2 + 1);
		}

		int result3 = shortestDistanceHelper(grid, rowPos, colPos + 1, buildingsPos, mapOfLengths);
		if (result3 == 1) {
			mapOfLengths.get(cord).add(result3 + 1);
		}

		int result4 = shortestDistanceHelper(grid, rowPos, colPos - 1, buildingsPos, mapOfLengths);
		if (result4 == 1) {
			mapOfLengths.get(cord).add(result4 + 1);
		}

		grid[rowPos][colPos] = 0;
		return 1;
	}

}
