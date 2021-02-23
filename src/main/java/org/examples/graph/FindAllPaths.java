package org.examples.graph;

import java.util.ArrayList;
import java.util.List;

public class FindAllPaths {

	public static void main(String[] args) {
		FindAllPaths solver = new FindAllPaths();
		int[][] graph = new int[][] { { 1, 2 }, { 3 }, { 3 }, {} };
		List<List<Integer>> allPaths = solver.allPathsSourceTarget(graph);
	}

	/**
	 * Input: graph = [[1,2],[3],[3],[]] Output: [[0,1,3],[0,2,3]] Explanation:
	 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
	 */
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int startNode = 0;
		int endNode = graph.length - 1;
		List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
		List<Integer> currentPath = new ArrayList<Integer>();
		allPathsSourceTargetHelper(graph, startNode, endNode, allPaths, currentPath);

		return allPaths;
	}

	public void allPathsSourceTargetHelper(int[][] graph, int startNode, int endNode, List<List<Integer>> allPaths,
			List<Integer> currentPath) {
		if (startNode == endNode) {
			// reached end;
			currentPath.add(startNode);
			allPaths.add(new ArrayList<Integer>(currentPath));
			return;
		}

		currentPath.add(startNode);
		int[] edges = graph[startNode];
		if (edges != null) {
			for (int edge : edges) {
				allPathsSourceTargetHelper(graph, edge, endNode, allPaths, currentPath);
				currentPath.remove(currentPath.size() - 1);
			}
		}
	}
}
