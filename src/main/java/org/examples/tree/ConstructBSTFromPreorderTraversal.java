package org.examples.tree;

/**
 * 
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * 
 * Given an array of integers preorder, which represents the preorder traversal
 * of a BST (i.e., binary search tree), construct the tree and return its root.
 * 
 * It is guaranteed that there is always possible to find a binary search tree
 * with the given requirements for the given test cases.
 * 
 * A binary search tree is a binary tree where for every node, any descendant of
 * Node.left has a value strictly less than Node.val, and any descendant of
 * Node.right has a value strictly greater than Node.val.
 * 
 * A preorder traversal of a binary tree displays the value of the node first,
 * then traverses Node.left, then traverses Node.right.
 * 
 * Example:
 * 
 * Input: preorder = [8,5,1,7,10,12] Output: [8,5,10,1,7,null,12]
 * 
 * 
 * @author rkata
 *
 */
public class ConstructBSTFromPreorderTraversal {

	int pre_idx = 0;

	public TreeNode bstFromPreorder(int[] preorder) {

		return bstFromPreorderHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private TreeNode bstFromPreorderHelper(int[] preorder, int lowVal, int highVal) {
		// if all elements from preorder are used
		// then the tree is constructed
		if (pre_idx >= preorder.length) {
			return null;
		}

		int nodeVal = preorder[pre_idx];
		// if the current element
		// couldn't be placed here to meet BST requirements
		if (nodeVal < lowVal || nodeVal > highVal) {
			return null;
		}

		pre_idx++;
		TreeNode root = new TreeNode(nodeVal);
		root.left = bstFromPreorderHelper(preorder, lowVal, nodeVal);
		root.right = bstFromPreorderHelper(preorder, nodeVal, highVal);
		return root;
	}

}
