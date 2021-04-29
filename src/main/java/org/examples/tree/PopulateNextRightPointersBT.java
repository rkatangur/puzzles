package org.examples.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 116. Populating Next Right Pointers in Each Node
 * 
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following
 * definition:
 * 
 * struct Node { int val; Node *left; Node *right; Node *next; } Populate each
 * next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 * Follow up:
 * 
 * You may only use constant extra space. Recursive approach is fine, you may
 * assume implicit stack space does not count as extra space for this problem.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7] Output: [1,#,2,3,#,4,5,6,7,#] Explanation:
 * Given the above perfect binary tree (Figure A), your function should populate
 * each next pointer to point to its next right node, just like in Figure B. The
 * serialized output is in level order as connected by the next pointers, with
 * '#' signifying the end of each level.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the given tree is less than 4096. -1000 <= node.val <=
 * 1000
 * 
 */
public class PopulateNextRightPointersBT {

	public Node connect(Node root) {
		if (root == null)
			return root;

		LinkedList<Node> bfsQ = new LinkedList<>();
		bfsQ.add(root);

		while (!bfsQ.isEmpty()) {
			int qSize = bfsQ.size();
			List<Node> nextLevelNodes = new ArrayList<>();
			for (int i = 0; i < qSize; i++) {
				Node curNode = bfsQ.poll();
				if (bfsQ.isEmpty()) {
					curNode.next = null;
				} else {
					curNode.next = bfsQ.peek();
				}

				if (curNode.left != null) {
					nextLevelNodes.add(curNode.left);
				}

				if (curNode.right != null) {
					nextLevelNodes.add(curNode.right);
				}
			}
			bfsQ.addAll(nextLevelNodes);
		}

		return root;
	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

}