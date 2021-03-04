package org.examples.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go
 * through empty spaces by rolling up, down, left or right, but it won't stop
 * rolling until hitting a wall. When the ball stops, it could choose the next
 * direction.
 * 
 * Given the ball's start position, the destination and the maze, find the
 * shortest distance for the ball to stop at the destination. The distance is
 * defined by the number of empty spaces traveled by the ball from the start
 * position (excluded) to the destination (included). If the ball cannot stop at
 * the destination, return -1.
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 * the empty space. You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column
 * indexes.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 1 1 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4) Input 3: destination
 * coordinate (rowDest, colDest) = (4, 4)
 * 
 * Output: 12
 * 
 * Explanation: One shortest way is : left -> down -> left -> down -> right ->
 * down -> right. The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 * 
 * 
 * @author rkata
 *
 */

public class MazeII {

	public static void main(String[] args) {
		MazeII solver = new MazeII();

		int[][] maze = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
//				[0,4]
//				[4,4]
		System.out.println(solver.shortestDistanceBFS(maze, new int[] { 0, 4 }, new int[] { 4, 0 }));
		System.out.println(solver.shortestDistanceDFS(maze, new int[] { 0, 4 }, new int[] { 4, 0 }));
	}

	public int shortestDistanceBFS(int[][] maze, int[] start, int[] destination) {
		LinkedList<int[]> bfsQ = new LinkedList<int[]>();
		bfsQ.add(start);

		int[][] distance = new int[maze.length][maze[0].length];
		for (int[] dir : distance) {
			Arrays.fill(dir, Integer.MAX_VALUE);
		}

		distance[start[0]][start[1]] = 0;

		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		while (!bfsQ.isEmpty()) {
			int[] pos = bfsQ.poll();
			// empty space
			for (int[] dir : dirs) {

				int rowPos = pos[0] + dir[0];
				int colPos = pos[1] + dir[1];
				int count = 0;
				while (rowPos >= 0 && rowPos < maze.length && colPos >= 0 && colPos < maze[0].length
						&& maze[rowPos][colPos] == 0) {
					rowPos = rowPos + dir[0];
					colPos = colPos + dir[1];
					count++;
				}

				if (distance[pos[0]][pos[1]] + count < distance[rowPos - dir[0]][colPos - dir[1]]) {
					distance[rowPos - dir[0]][colPos - dir[1]] = distance[pos[0]][pos[1]] + count;
					bfsQ.add(new int[] { rowPos - dir[0], colPos - dir[1] });
				}
			}
		}

		return (distance[destination[0]][destination[1]] == Integer.MAX_VALUE) ? -1
				: distance[destination[0]][destination[1]];
	}

	public int shortestDistanceDFS(int[][] maze, int[] start, int[] destination) {

		int[][] distance = new int[maze.length][maze[0].length];
		for (int[] dist : distance) {
			Arrays.fill(dist, Integer.MAX_VALUE);
		}
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		distance[start[0]][start[1]] = 0;
		dfsMaze(maze, start, distance, dirs);
		return (distance[destination[0]][destination[1]] == Integer.MAX_VALUE) ? -1
				: distance[destination[0]][destination[1]];
	}

	public void dfsMaze(int[][] maze, int[] pos, int[][] distance, int[][] dirs) {

		for (int[] dir : dirs) {
			int rowPos = pos[0] + dir[0];
			int colPos = pos[1] + dir[1];
			int numOfSteps = 0;
			while (rowPos >= 0 && rowPos < maze.length && colPos >= 0 && colPos < maze[0].length
					&& maze[rowPos][colPos] == 0) {
				rowPos += dir[0];
				colPos += dir[1];
				numOfSteps++;
			}

			if (distance[pos[0]][pos[1]] + numOfSteps < distance[rowPos - dir[0]][colPos - dir[1]]) {
				distance[rowPos - dir[0]][colPos - dir[1]] = distance[pos[0]][pos[1]] + numOfSteps;
				dfsMaze(maze, new int[] { rowPos - dir[0], colPos - dir[1] }, distance, dirs);
			}
		}
	}

}
