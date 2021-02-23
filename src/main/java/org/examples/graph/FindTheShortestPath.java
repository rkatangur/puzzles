package org.examples.graph;

import java.util.LinkedList;

public class FindTheShortestPath {

	public static void main(String[] args) {
		Graph1 grph1 = new Graph1(7, false);
		grph1.addEdge(1, 2);
		grph1.addEdge(1, 3);
		grph1.addEdge(2, 4);
		grph1.addEdge(3, 4);
		grph1.addEdge(3, 5);
		grph1.addEdge(4, 5);
		grph1.addEdge(4, 6);
		grph1.addEdge(5, 6);

		FindTheShortestPath solver = new FindTheShortestPath();
		System.out.println(solver.findShorteshPath(grph1, 1, 5));
	}

	private Integer findShorteshPath(Graph1 graph, int v, int e) {
		LinkedList<Integer>[] alledges = graph.getAllEdges();
		int[][] distances = new int[7][7];

		int[] visitedNodes = new int[7];

		int level = 0;
		LinkedList<Integer> bfsQ = new LinkedList<Integer>();
		for (int i = 1; i < alledges.length; i++) {
			if (visitedNodes[i] == 0) {
				bfsQ.add(i);
			}

			while (!bfsQ.isEmpty()) {
				int bfsQSize = bfsQ.size();
				for (int j = 0; j < bfsQSize; j++) {
					Integer vertex = bfsQ.poll();
					visitedNodes[vertex] = 1;
					distances[i][vertex] = level;

					for (Integer edge : alledges[vertex]) {
						if (visitedNodes[edge] == 0) {
							bfsQ.add(edge);
						}
					}
				}
				level++;
			}
		}

		return distances[v][e];

	}

}
