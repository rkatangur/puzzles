package org.examples.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.examples.arrays.ArraysUtil;

public class CloneGraphDFS {

	public static void main(String[] args) {

//		 [[2,4],[1,3],[2,4],[1,3]]
		int[][] inputArr = new int[][] { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };

		CloneGraphDFS solver = new CloneGraphDFS();

		Node[] graphNodes = new Node[5];
		for (int i = 1; i < graphNodes.length; i++) {
			graphNodes[i] = solver.new Node(i);
		}

		for (int i = 0; i < inputArr.length; i++) {
			Node node = graphNodes[i + 1];
			for (int j = 0; j < inputArr[i].length; j++) {
				node.neighbors.add(graphNodes[inputArr[i][j]]);
			}
		}

		Node clonedNode = solver.cloneGraph(graphNodes[1]);
		solver.printGraph(clonedNode);
	}

	public void printGraph(Node node) {
		LinkedList<Node> bfsQueue = new LinkedList<Node>();
		bfsQueue.add(node);

		Set<Integer> visitedNodes = new HashSet<>();

		while (!bfsQueue.isEmpty()) {
			Node nodeToProcess = bfsQueue.poll();
			visitedNodes.add(nodeToProcess.val);

			int[] neighbors = new int[nodeToProcess.neighbors.size()];
			int i = 0;
			for (Node neighbor : nodeToProcess.neighbors) {
				neighbors[i++] = neighbor.val;
				if (!visitedNodes.contains(neighbor.val)) {
					bfsQueue.add(neighbor);
				}
			}
			ArraysUtil.printIntArr(neighbors);
		}

	}

	public Node cloneGraph(Node node) {

		if (node != null) {
			Map<Integer, Node> visitedNodes = new HashMap<Integer, Node>();
			return cloneGraph(node, visitedNodes);
		}
		return null;
	}

	public Node cloneGraph(Node node, Map<Integer, Node> visitedNodes) {
		if (node != null) {

			Node clonedNode = new Node();
			clonedNode.val = node.val;
			visitedNodes.putIfAbsent(clonedNode.val, clonedNode);
			for (Node nodeNeighbor : node.neighbors) {
				if (!visitedNodes.containsKey(nodeNeighbor.val)) {
					Node clonedNeighbor = cloneGraph(nodeNeighbor, visitedNodes);
					clonedNode.neighbors.add(clonedNeighbor);
				} else {
					clonedNode.neighbors.add(visitedNodes.get(nodeNeighbor.val));
				}
			}

			return clonedNode;
		}
		return null;
	}

	public class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}
