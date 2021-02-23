package org.examples.graph;

import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
public class BFSGraph {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	BFSGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// Driver method to
	public static void main(String args[]) {
		BFSGraph g = new BFSGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}

	public void BFS(int val) {
		int[] visitedNodes = new int[V];
		LinkedList<Integer> nodesToProcess = new LinkedList<Integer>();
		nodesToProcess.add(val);

		while (!nodesToProcess.isEmpty()) {
			int size = nodesToProcess.size();
			for (int i = 0; i < size; i++) {
				Integer node = nodesToProcess.poll();
				if (node != null) {
					System.out.println("Processing node: " + node);
					visitedNodes[node] = 1;
					LinkedList<Integer> adjacentNodes = adj[node];
					for (Integer adjNode : adjacentNodes) {
						if (visitedNodes[adjNode] == 0) {
							nodesToProcess.add(adjNode);
						} else {
							System.out.println("Not adding node: " + node + " as it is visited.");
						}
					}
				}
			}
		}

	}
}
