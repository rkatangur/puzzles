package org.examples.tree;

public class MaximumPathSumBST {

	public int maxPathSum(TreeNode root) {
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}

	public int calculateSum(TreeNode root, int[] max) {

		if (root == null) {
			return 0;
		}

		System.out.println("processing root.val " + root.val);

		int leftSum = calculateSum(root.left, max);
		System.out.println("leftSum " + leftSum);

		int rightSum = calculateSum(root.right, max);
		System.out.println("leftSum " + rightSum);

		int current = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
		max[0] = Math.max(max[0], Math.max(current, leftSum + root.val + rightSum));
		return current;
	}

}
