package org.examples.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeHeight {

	public static void main(String[] args) {

		TreeNode left4Node = new TreeNode(4);
		TreeNode left5Node = new TreeNode(5, new TreeNode(7), null);

		TreeNode right6Node = new TreeNode(6, new TreeNode(8), null);

		TreeNode left2Node = new TreeNode(2, left4Node, left5Node);
		TreeNode right3Node = new TreeNode(3, null, right6Node);

		TreeNode rootNode = new TreeNode(1, left2Node, right3Node);

		BinaryTreeHeight solver = new BinaryTreeHeight();
		List<String> longestPath = solver.longestLeafPath(rootNode);

		System.out.println("Longest path " + longestPath.size() + " height.");

		longestPath.forEach(System.out::println);
		
		solver.findHeight(rootNode);

		System.out.println("Height path " + longestPath.size() + " height.");
	}
	
	public int findHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int tempHeight = 1 + findHeight(node.left);
		int tempHeight2 = 1 + findHeight(node.right);

		return Math.max(tempHeight, tempHeight2);
	}


	public List<String> longestLeafPath(TreeNode node) {
		if (node == null) {
			return null;
		}
		List<String> nodePath = new ArrayList<String>();
		nodePath.add(String.valueOf(node.val));

		List<String> leftNodePath = longestLeafPath(node.left);
		List<String> rightNodePath = longestLeafPath(node.right);

		if (leftNodePath != null && rightNodePath != null) {
			if (leftNodePath.size() >= rightNodePath.size()) {
				nodePath.addAll(leftNodePath);
			} else {
				nodePath.addAll(rightNodePath);
			}
		} else if (leftNodePath != null) {
			nodePath.addAll(leftNodePath);
		} else if (rightNodePath != null) {
			nodePath.addAll(rightNodePath);
		}

		return nodePath;
	}
	
}
