package org.examples.tree;

public class BinarySearchTreeHeight {

	public static void main(String[] args) {

		TreeNode rootNode = new TreeNode(5);
		TreeNode treeNode4 = new TreeNode(4);
		rootNode.left = treeNode4;
		TreeNode treeNode8 = new TreeNode(8);
		rootNode.right = treeNode8;

		TreeNode treeNode6 = new TreeNode(6);
		treeNode8.left = treeNode6;

		System.out.println(findHeightOfBinarySearchTree(rootNode));
	}

	public static int findHeightOfBinarySearchTree(TreeNode treeNode) {
		return findTreeHeight(treeNode);
	}

	public static int findTreeHeight(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}

		int leftTreeHeight = findTreeHeight(treeNode.left) + 1;
		int rightTreeHeight = findTreeHeight(treeNode.right) + 1;

		System.out.println("treeNode " + treeNode.val + " leftTreeHeight " + leftTreeHeight + ", rightTreeHeight "
				+ rightTreeHeight);
		return Math.max(leftTreeHeight, rightTreeHeight);
	}
}
