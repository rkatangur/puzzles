package org.examples.tree;

/**
 * 285. Inorder Successor in BST
 * 
 * Given the root of a binary search tree and a node p in it, return the
 * in-order successor of that node in the BST. If the given node has no in-order
 * successor in the tree, return null.
 * 
 * The successor of a node p is the node with the smallest key greater than
 * p.val.
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3], p = 1 Output: 2 Explanation: 1's in-order successor
 * node is 2. Note that both p and the return value is of TreeNode type.
 * 
 * Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], p = 6 Output: null Explanation: There
 * is no in-order successor of the current node, so the answer is null.
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. -105 <= Node.val <=
 * 105 All Nodes will have unique values.
 * 
 * @author rkata
 *
 */
public class InorderSuccessorInBST {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		inorderSuccessorHelper(root, p);
		return sucessorNode;
	}

	TreeNode prevNode = null;
	TreeNode sucessorNode = null;

	public void inorderSuccessorHelper(TreeNode root, TreeNode p) {
		if (root == null) {
			return;
		}

		// Recurse on the left side
		inorderSuccessorHelper(root.left, p);

		// if (prevNode != null && prevNode == p && this.inorderSuccessorNode == null) {
		// Check if previous is the inorder predecessor of node
		if (prevNode == p && this.sucessorNode == null) {
			sucessorNode = root;
			// Keeping previous up-to-date for further recursions
			prevNode = root;
			return;
		} else {
			// Keeping previous up-to-date for further recursions
			prevNode = root;
		}
		
        // Recurse on the right side
		inorderSuccessorHelper(root.right, p);

		return;
	}

}
