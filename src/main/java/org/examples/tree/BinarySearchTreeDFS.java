package org.examples.tree;

/**
 * 
 * 
 * 1 / \ 2 5 / \ \ 3 4 6
 * 
 * @author rkata
 *
 */
public class BinarySearchTreeDFS {

	public void dfs(TreeNode node) {
		dfsHelper(node);
	}

	public void dfsHelper(TreeNode node) {
		if (node == null) {
			return;
		}

//		if (node.left == null && node.right == null) {
//			return node;
//		}

		System.out.println(node.val);
		dfsHelper(node.left);
		dfsHelper(node.right);
	}

	public static void main(String[] args) {
		BinarySearchTreeDFS solver = new BinarySearchTreeDFS();

		TreeNode left2Node = new TreeNode(2);
		left2Node.left = new TreeNode(3);
		left2Node.right = new TreeNode(4);

		TreeNode right5Node = new TreeNode(5);
		right5Node.right = new TreeNode(6);

		TreeNode root = new TreeNode(1);
		root.left = left2Node;
		root.right = right5Node;

		solver.dfs(root);
	}
}
