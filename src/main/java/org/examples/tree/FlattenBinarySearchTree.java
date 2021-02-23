package org.examples.tree;

/**
 * 
 * 
 * 1 / \ 2 5 / \ \ 3 4 6
 * 
 * @author rkata
 *
 */
public class FlattenBinarySearchTree {

	public void flatten(TreeNode node) {
		flattenHelper(node);
	}

	public TreeNode flattenHelper(TreeNode node) {
		if (node == null) {
			return null;
		}

		if (node.left == null && node.right == null) {
			return node;
		}

		TreeNode leftNodeTail = flattenHelper(node.left);
		TreeNode rightNodeTail = flattenHelper(node.right);

		if (leftNodeTail != null) {
			leftNodeTail.right = node.right;
			node.right = node.left;
			node.left = null;
		}

		return (rightNodeTail == null) ? leftNodeTail : rightNodeTail;
	}

	public static void main(String[] args) {
		FlattenBinarySearchTree solver = new FlattenBinarySearchTree();

		TreeNode left2Node = new TreeNode(2);
		left2Node.left = new TreeNode(3);
		left2Node.right = new TreeNode(4);

		TreeNode right5Node = new TreeNode(5);
		right5Node.right = new TreeNode(6);

		TreeNode root = new TreeNode(1);
		root.left = left2Node;
		root.right = right5Node;

		solver.flatten(root);
	}
}
