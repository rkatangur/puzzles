package org.examples.graph;

import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
public class Graph1 {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists
	private boolean directed = true;;

	// Constructor
	Graph1(int v) {
		V = v;
		adj = new LinkedList[v];

		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	Graph1(int v, boolean directed) {
		this(v);
		this.directed = directed;
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
		if (!directed) {
			adj[w].add(v);
		}
	}

	// Function to add an edge into the graph
	LinkedList<Integer> getEdges(int v) {
		return adj[v];
	}

	// Driver method to
	public static void main(String args[]) {
		Graph1 g = new Graph1(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
//
//		g.DFS(2);
	}

	public LinkedList<Integer>[] getAllEdges() {
		return adj;
	}
}
