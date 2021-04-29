package org.examples.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javafx.util.Pair;

/**
 * 
 * 1192. Critical Connections in a Network
 * 
 * There are n servers numbered from 0 to n-1 connected by undirected
 * server-to-server connections forming a network where connections[i] = [a, b]
 * represents a connection between servers a and b. Any server can reach any
 * other server directly or indirectly through the network.
 * 
 * A critical connection is a connection that, if removed, will make some server
 * unable to reach some other server.
 * 
 * Return all critical connections in the network in any order.
 * 
 * Example 1:
 * 
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]] Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * 
 * Constraints:
 * 
 * 1 <= n <= 10^5 n-1 <= connections.length <= 10^5 connections[i][0] !=
 * connections[i][1] There are no repeated connections.
 * 
 * 
 * @author rkata
 *
 */
public class CriticalConnections {

	Map<Integer, List<Integer>> graph = null;
	Map<Pair<Integer, Integer>, Boolean> connDict = null;
	Map<Integer, Integer> rankMap = null;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		graph = new TreeMap<>();
		connDict = new HashMap<>();
		rankMap = new HashMap<>();

		for (List<Integer> connection : connections) {
			int v = connection.get(0);
			int u = connection.get(1);

			graph.putIfAbsent(v, new ArrayList<Integer>());
			graph.get(v).add(u);

			graph.putIfAbsent(u, new ArrayList<Integer>());
			graph.get(u).add(v);

			int[] gNodes = new int[] { v, u };
			Arrays.sort(gNodes);

			connDict.put(new Pair<Integer, Integer>(gNodes[0], gNodes[1]), true);
		}

		dfs(0, 0);

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (Pair<Integer, Integer> entry : connDict.keySet()) {
			results.add(Arrays.asList(entry.getKey(), entry.getValue()));
		}

		return results;
	}

	private int dfs(int node, int discoveryRank) {

		// That means this node is already visited. We simply return the rank.
		if (rankMap.get(node) != null) {
			return rankMap.get(node);
		}

		// Update the rank of this node.
		rankMap.put(node, discoveryRank);

		// This is the max we have seen till now. So we start with this instead of
		// INT_MAX or something.
		int minRank = discoveryRank + 1;

		List<Integer> nodeNeighbors = graph.get(node);
		for (Integer neighbor : nodeNeighbors) {

			// Skip the parent.
			Integer neighRank = this.rankMap.get(neighbor);
			if (neighRank != null && neighRank == discoveryRank - 1) {
				continue;
			}

			// Recurse on the neighbor.
			int recursiveRank = dfs(neighbor, discoveryRank + 1);

			if (recursiveRank <= discoveryRank ) {
				// remove this neighbor as it is a cycle.
				int[] nodes = new int[] { node, neighbor };
				Arrays.sort(nodes);
				connDict.remove(new Pair<Integer, Integer>(nodes[0], nodes[1]));
			}

			minRank = Math.min(minRank, recursiveRank);
		}

		return minRank;
	}

}
