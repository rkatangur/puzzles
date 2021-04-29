package org.examples.recursion;

import java.util.LinkedList;
import java.util.List;

import org.examples.tree.TreeNode;

/**
 * 
 * 120. Triangle
 * 
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] Output: 11 Explanation: The
 * triangle looks like: 2 3 4 6 5 7 4 1 8 3 The minimum path sum from top to
 * bottom is 2 + 3 + 5 + 1 = 11 (underlined above). Example 2:
 * 
 * Input: triangle = [[-10]] Output: -10
 * 
 * 
 * Constraints:
 * 
 * 1 <= triangle.length <= 200 triangle[0].length == 1 triangle[i].length ==
 * triangle[i - 1].length + 1 -104 <= triangle[i][j] <= 104
 * 
 * 
 * Follow up: Could you do this using only O(n) extra space, where n is the
 * total number of rows in the triangle?
 * 
 * @author rkata
 *
 */
public class MinPathSumInTriangle {

	int minSum = Integer.MAX_VALUE;

	public int minimumTotal(List<List<Integer>> triangle) {
		int[][] dp = new int[triangle.size()][triangle.size()];

		minimumTotalHelperV2(triangle, dp, 0, 0);

		return dp[0][0];
	}

	public int minimumTotalHelperV2(List<List<Integer>> triangle, int[][] dp, int row, int col) {
		if (row >= triangle.size()) {
			return 0;
		}

		if (dp[row][col] != 0) {
			return dp[row][col];
		}

		int curVal = triangle.get(row).get(col);
		int minPath = curVal + Math.min(minimumTotalHelperV2(triangle, dp, row + 1, col),
				minimumTotalHelperV2(triangle, dp, row + 1, col + 1));

		dp[row][col] = minPath;

		return dp[row][col];
	}

// 	public int minimumTotal(List<List<Integer>> triangle) {
// 		TreeNode root = buildBinaryTree(triangle);

//         return minimumTotalHelper(root);

// // 		minimumTotal(root, 0);
// // 		return minSum;
// 	}

// 	public void minimumTotal(TreeNode root, int curSum) {
// 		if (root == null) {
// 			return;
// 		}
// 		curSum = curSum + root.val;

// 		if (root.left == null && root.right == null) {
// 			if (curSum < minSum) {
// 				minSum = curSum;
// //				maxSumPath = path;
// 			}
// 			return;
// 		}

// 		minimumTotal(root.left, curSum);
// 		minimumTotal(root.right, curSum);
// 	}

	public int minimumTotalHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftSum = minimumTotalHelper(root.left);
		int rightSum = minimumTotalHelper(root.right);

		return root.val + Math.min(leftSum, rightSum);

//      curSum = curSum + root.val;

// 		if (root.left == null && root.right == null) {
// 			if (curSum < minSum) {
// 				minSum = curSum;
// //				maxSumPath = path;
// 			}
// 			return;
// 		}

	}

	public TreeNode buildBinaryTree(List<List<Integer>> triangle) {
		LinkedList<TreeNode> parentNodes = new LinkedList<>();
		TreeNode rootNode = new TreeNode(triangle.get(0).get(0));
		parentNodes.add(rootNode);

		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> dataElems = triangle.get(i);
			for (int j = 0; j < dataElems.size(); j++) {
				TreeNode curNode = new TreeNode(dataElems.get(j));
				// add it to parent
				if (j == 0) {
					// add it as left to the one in parents
					parentNodes.peek().left = curNode;
				} else if (j == dataElems.size() - 1) {
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

}
