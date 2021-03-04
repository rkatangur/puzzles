package org.examples.graph;

/**
 * 
 * 
 * There is a ball in a maze with empty spaces (represented as 0) and walls
 * (represented as 1). The ball can go through the empty spaces by rolling up,
 * down, left or right, but it won't stop rolling until hitting a wall. When the
 * ball stops, it could choose the next direction.
 * 
 * Given the maze, the ball's start position and the destination, where start =
 * [startrow, startcol] and destination = [destinationrow, destinationcol],
 * return true if the ball can stop at the destination, otherwise return false.
 * 
 * You may assume that the borders of the maze are all walls (see examples).
 * 
 * Example 1:
 * 
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]],
 * start = [0,4], destination = [4,4] Output: true Explanation: One possible way
 * is : left -> down -> left -> down -> right -> down -> right.
 * 
 * @author rkata
 *
 */

public class Maze {

	public static void main(String[] args) {
		Maze solver = new Maze();

		int[][] maze = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(solver.hasPath(maze, new int[] { 0, 4 }, new int[] { 4, 4 }));
	}

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int[][] visited = new int[maze.length][maze[0].length];
		return dfsPath(maze, start, destination, visited);
	}

	public boolean dfsPath(int[][] maze, int[] start, int[] destination, int[][] visited) {
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		if (visited[start[0]][start[1]] == 1) {
			return false;
		}

		if (start[0] == destination[0] && start[1] == destination[1]) {
			return true;
		}

		visited[start[0]][start[1]] = 1;
		for (int[] dir : dirs) {

			int rPos = start[0] + dir[0];
			int cPos = start[1] + dir[1];

			while (rPos >= 0 && rPos < maze.length && cPos >= 0 && cPos < maze[0].length && maze[rPos][cPos] == 0) {
				rPos += dir[0];
				cPos += dir[1];
			}

			if (dfsPath(maze, new int[] { rPos - dir[0], cPos - dir[1] }, destination, visited)) {
				return true;
			}
		}
		return false;
	}

}
