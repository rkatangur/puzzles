package org.examples.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienOrder {

	public static void main(String[] args) {
		AlienOrder solver = new AlienOrder();
		String[] words = new String[] { "wxqkj", "whqg", "cckgh", "cdxg", "cdxdt", "cdht", "ktgxt", "ktgch", "ktdw",
				"ktdc", "jqw", "jmc", "jmg" };
		System.out.println(solver.alienOrder(words));
	}

	public String alienOrder(String[] words) {

		int wordIdx = 0;
		String prevWord = words[wordIdx++];
		Graph<Character> charGraph = new Graph<Character>();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				charGraph.addNode(word.charAt(j));
			}
		}

		for (; wordIdx < words.length; wordIdx++) {
			String curWord = words[wordIdx];
			int i = 0;
			int length = Math.min(curWord.length(), prevWord.length());
			boolean foundMismatch = false;
			System.out.println("Comparing words [ prevWord " + prevWord + ", curWord " + curWord + " ].");
			for (; i < length; i++) {

				if (prevWord.length() > curWord.length() && prevWord.startsWith(curWord)) {
					return "";
				}

				if (!foundMismatch && i < prevWord.length() && i < curWord.length()
						&& prevWord.charAt(i) != curWord.charAt(i)) {
					foundMismatch = true;
					charGraph.addEdge(prevWord.charAt(i), curWord.charAt(i));
					break;
				}
			}

			if (!foundMismatch && prevWord.length() != curWord.length()) {
				System.out.println("Could not find any mismatch between prevWord " + prevWord + ", curWord " + curWord);
			}
			prevWord = curWord;
		}

		int charSize = charGraph.nodesSize();

		LinkedList<Character> queueOfChars = new LinkedList<Character>();
		for (Map.Entry<Character, GNode<Character>> graphEntry : charGraph.getAdjVertices().entrySet()) {
			GNode<Character> charGNode = graphEntry.getValue();
			if (charGNode.inDegrees == 0) {
				queueOfChars.add(charGNode.nodeVal);
			}
		}

		StringBuilder strSb = new StringBuilder();
		while (!queueOfChars.isEmpty()) {
			Character nodeLabel = queueOfChars.poll();
			if (nodeLabel != null) {
				strSb.append(nodeLabel);
				GNode<Character> charNode = charGraph.removeNode(nodeLabel);
				List<GNode<Character>> nodeEdges = charNode.outNodes;

				if (nodeEdges != null) {
					for (GNode<Character> nodeChar : nodeEdges) {
						nodeChar.decrementInDegree();
						if (nodeChar.inDegrees == 0) {
							queueOfChars.add(nodeChar.nodeVal);
						}
					}
				}
			}
		}

		printAllPaths(charGraph);

		if (strSb.length() < charSize) {
			return "";
		}
		return strSb.toString();
	}

	public static <E> void printAllPaths(Graph<E> graph) {
		Map<E, GNode<E>> allGraphVertices = graph.getAdjVertices();
		Set<E> visitedNodes = new HashSet<E>();
		List<E> path = new ArrayList<E>();
		for (Map.Entry<E, GNode<E>> graphEntry : allGraphVertices.entrySet()) {
			graphEntry.getKey();
			GNode<E> gNode = graphEntry.getValue();
			if (gNode.inDegrees == 0) {
				visitedNodes.clear();
				printAllPaths(graph, gNode, visitedNodes, path);
			}
		}
	}

	public static <E> void printAllPaths(Graph<E> graph, GNode<E> node, Set<E> visitedNodes, List<E> path) {
		path.add(node.nodeVal);

		if (!visitedNodes.contains(node.nodeVal)) {
			visitedNodes.add(node.nodeVal);

			for (GNode<E> nodeEdge : node.outNodes) {
				printAllPaths(graph, nodeEdge, visitedNodes, path);
			}
		}

		if (node.outNodes == null || node.outNodes.isEmpty()) {
			StringBuilder pathSb = new StringBuilder();
			path.stream().forEach(e -> {
				pathSb.append(e).append("->");
			});
			System.out.println(pathSb.toString());
		}

		path.remove(path.size() - 1);
	}

	public class Graph<E> {

		private Map<E, GNode<E>> nodes = new HashMap<>();

		public Map<E, GNode<E>> getAdjVertices() {
			return nodes;
		}

		public GNode<E> getNode(E nodeLabel) {
			return nodes.get(nodeLabel);
		}

		public GNode<E> removeNode(E nodeLabel) {
			return nodes.remove(nodeLabel);
		}

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

		public void decrementInDegree() {
			inDegrees = inDegrees - 1;
		}

		public boolean addEdge(GNode<E> w) {
			if (!outNodes.contains(w)) {
				w.inDegrees++;
				this.outNodes.add(w);
				System.out.println("Recoding a directed edge between " + nodeVal + " -> " + w.nodeVal);
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nodeVal == null) ? 0 : nodeVal.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GNode<E> other = (GNode<E>) obj;
			if (other.nodeVal != null) {
				return other.nodeVal.equals(nodeVal);
			} else {
				return false;
			}
		}

	}

}
