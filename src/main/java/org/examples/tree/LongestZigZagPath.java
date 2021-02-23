package org.examples.tree;

import org.examples.arrays.ArraysUtil;

public class LongestZigZagPath {

	public static void main(String[] args) {
		LongestZigZagPath solver = new LongestZigZagPath();

		TreeNode rightRL4Node = new TreeNode(7, null, new TreeNode(8));
		TreeNode rightRL3Node = new TreeNode(5, null, rightRL4Node);

		TreeNode rightRL2Node = new TreeNode(4, rightRL3Node, new TreeNode(6));

		TreeNode rightRL1Node = new TreeNode(2, new TreeNode(3), rightRL2Node);
		TreeNode root = new TreeNode(1, null, rightRL1Node);

		System.out.println(solver.longestZigZag(root));

//		[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
//				Output: 3
	}

	public int longestZigZag(TreeNode root) {
		int[] rightZigPathSteps = longestZigZag(root, -1);
		ArraysUtil.printIntArr(rightZigPathSteps);
		return Math.max(rightZigPathSteps[0], rightZigPathSteps[1]);
	}

	/**
	 * 
	 * 0th index will have current path length 1th index will have the path length
	 * from processing the left node of the root 2th index will have the path length
	 * from processing the right node of the root
	 * 
	 * @param node
	 * @param isLeft
	 * @return
	 */
	public int[] longestZigZag(TreeNode node, int prevDir) {
		if (node == null) {
			return new int[] { -1, -1 };
		}

		if (node.left == null && node.right == null) {
			return new int[] { 0, 0 };
		}

		int[] paths1 = longestZigZag(node.left, 0);
		int[] paths2 = longestZigZag(node.right, 1);

		int[] paths = new int[] { 0, 0 };
		if (prevDir == 1) {
			paths[0] = paths1[1] + 1;
			paths[1] = paths2[0] + 1;
		} else {
			paths[0] = paths2[0] + 1;
			paths[1] = paths1[1] + 1;
		}
		return paths;
	}

	int maxLen;

//	public int longestZigZag(TreeNode root) {
//		maxLen = 0;
//		longestZigZag(root, -1);
//		return maxLen;
//	}
//
//	// 0 -> left node
//	// 1 -> right node
//	// -1 -> null node
//	// {sum, dir}
//	public int[] longestZigZag(TreeNode root, int prevDir) {
//		if (root == null) {
//			return new int[] { 0, -1 };
//		}
//		if (root.left == null && root.right == null) {
//			return new int[] { 1, prevDir };
//		}
//
//		int[] lp = longestZigZag(root.left, 0);
//		int[] rp = longestZigZag(root.right, 1);
//		maxLen = Math.max(maxLen, Math.max(lp[0], rp[0]));
//		int[] res = { 0, 0 };
//		if (prevDir == 0 && rp[1] == 1) {
//			return new int[] { rp[0] + 1, prevDir };
//
//		} else if (prevDir == 1 && lp[1] == 0) {
//			return new int[] { lp[0] + 1, prevDir };
//
//		} else {
//			return new int[] { 1, prevDir };
//		}
//	}

}
