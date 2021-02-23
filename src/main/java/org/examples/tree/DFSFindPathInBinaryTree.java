package org.examples.tree;

import java.util.ArrayList;
import java.util.List;

public class DFSFindPathInBinaryTree {

	public static void main(String[] args) {

		TreeNode left4Val = new TreeNode(4);
		TreeNode left5Val = new TreeNode(5);

		TreeNode right6Val = new TreeNode(6);
		TreeNode right7Val = new TreeNode(7);

		TreeNode rleft2Val = new TreeNode(2, left4Val, left5Val);
		TreeNode rright3Val = new TreeNode(2, right6Val, right7Val);

		TreeNode root = new TreeNode(1, rleft2Val, rright3Val);

		DFSFindPathInBinaryTree solver = new DFSFindPathInBinaryTree();

		List<TreeNode> nodePath = new ArrayList<>();
		solver.findPath(root, 5, nodePath);

		nodePath.forEach(System.out::println);
	}

	private boolean findPath(TreeNode root, int nodeVal, List<TreeNode> nodePath) {
		if (root == null) {
			return false;
		}

		if (root.val == nodeVal) {
			nodePath.add(root);
			return true;
		}

		if (findPath(root.left, nodeVal, nodePath)) {
			nodePath.add(root);
			return true;
		} else if (findPath(root.right, nodeVal, nodePath)) {
			nodePath.add(root);
			return true;
		}

		return false;
	}
}
