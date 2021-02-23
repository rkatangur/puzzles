package org.examples.tree;

/**
 *
 * Invert a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 * 4 / \ 2 7 / \ / \ 1 3 6 9
 * 
 * Output:
 * 
 * 4 / \ 7 2 / \ / \ 9 6 3 1
 * 
 * 
 * @author rkata
 *
 */

public class InvertBinaryTree {

	public static void main(String[] args) {
		InvertBinaryTree solver = new InvertBinaryTree();
		
		TreeNode root = new TreeNode(4, new TreeNode(2,  new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));		
		solver.invertTree(root);
	}

	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		TreeNode invertedRootLeft = invertTree(root.left);
		TreeNode invertedRootRight =  invertTree(root.right);
		root.left = invertedRootRight;
		root.right = invertedRootLeft;
		return root;
	}
	

}
