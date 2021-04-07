package org.examples.graph;

import java.util.LinkedList;

public class BipartiteGraph {

	public static void main(String[] args) {
		System.out.println("BipartiteGraph ");
		int[][] graph = new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		BipartiteGraph solver = new BipartiteGraph();
		System.out.println(solver.isBipartite(graph));
		int[][] graph1 = new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		System.out.println(solver.isBipartite(graph1));
	}

	public boolean isBipartite(int[][] graph) {
		int[] vertexColors = new int[graph.length];
		int colorToUse = 1;
		LinkedList<Integer> bfsQ = new LinkedList<Integer>();
		for (int i = 0; i < graph.length; i++) {
			if (vertexColors[i] == 0) {
				vertexColors[i] = colorToUse;
				bfsQ.add(i);
			}
			while (!bfsQ.isEmpty()) {
				int vertexToEval = bfsQ.poll();
				int[] vEdges = graph[vertexToEval];
				for (int edge : vEdges) {
					if (vertexColors[edge] == 0) {
						vertexColors[edge] = vertexColors[vertexToEval] * -1;
						bfsQ.add(edge);
					} else if (vertexColors[edge] == vertexColors[vertexToEval]) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
