package org.examples.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximumDepthOfATree {

	public static void main(String[] args) {
		MaximumDepthOfATree solver = new MaximumDepthOfATree();
//		
		Integer[] naryTree = new Integer[] { 1, null, 3, 2, 4, null, 5, 6 };

		Node firstNonNullNode = new Node(naryTree[0]);
		Node rootNode = firstNonNullNode;
		rootNode.children = new ArrayList<MaximumDepthOfATree.Node>();
		for (int i = 1; i < naryTree.length; i++) {
			if (naryTree[i] == null) {
				rootNode = firstNonNullNode;
				rootNode.children = new ArrayList<MaximumDepthOfATree.Node>();
				firstNonNullNode = null;
			} else {
				Node node = new Node(naryTree[i]);
				rootNode.children.add(node);

				if (firstNonNullNode == null) {
					firstNonNullNode = node;
				}
			}
		}

		System.out.println(solver.maxDepth(rootNode));
	}

	public int maxDepth(Node root) {
		int maxDepth = 0;
		LinkedList<Node> bfsQ = new LinkedList<Node>();
		bfsQ.add(root);
		while (!bfsQ.isEmpty()) {
			int size = bfsQ.size();
			for (int i = 0; i < size; i++) {
				Node elem = bfsQ.poll();
				List<Node> elemChilds = elem.children;
				if (elemChilds != null) {
					bfsQ.addAll(elem.children);
				}
			}
			maxDepth++;
		}
		return maxDepth;
	}

	// Definition for a Node.
	private static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

}
