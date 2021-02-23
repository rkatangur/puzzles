package org.examples.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	public static void main(String[] args) {

	}

	public static Node cloneGraph(Node node) {

		// Map of node and its copy
		Map<Node, Node> nodesAndItsCopy = new HashMap<>();
		LinkedList<Node> nodesToProcess = new LinkedList<>();
		nodesToProcess.add(node);

		Node nodeCopy = new Node(node.getLabel());
		nodesAndItsCopy.put(node, nodeCopy);

		while (!nodesToProcess.isEmpty()) {
			Node currentNode = nodesToProcess.poll();
			List<Node> currNodeNeighbors = currentNode.getNeighbors();
			if (currNodeNeighbors != null) {
				for (Node currNodeNeighbor : currNodeNeighbors) {
					if (nodesAndItsCopy.containsKey(currNodeNeighbor)) {
						nodesAndItsCopy.get(currentNode).getNeighbors().add(nodesAndItsCopy.get(currNodeNeighbor));
					} else {
						Node currNodeNeighborCopy = new Node(currNodeNeighbor.getLabel());
						nodesAndItsCopy.put(currNodeNeighbor, currNodeNeighborCopy);
						nodesAndItsCopy.get(currentNode).getNeighbors().add(currNodeNeighborCopy);
						nodesToProcess.add(currNodeNeighbor);
					}
				}
			}
		}

		return nodeCopy;
	}

	private static class Node {
		private final String label;
		private List<Node> neighbors = new ArrayList<Node>();

		public Node(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

		public List<Node> getNeighbors() {
			return neighbors;
		}
	}

}
