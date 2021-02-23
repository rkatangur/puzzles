package org.examples.recursion;

import org.examples.tree.TreeNode;

public class SymmetricTree {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * 
	 * For example, this binary tree is symmetric:
	 * 
	 * 1 / \ 2 2 / \ / \ 3 4 4 3 But the following is not:
	 * 
	 * 1 / \ 2 2 \ \ 3 3
	 *
	 */

	// Returns true if trees with roots as root1 and root2 are mirror
	boolean isMirror(TreeNode node) {
		return isMirror(node, node);
	}

	// Returns true if trees with roots as root1 and root2 are mirror
	boolean isMirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
			return false;
		} else if (node1.val != node2.val) {
			return false;
		}

		if (!isMirror(node1.left, node2.right)) {
			return false;
		}

		if (!isMirror(node1.right, node2.left)) {
			return false;
		}

		return true;
	}
}
