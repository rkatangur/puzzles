package org.examples.tree;

/**
 * 
 * 
 * 
 * 530. Minimum Absolute Difference in BST
 * 
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * 
 * Example:
 * 
 * Input:
 * 
 * 1 \ 3 / 2
 * 
 * 
 * Output: 1
 * 
 * Explanation: The minimum absolute difference is 1, which is the difference
 * between 2 and 1 (or between 2 and 3).
 * 
 * 
 * @author rkata
 *
 */

public class GetMinDifferenceInBST {

	int minDif = Integer.MAX_VALUE;
	TreeNode prev = null;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return 0;
		getMinDiffHelper(root);
		return minDif;
	}

	public void getMinDiffHelper(TreeNode root) {
		if (root == null) {
			return;
		}

		getMinDiffHelper(root.left);
		if (prev != null) {
			minDif = Math.min(minDif, Math.abs(prev.val - root.val));
		}
		prev = root;
		getMinDiffHelper(root.right);
	}

}
