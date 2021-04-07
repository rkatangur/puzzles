package org.examples.tree;

/**
 * 
 * 687. Longest Univalue Path
 * 
 * Given the root of a binary tree, return the length of the longest path, where
 * each node in the path has the same value. This path may or may not pass
 * through the root.
 * 
 * The length of the path between two nodes is represented by the number of
 * edges between them.
 * 
 * Example 1:
 * 
 * Input: root = [5,4,5,1,1,5]
 * 
 * Output: 2
 * 
 * 
 * @author rkata
 */
public class LongestUnivaluePath {

	public int longestUnivaluePath(TreeNode root) {
		return longestUnivaluePathHelper(root);
	}

	int ans = 0;

	public int longestUnivaluePathHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int longestPathFromLeftChild = longestUnivaluePathHelper(root.left);
		int longestPathFromRightChild = longestUnivaluePathHelper(root.right);

		int arrowLeft = 0;
		if (root.left != null && root.val == root.left.val) {
			arrowLeft = longestPathFromLeftChild + 1;
		}

		int arrowRight = 0;
		if (root.right != null && root.val == root.right.val) {
			arrowRight = longestPathFromRightChild + 1;
		}

		ans = Math.max(ans, arrowLeft + arrowRight);
		return Math.max(arrowLeft, arrowRight);
	}

}
