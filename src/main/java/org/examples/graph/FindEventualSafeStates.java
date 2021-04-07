package org.examples.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 802. Find Eventual Safe States
 * 
 * We start at some node in a directed graph, and every turn, we walk along a
 * directed edge of the graph. If we reach a terminal node (that is, it has no
 * outgoing directed edges), we stop. We define a starting node to be safe if we
 * must eventually walk to a terminal node. More specifically, there is a
 * natural number k, so that we must have stopped at a terminal node in less
 * than k steps for any choice of where to walk.
 * 
 * Return an array containing all the safe nodes of the graph. The answer should
 * be sorted in ascending order.
 * 
 * The directed graph has n nodes with labels from 0 to n - 1, where n is the
 * length of graph. The graph is given in the following form: graph[i] is a list
 * of labels j such that (i, j) is a directed edge of the graph, going from node
 * i to node j.
 * 
 * @author rkata
 *
 */

public class FindEventualSafeStates {

	public static void main(String[] args) {
		FindEventualSafeStates solver = new FindEventualSafeStates();
		List<Integer> resList = solver
				.eventualSafeNodesUsingDFS(new int[][] { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} });
		for (Integer i : resList) {
			System.out.print(i + ", ");
		}
		System.out.println("");
	}

	public List<Integer> eventualSafeNodesUsingDFS(int[][] graph) {
		List<Integer> results = new ArrayList<Integer>();
		int[] nodeColors = new int[graph.length + 1];
		for (int nodeIndex = 0; nodeIndex < graph.length; nodeIndex++) {
			if (nodeColors[nodeIndex] == 0) {
				eventualSafeNodesDfsHelper(graph, nodeIndex, nodeColors);
			}

			if (nodeColors[nodeIndex] == 2) {
				results.add(nodeIndex);
			}
		}
		return results;
	}

	public void eventualSafeNodesDfsHelper(int[][] graph, int nodeIndex, int[] nodeColors) {
		int[] nodeNeighbors = graph[nodeIndex];
		nodeColors[nodeIndex] = 1;

		boolean isSafeNode = true;
		for (int neighborNodeIndex : nodeNeighbors) {
			if (nodeColors[neighborNodeIndex] == 0) {
				eventualSafeNodesDfsHelper(graph, neighborNodeIndex, nodeColors);
			}

			if (nodeColors[neighborNodeIndex] == 1) {
				isSafeNode = false;
			}
		}

		if (isSafeNode) {
			nodeColors[nodeIndex] = 2;
		}
	}

	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> results = new ArrayList<Integer>();
		int[] nodeColors = new int[graph.length + 1];
		for (int nodeIndex = 0; nodeIndex < graph.length; nodeIndex++) {
			if (nodeColors[nodeIndex] == 0) {
				process(graph, nodeColors, nodeIndex);
			}

			if (nodeColors[nodeIndex] == 2) {
				results.add(nodeIndex);
			}
		}
		return results;
	}

	// colors: WHITE 0, GRAY 1, BLACK 2;
	public void process(int[][] graph, int[] nodeColors, int node) {

		Stack<Integer> dfsStack = new Stack<Integer>();
		dfsStack.add(node);

		while (!dfsStack.isEmpty()) {
			int curSize = dfsStack.size();
			Integer peekedNode = dfsStack.peek();
			nodeColors[peekedNode] = 1;
			int[] nodeEdges = graph[peekedNode];

			boolean isCyclePresent = false;
			if (nodeEdges != null && nodeEdges.length > 0) {
				for (int nodeEdge : nodeEdges) {
					if (nodeColors[nodeEdge] == 0) {
						dfsStack.push(nodeEdge);
					} else if (nodeColors[nodeEdge] == 1) {
						isCyclePresent = true;
					}
				}
			}

			if (curSize == dfsStack.size()) {
				dfsStack.pop();
				// no new nodes added
				if (!isCyclePresent) {
					nodeColors[peekedNode] = 2;
				}
			}
		}

	}

}
