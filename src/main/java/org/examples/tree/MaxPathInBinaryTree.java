package org.examples.tree;

import java.util.LinkedList;

public class MaxPathInBinaryTree {

//  1
//4   6
//3   9   8
//5   2   6   4  

//Maximum sum path = RLR   

//int[][]
//{
//{1}
//{4,  6}
//{3, 9, 8}
	private int maxSum = Integer.MIN_VALUE;
	private String maxSumPath = null;

	public static void main(String[] args) {
//         1
// 4   6
// 3   9   8
// 5   2   6   4 

		MaxPathInBinaryTree solver = new MaxPathInBinaryTree();
		int[][] array = new int[][] { { 1 }, { 4, 6 }, { 3, 9, 8 }, { 5, 2, 6, 4 } };
		System.out.println(solver.maxPathSum(array));
	}

	public String maxPathSum(int[][] array) {
		TreeNode rootNode = buildBinaryTree(array);
		maxPathSumHelper(rootNode, 0, "");
		return maxSumPath;
	}

	public void maxPathSumHelper(TreeNode node, int curSum, String path) {

		if (node == null) {
			return;
		}

		curSum = curSum + node.val;

		if (node.left == null && node.right == null) {
			if (curSum > maxSum) {
				maxSum = curSum;
				maxSumPath = path;
			}
			return;
		}

		maxPathSumHelper(node.left, curSum, path + "L");
		maxPathSumHelper(node.right, curSum, path + "R");
	}

//     1 call 1, 0, ""
//     call 4, 1, L                                        call 6, 1, R
// call maxPathSumHelper(3, 5, LL           maxPathSumHelper 9, 5, LR 
// call maxPathSumHelper(5, 8, LLL 

	public TreeNode buildBinaryTree(int[][] data) {
		LinkedList<TreeNode> parentNodes = new LinkedList<>();
		TreeNode rootNode = new TreeNode(data[0][0]);
		parentNodes.add(rootNode);

		for (int i = 1; i < data.length; i++) {
			int[] dataElems = data[i];
			for (int j = 0; j < dataElems.length; j++) {
				TreeNode curNode = new TreeNode(data[i][j]);
				// add it to parent
				if (j == 0) {
					// add it as left to the one in parents
					parentNodes.peek().left = curNode;
				} else if (j == dataElems.length - 1) {
					// add it as right to the one in parents list
					parentNodes.peek().right = curNode;
					parentNodes.poll();
				} else {
					boolean addedRight = false;
					boolean addedLeft = false;
					while (!parentNodes.isEmpty()) {
						TreeNode nodeToUse = parentNodes.peek();
						if (nodeToUse.left != null && nodeToUse.right != null) {
							parentNodes.poll();
						} else {
							if (nodeToUse.right == null && !addedRight) {
								nodeToUse.right = curNode;
								addedRight = true;
							} else if (nodeToUse.left == null && !addedLeft) {
								nodeToUse.left = curNode;
								addedLeft = true;
							}
						}

						if (addedLeft && addedRight) {
							break;
						}
					}
				}
				parentNodes.add(curNode);
			}
		}

		return rootNode;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

}
