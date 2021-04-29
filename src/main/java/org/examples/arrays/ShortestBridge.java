package org.examples.arrays;

import java.util.LinkedList;

/**
 * 
 * 934. Shortest Bridge In a given 2D binary array A, there are two islands. (An
 * island is a 4-directionally connected group of 1s not connected to any other
 * 1s.)
 * 
 * Now, we may change 0s to 1s so as to connect the two islands together to form
 * 1 island.
 * 
 * Return the smallest number of 0s that must be flipped. (It is guaranteed that
 * the answer is at least 1.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [[0,1],[1,0]] Output: 1 Example 2:
 * 
 * Input: A = [[0,1,0],[0,0,0],[0,0,1]] Output: 2 Example 3:
 * 
 * Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * 
 * 
 * @author rkata
 *
 */
public class ShortestBridge {

	public int shortestBridge(int[][] A) {

		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		boolean[][] visited = new boolean[A.length][A[0].length];
		boolean islandFound = false;
		// 1. dfs to find an island, mark it in `visited`
		LinkedList<int[]> firstIslandBfsQ = new LinkedList<int[]>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					islandFound = true;
					dfs(A, firstIslandBfsQ, visited, i, j, dirs);
					break;
				}
			}

			if (islandFound) {
				break;
			}
		}

		//
		int numOfSteps = 0;
		while (!firstIslandBfsQ.isEmpty()) {
			int firstIslandQSize = firstIslandBfsQ.size();
			for (int i = 0; i < firstIslandQSize; i++) {
				int[] pos = firstIslandBfsQ.pop();
				for (int[] dir : dirs) {
					int rowP = pos[0] + dir[0];
					int colP = pos[1] + dir[1];
					if (rowP >= 0 && rowP < A.length && colP >= 0 && colP < A[0].length && !visited[rowP][colP]) {
						if (A[rowP][colP] == 1) {
							return numOfSteps;
						}
						firstIslandBfsQ.add(new int[] { rowP, colP });
						visited[rowP][colP] = true;
					}
				}
			}
			numOfSteps++;
		}

		return numOfSteps;
	}

	private void dfs(int[][] a, LinkedList<int[]> firstIsland, boolean[][] visited, int i, int j, int[][] dirs) {
		if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 0 || visited[i][j]) {
			return;
		}

		visited[i][j] = true;
		firstIsland.add(new int[] { i, j });
		for (int[] dir : dirs) {
			dfs(a, firstIsland, visited, i + dir[0], j + dir[1], dirs);
		}
	}

}
