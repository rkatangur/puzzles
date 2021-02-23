package org.examples.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteTreeNodes {

	public static void main(String[] args) {
		DeleteTreeNodes solver = new DeleteTreeNodes();
		System.out.println(
				solver.deleteTreeNodes(7, new int[] { -1, 0, 0, 1, 2, 2, 2 }, new int[] { 1, -2, 4, 0, -2, -1, -1 }));

//		System.out.println(
//				solver.deleteTreeNodes(7, new int[] { -1, 0, 0, 1, 2, 2, 2 }, new int[] { 1, -2, 4, 0, -2, -1, -2 }));

//		
//		7
//		[-1,0,0,1,2,2,2] [1,-2,4,0,-2,-1,-2]
	}

	public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
		Map<Integer, List<Integer>> treeOfNodes = new HashMap<Integer, List<Integer>>();

		int rootIndex = -1;
		for (int i = 0; i < nodes; i++) {
			int parentIndex = parent[i];
			if (parentIndex == -1) {
				rootIndex = i;
			} else {

				List<Integer> nodeIChildren = treeOfNodes.get(i);
				if (nodeIChildren == null) {
					nodeIChildren = new ArrayList<Integer>();
					treeOfNodes.put(i, nodeIChildren);
				}

				List<Integer> nodeChildren = treeOfNodes.get(parentIndex);
				if (nodeChildren == null) {
					nodeChildren = new ArrayList<Integer>();
					treeOfNodes.put(parentIndex, nodeChildren);
				}
				nodeChildren.add(i);
			}
		}

		deleteTreeNodes(rootIndex, treeOfNodes, value);
		return treeOfNodes.size();
	}

	public int deleteTreeNodes(Integer rootNode, Map<Integer, List<Integer>> treeOfNodes, int[] value) {
		if (rootNode == null) {
			return 0;
		}

		int totalOfNode = value[rootNode];
		List<Integer> nodeChildren = treeOfNodes.get(rootNode);
		if (nodeChildren != null) {
			for (Integer child : nodeChildren) {
				totalOfNode += deleteTreeNodes(child, treeOfNodes, value);
			}
		}

		if (totalOfNode == 0) {
			removeNode(rootNode, treeOfNodes);
		}

		return totalOfNode;
	}

	public void removeNode(Integer nodeToRemove, Map<Integer, List<Integer>> treeOfNodes) {

		List<Integer> nodeChildren = treeOfNodes.get(nodeToRemove);

		if (nodeChildren != null) {
			for (Integer child : nodeChildren) {
				removeNode(child, treeOfNodes);
			}
		}

		treeOfNodes.remove(nodeToRemove);
	}
}
