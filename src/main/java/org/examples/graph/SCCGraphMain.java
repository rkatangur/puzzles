package org.examples.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import org.examples.util.FileUtil;

//You should output the sizes of the 5 largest SCCs in the given graph, in decreasing order of sizes, 
//separated by commas (avoid any spaces). 
//So if your algorithm computes the sizes of the five largest SCCs to be 500, 400, 300, 200 and 100, then your answer should be "500,400,300,200,100" (without the quotes). If your algorithm finds less than 5 SCCs, then write 0 for the remaining terms. Thus, if your algorithm computes only 3 SCCs whose sizes are 400, 300, and 100, then your answer should be "400,300,100,0,0" (without the quotes).  (Note also that your answer should not have any spaces in it.)
public class SCCGraphMain {

	public static void main(String[] args) {
		SCCGraphMain solver = new SCCGraphMain();
		Graph srcGrph = new Graph(10);
		srcGrph.addEdge(1, 4);
		srcGrph.addEdge(4, 7);
		srcGrph.addEdge(7, 1);
		srcGrph.addEdge(9, 7);
		srcGrph.addEdge(9, 3);
		srcGrph.addEdge(3, 6);
		srcGrph.addEdge(6, 9);
		srcGrph.addEdge(6, 8);
		srcGrph.addEdge(8, 5);
		srcGrph.addEdge(5, 2);
		srcGrph.addEdge(2, 8);

//		Graph graph = solver.buildGraphFromFile();
//		875715
		System.out.println(srcGrph.adj.length);
		Graph revGraph = solver.reverseGraph(srcGrph, 10);
		System.out.println(revGraph.adj.length);

		solver.DFSLoop(revGraph);
	}

	private int[] finishingTimes = new int[875715];
	private int t = 0;
	private int s = 0;

	public void DFSLoop(Graph graph) {
		int nodeI = graph.adj.length - 1;
		int[] visitedNodes = new int[graph.adj.length];
		for (; nodeI > 0; nodeI--) {
			if (visitedNodes[nodeI] == 0) {
				// invoke DFS
				s = nodeI;
				dfs(graph, nodeI, visitedNodes);
			}
		}
	}

	private void dfs(Graph graph, int node, int[] visitedNodes) {
		visitedNodes[node] = 1;
		for (Integer adjNode : graph.adj[node]) {
			if (visitedNodes[adjNode] == 0) {
				dfs(graph, adjNode, visitedNodes);
			}
		}
		finishingTimes[node] = ++t;
	}

	public Graph reverseGraph(Graph g, int size) {
		Graph revG = new Graph(size);

		for (int i = 1; i < g.adj.length; i++) {
			LinkedList<Integer> iAdjNodes = g.adj[i];
			for (Integer adjNode : iAdjNodes) {
				revG.addEdge(adjNode, i);
			}
		}
		return revG;
	}

	private Graph buildGraphFromFile() {
		String sccFile = "SCC.txt";
		InputStream sccInputStream = null;
		BufferedReader br = null;
		Graph graph = null;
		try {
			sccInputStream = FileUtil.findFile(sccFile);
			br = new BufferedReader(new InputStreamReader(sccInputStream));
			String line;
			try {
				graph = new Graph(875715);
				line = br.readLine();
				while (line != null) {
					String[] lineArgs = line.split(" ");
					String vertex1 = null;
					String vertex2 = null;
					for (String lineArg : lineArgs) {
						if (lineArg == null || "".equals(lineArg.trim())) {
							continue;
						}
						if (vertex1 == null) {
							vertex1 = lineArg;
						} else if (vertex2 == null) {
							vertex2 = lineArg;
						}
					}

					graph.addEdge(Integer.parseInt(vertex1), Integer.parseInt(vertex2));
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sccInputStream != null) {
					sccInputStream.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return graph;
	}

	private static class Graph {

		private int V; // No. of vertices
		private LinkedList<Integer> adj[]; // Adjacency Lists

		// Constructor
		public Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList<Integer>();
		}

		// Function to add an edge into the graph
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

	}
}
