package org.examples.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.examples.arrays.ArraysUtil;

public class TopologicalSort {

	public static void main(String[] args) {
		TopologicalSort solver = new TopologicalSort();

//		Graph<Integer> graph = solver.buildGraph(2, new int[][] {});
//		int[] path = solver.buildTopologicalOrder(graph);
//		ArraysUtil.printIntArr(path);

//		int[][] data = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
//		Graph<Integer> graph = solver.buildGraph(4, data);
//		int[] path = solver.buildTopologicalOrder(graph);
//		ArraysUtil.printIntArr(path);

		int[][] data = new int[][] { { 0, 1 }, { 1, 0 }};
		Graph<Integer> graph = solver.buildGraph(2, data);	
		int[] path = solver.buildTopologicalOrder(graph);
		ArraysUtil.printIntArr(path);
	}

	public Graph<Integer> buildGraph(int numCourses, int[][] data) {
		Graph<Integer> graph = new Graph<Integer>();
		for (int i = 0; i < numCourses; i++) {
			graph.addNode(i);
		}

		for (int i = 0; i < data.length; i++) {
			graph.addEdge(data[i][1], data[i][0]);
		}
		return graph;
	}

	private int currentLabel;

	/**
	 * 
	 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]] Output:
	 * [0,2,1,3]
	 * 
	 * Explanation: There are a total of 4 courses to take. To take course 3 you
	 * should have finished both courses 1 and 2. Both courses 1 and 2 should be
	 * taken after you finished course 0. So one correct course order is [0,1,2,3].
	 * Another correct ordering is [0,2,1,3].
	 * 
	 * @param numOfNodes
	 * @param data
	 */
	public int[] buildTopologicalOrder(Graph<Integer> graph) {

		currentLabel = graph.nodesSize() - 1;
		Map<Integer, GNode<Integer>> allNodes = graph.nodes;

		int[] nodeOrdering = new int[allNodes.size()];
		int[] nodesRank = new int[allNodes.size()];
		int[] exploredNodes = new int[allNodes.size()];

		for (Map.Entry<Integer, GNode<Integer>> entry : allNodes.entrySet()) {
			GNode<Integer> gNode = entry.getValue();
			if (nodesRank[gNode.nodeVal] == 0) {
				// process the GNode
				if (!process(gNode, exploredNodes, nodeOrdering, nodesRank)) {
					return new int[] {};
				}
			}
		}

		return nodeOrdering;
	}

	private boolean process(GNode<Integer> gNode, int[] exploredNodes, int[] nodeOrdering, int[] nodesRank) {
		if (nodesRank[gNode.nodeVal] != 0) {
			return true;
		}

		if (exploredNodes[gNode.nodeVal] == 1) {
			return false;
		}
		// cycle here
		exploredNodes[gNode.nodeVal] = 1;
		for (GNode<Integer> outNode : gNode.outNodes) {
			if (!process(outNode, exploredNodes, nodeOrdering, nodesRank)) {
				return false;
			}
		}

		nodeOrdering[currentLabel] = gNode.nodeVal;
		nodesRank[gNode.nodeVal] = currentLabel;
		currentLabel = currentLabel - 1;
		exploredNodes[gNode.nodeVal] = 0;

		return true;
	}

	public class Graph<E> {

		private Map<E, GNode<E>> nodes = new HashMap<>();

		// Function to add an edge into the graph
		public void addNode(E v) {
			GNode<E> srcNode = nodes.get(v);
			if (srcNode == null) {
				srcNode = new GNode<E>(v);
				nodes.put(v, srcNode);
			}
		}

		// Function to add an edge into the graph
		public void addEdge(E v, E w) {
			GNode<E> srcNode = nodes.get(v);
			if (srcNode == null) {
				srcNode = new GNode<E>(v);
				nodes.put(v, srcNode);
			}

			GNode<E> destNode = nodes.get(w);
			if (destNode == null) {
				destNode = new GNode<E>(w);
				nodes.put(w, destNode);
			}

			srcNode.addEdge(destNode);
		}

		public int nodesSize() {
			return nodes.size();
		}
	}

	class GNode<E> {
		public E nodeVal;
		public Integer inDegrees = 0;
		public List<GNode<E>> outNodes = new LinkedList<GNode<E>>();

		public GNode(E v) {
			this.nodeVal = v;
		}

		public void addEdge(GNode<E> w) {
			this.outNodes.add(w);
		}
	}

}
