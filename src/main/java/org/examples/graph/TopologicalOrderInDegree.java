package org.examples.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.examples.arrays.ArraysUtil;

public class TopologicalOrderInDegree {

	public static void main(String[] args) {
		TopologicalOrderInDegree solver = new TopologicalOrderInDegree();
		int[][] data = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] ret = solver.findOrder(4, data);
		ArraysUtil.printIntArr(ret);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		Map<Integer, Integer> inDegMap = new HashMap<Integer, Integer>();

		// Create the adjacency list representation of the graph
		for (int i = 0; i < prerequisites.length; i++) {
			int dest = prerequisites[i][0];
			int src = prerequisites[i][1];
			List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
			lst.add(dest);
			adjList.put(src, lst);

			Integer destIndeg = inDegMap.get(dest);
			if (destIndeg == null) {
				destIndeg = 1;
			} else {
				destIndeg++;
			}
			inDegMap.put(dest, destIndeg);
		}

		LinkedList<Integer> zeroInDegNodes = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			Integer indegOfCourse = inDegMap.get(i);
			if (indegOfCourse == null || indegOfCourse == 0) {
				zeroInDegNodes.add(i);
			}
		}

		List<Integer> st = new ArrayList<Integer>();

		while (!zeroInDegNodes.isEmpty()) {
			Integer zeroIndegNode = zeroInDegNodes.pop();
			List<Integer> edgesOfNode = adjList.get(zeroIndegNode);

			if (edgesOfNode != null) {
				for (Integer edge : edgesOfNode) {
					Integer degOfEdge = inDegMap.get(edge);
					if (degOfEdge != null) {
						degOfEdge = degOfEdge - 1;
					}
					inDegMap.put(edge, degOfEdge);

					if (degOfEdge == null || degOfEdge == 0) {
						zeroInDegNodes.add(edge);
					}
				}
			}

			st.add(zeroIndegNode);
		}

		int[] ord = new int[st.size()];
		for (int i = 0; i < ord.length; i++) {
			ord[i] = st.get(i);
		}

		return ord;
	}
	
}
