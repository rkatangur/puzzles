package org.examples;

import java.util.Stack;

/*
Design and implement an iterator for a heterogenous list, where each element may be an int or a list of ints.
The iterator should iterate over the ints in order they appear in the list, including traversing the embedded lists.

Example input: {9, {1, 3}, 4, 5}
Expected iteration order: 9,1,3,4,5
*/
// {9, {1, 3, {6, 9, 11}}, 4, 5}

//      9
//   1   4   5
// 3   6 
//   9  11 12

// 9
// 1 4 5
// 5 4 1
// >> take the front of the queue which will be 1
// >>print data
// >>add 3 , 6 to the front of the queue
// >>take the front of the queue=3

public class HeterogenousIterator {

	public static class Node {
		int data;
		Node[] children;
	}

	public static class NodeIterator {

		private Stack<Node> queueOfNodes = new Stack<>();

		public NodeIterator(Node rootNode) {
			queueOfNodes.push(rootNode);
		}

		public boolean hasNext() {
			try {
				if (queueOfNodes.peek() != null) {
					return true;
				}
			} catch(Exception exe) {
			}
			return false;
		}

		public int next() {
			Node nodeToProcess = queueOfNodes.pop();

			if (nodeToProcess != null) {
				if (nodeToProcess.children != null) {
					// store in reverse order in the queue
					for (int i = nodeToProcess.children.length - 1; i >= 0; i--) {
						queueOfNodes.push(nodeToProcess.children[i]);
					}
				}
				return nodeToProcess.data;
			} else {
				return -1;
			}
		}
	}

	// {9, {1, 3, {6, 9, 11}}, 4, 5}

	// 9
	// 1 4 5
	// 3 6
	// 9 11 12

	// {9, {1, 3, {6, 9, 11, 12}}, 4, 5}
//		9   1  3   6  9  11  12    4  5
	public static void main(String[] args) {

		Node n = new Node();
		n.data = 9;

		Node n1 = new Node();
		n1.data = 1;

		Node n13 = new Node();
		n13.data = 3;

		Node n16 = new Node();
		n16.data = 6;

		n1.children = new Node[] { n13, n16 };

		Node n69 = new Node();
		n69.data = 9;

		Node n611 = new Node();
		n611.data = 11;

		Node n612 = new Node();
		n612.data = 12;

		n16.children = new Node[] { n69, n611, n612 };

		Node n4 = new Node();
		n4.data = 4;

		Node n5 = new Node();
		n5.data = 5;

		n.children = new Node[] { n1, n4, n5 };

		NodeIterator iterator = new NodeIterator(n);

		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}
	}
}
