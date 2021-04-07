package org.examples.tree;

public class MinDistBetweenBSTNodes {

	public static void main(String[] args) {
		MinDistBetweenBSTNodes solver = new MinDistBetweenBSTNodes();

		// [1,null,3,2]
		TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
		solver.minDiffInBST(root);
	}

	int minDif = Integer.MAX_VALUE;
	int prev = -1;

	public int minDiffInBST(TreeNode root) {
		minDiffHelperInBST(root);
		return minDif;
	}

	public void minDiffHelperInBST(TreeNode root) {
		if (root == null) {
			return;
		}

		minDiffHelperInBST(root.left);
		if (prev != -1) {
			minDif = Math.min(minDif, Math.abs(root.val - minDif));
		}
		prev = root.val;
		minDiffHelperInBST(root.right);
	}

}
