package org.examples.tree;
/**
 * 250. Count Univalue Subtrees
 * 
 * Given the root of a binary tree, return the number of uni-value subtrees.
 * 
 * A uni-value subtree means all nodes of the subtree have the same value.
 * 
 * 
 * Example 1:
 * 
 * Input: root = [5,1,5,5,5,null,5]
 * 
 * Output: 4
 * 
 * @author rkata
 *
 */
public class CountUniValSubtree {

	public static void main(String[] args) {

		TreeNode right1Node = new TreeNode(1, null, new TreeNode(5));
		TreeNode left1Node = new TreeNode(1, new TreeNode(5), new TreeNode(5));
		TreeNode root = new TreeNode(1, left1Node, right1Node);
		CountUniValSubtree solver = new CountUniValSubtree();
		solver.countUnivalSubtrees(root);
	}

	public int countUnivalSubtrees(TreeNode root) {
		if(root == null) {
			return 0;
		}
		isUniValSubtree(root);
		return numOfUniValSubtree;

	}

	int numOfUniValSubtree = 0;

	public boolean isUniValSubtree(TreeNode root) {
		
		if (root.left == null && root.right == null) {
			numOfUniValSubtree++;
			return true;
		}

		boolean isUnivalSubstree = true;
		if (root.left != null) {
			isUnivalSubstree = isUniValSubtree(root.left) && root.val == root.left.val;
		}

		if (root.right != null) { 
			isUnivalSubstree = isUniValSubtree(root.right) && root.val == root.right.val;
		}

		if (!isUnivalSubstree) {
			return isUnivalSubstree;
		} else {
			numOfUniValSubtree++;
			return true;

		}
	}

}
