package org.examples.graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * 886. Possible Bipartition
 * 
 * 
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split
 * everyone into two groups of any size.
 * 
 * Each person may dislike some other people, and they should not go into the
 * same group.
 * 
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the
 * people numbered a and b into the same group.
 * 
 * Return true if and only if it is possible to split everyone into two groups
 * in this way.
 * 
 * Example 1:
 * 
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 
 * Output: true Explanation: group1 [1,4], group2 [2,3]
 * 
 * Example 2:
 * 
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]] Output: false
 * 
 * 
 * @author rkata
 *
 */
public class PossibleBipartition {

	public static void main(String[] args) {
		int[][] data = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };
		PossibleBipartition solver = new PossibleBipartition();
		System.out.println(solver.possibleBipartition(5, data));

//		10
//		[[1,2],[3,4],[5,6],[6,7],[8,9],[7,8]]

		System.out.println(solver.possibleBipartition(10,
				new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 6, 7 }, { 8, 9 }, { 7, 8 } }));
	}

	@SuppressWarnings("unchecked")
	public boolean possibleBipartition(int N, int[][] dislikes) {
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int[] dislike : dislikes) {
			graph[dislike[0]].add(dislike[1]);
			graph[dislike[1]].add(dislike[0]);
		}

		Stack<Integer> dfsStack = new Stack<Integer>();
		int[] vertexColors = new int[N + 1];
		for (int i = 1; i < graph.length; i++) {

			if (vertexColors[i] == 0) {
				vertexColors[i] = 1;
				dfsStack.add(i);
			}

			while (!dfsStack.isEmpty()) {
				Integer vertex = dfsStack.pop();
				ArrayList<Integer> vEdges = graph[vertex];
				for (Integer edgeIndex : vEdges) {
					if (vertexColors[edgeIndex] == 0) {
						vertexColors[edgeIndex] = vertexColors[vertex] * -1;
						dfsStack.push(edgeIndex);
					} else if (vertexColors[edgeIndex] == vertexColors[vertex]) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
