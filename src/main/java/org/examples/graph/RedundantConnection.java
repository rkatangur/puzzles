package org.examples.graph;

import org.examples.arrays.ArraysUtil;

/**
 * 
 * 
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * The given input is a graph that started as a tree with N nodes (with distinct
 * values 1, 2, ..., N), with one additional edge added. The added edge has two
 * different vertices chosen from 1 to N, and was not an edge that already
 * existed.
 * 
 * The resulting graph is given as a 2D-array of edges. Each element of edges is
 * a pair [u, v] with u < v, that represents an undirected edge connecting nodes
 * u and v. Return an edge that can be removed so that the resulting graph is a
 * tree of N nodes. If there are multiple answers, return the answer that occurs
 * last in the given 2D-array.
 * 
 * The answer edge [u, v] should be in the same format, with u < v.
 * 
 * Example 1:
 * 
 * Input: [[1,2], [1,3], [2,3]] Output: [2,3]
 * 
 * Explanation: The given undirected graph will be like this: 1 / \ 2 - 3
 * 
 * 
 * Example 2: Input: [[1,2], [2,3], [3,4], [1,4], [1,5]] Output: [1,4]
 * Explanation: The given undirected graph will be like this: 5 - 1 - 2 | | 4 -
 * 3
 * 
 * @param edges
 * @return
 */
public class RedundantConnection {
	int MAX_EDGE_VAL = 1000;

	public static void main(String[] args) {
		RedundantConnection solver = new RedundantConnection();
		int[][] edges = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		ArraysUtil.printIntArr(solver.findRedundantConnection(edges));

//		[[1,2], [2,3], [3,4], [1,4], [1,5]]
		int[][] edges2 = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		ArraysUtil.printIntArr(solver.findRedundantConnection(edges2));
	}

	public int[] findRedundantConnection(int[][] edges) {
		DSU dsuSet = new DSU(MAX_EDGE_VAL + 1);
		for (int[] edge : edges) {
			if (!dsuSet.union(edge[0], edge[1])) {
				return edge;
			}
		}
		return null;
	}

	 class DSU {
		int[] parent;
		int[] rank;

		public DSU(int size) {
			parent = new int[size];
			for (int i = 0; i < size; i++) {
				parent[i] = i;
			}
			rank = new int[size];
		}

		public int find(int x) {
			if (parent[x] == x) {
				return x;
			} else {
				int curVal = x;
				while (curVal != parent[curVal]) {
					curVal = parent[curVal];
				}

				if (parent[x] != curVal) {
					parent[x] = curVal;
				}

				return parent[x];
			}
		}

		public boolean union(int x, int y) {
			int xr = find(x);
			int yr = find(y);
			if (xr == yr) {
				return false;
			} else if (rank[xr] < rank[yr]) {
				parent[xr] = yr;
			} else if (rank[xr] > rank[yr]) {
				parent[yr] = xr;
			} else {
				parent[yr] = xr;
				rank[xr]++;
			}
			return true;
		}
	}

}
