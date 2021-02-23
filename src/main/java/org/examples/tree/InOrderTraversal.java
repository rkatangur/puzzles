package org.examples.tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> nodes = new ArrayList<>();
		inorderTraversalHelper(root, nodes);
		return nodes;
	}

	public void inorderTraversalHelper(TreeNode root, List<Integer> nodes) {
		if (root == null) {
			return;
		}

		inorderTraversalHelper(root.left, nodes);
		nodes.add(root.val);
		inorderTraversalHelper(root.right, nodes);
	}
	
}
