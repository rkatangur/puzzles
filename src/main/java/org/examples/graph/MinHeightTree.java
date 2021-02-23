package org.examples.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinHeightTree {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) {
			return Arrays.asList(0);
		}

		Map<Integer, List<Integer>> treeAsGraph = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < edges.length; i++) {
			int node1 = edges[i][0];
			int node2 = edges[i][1];

			List<Integer> node1Edges = treeAsGraph.get(node1);
			if (node1Edges == null) {
				node1Edges = new LinkedList<Integer>();
				treeAsGraph.put(node1, node1Edges);
			}
			node1Edges.add(node2);

			List<Integer> node2Edges = treeAsGraph.get(node2);
			if (node2Edges == null) {
				node2Edges = new LinkedList<Integer>();
				treeAsGraph.put(node2, node2Edges);
			}
			node2Edges.add(node1);
		}

		if (treeAsGraph.size() <= 2) {
			return new ArrayList<Integer>(treeAsGraph.keySet());
		}

		int[] nodeProcessed = new int[n];
		Set<Integer> leafNodes = new HashSet<Integer>();
		int[] nonLeafNodes = new int[n];

		LinkedList<Integer> bfsQueue = new LinkedList<Integer>();

		bfsQueue.add(0);
		while (!bfsQueue.isEmpty()) {
			int curQSize = bfsQueue.size();
			while (curQSize > 0) {
				Integer nodeToProcess = bfsQueue.poll();
				System.out.println("Processing node " + nodeToProcess);
				nodeProcessed[nodeToProcess] = 1;

				List<Integer> nodeEdges = treeAsGraph.get(nodeToProcess);
				int numOfEdges = nodeEdges.size();
				for (Integer edgeNode : nodeEdges) {
					System.out.println("Processing edgeNode " + edgeNode);
					if (leafNodes.contains(edgeNode)) {
						numOfEdges--;
					} else if (nodeProcessed[edgeNode] == 0) {
						bfsQueue.add(edgeNode);
					}
				}

				if (numOfEdges <= 1) {
					// leaf Node
					leafNodes.add(nodeToProcess);
					nonLeafNodes[nodeToProcess] = 0;
				} else {
					nonLeafNodes[nodeToProcess] = 1;
				}
				curQSize--;
					
				for(int i =0; i<nonLeafNodes.size()-2; i++) {
					bfsQueue.addAll(nonLeafNodes);
				}
			}
		}

		return new ArrayList<Integer>(nonLeafNodes);
	}

}
