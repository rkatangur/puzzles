package org.examples.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindElementsInContaminatedBinaryTree {

	Set<Integer> seen = new HashSet<>();

	public FindElementsInContaminatedBinaryTree(TreeNode root) {
		buildTree(root);
	}

	private void buildTree(TreeNode root) {
//		dfs(root, 0);
		bfs(root);
	}

	private void dfs(TreeNode root, int val) {
		if (root == null) {
			return;
		}

		seen.add(val);

		dfs(root.left, 2 * val + 1);
		dfs(root.right, 2 * val + 2);
	}

	private void bfs(TreeNode root) {
		LinkedList<TreeNode> bfsQueue = new LinkedList<TreeNode>();
		root.val = 0;
		
		bfsQueue.add(root);

		while (!bfsQueue.isEmpty()) {
			TreeNode node = bfsQueue.poll();
			seen.add(node.val);

			if (node.left != null) {
				node.left.val = 2 * node.val + 1;
				bfsQueue.add(node.left);
			}

			if (node.right != null) {
				node.right.val = 2 * node.val + 2;
				bfsQueue.add(node.right);
			}
		}
	}

	public boolean find(int target) {
		return seen.contains(target);
	}

}
