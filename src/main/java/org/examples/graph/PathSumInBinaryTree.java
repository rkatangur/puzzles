package org.examples.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1 Return:
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 * 
 * 
 * @author rkata
 *
 */
public class PathSumInBinaryTree {

	public static void main(String[] args) {
		PathSumInBinaryTree solver = new PathSumInBinaryTree();

		TreeNode leftOf4 = solver.new TreeNode(11);
		leftOf4.left = solver.new TreeNode(7);
		leftOf4.right = solver.new TreeNode(2);

		TreeNode rootLeft = solver.new TreeNode(4);
		rootLeft.left = leftOf4;

		TreeNode root = solver.new TreeNode(5);

		TreeNode rootRight = solver.new TreeNode(8);
		rootRight.left = solver.new TreeNode(13);
		TreeNode rightOf8 = solver.new TreeNode(4);
		rootRight.right = rightOf8;
		rightOf8.left = solver.new TreeNode(5);
		rightOf8.right = solver.new TreeNode(1);

		solver.pathSum(root, 22);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
		pathSumHelper(root, 0, sum, path, allPaths);
		return allPaths;
	}

	public void pathSumHelper(TreeNode root, int workingSum, int sum, ArrayList<Integer> path,
			List<List<Integer>> allPaths) {
		if (root == null) {
			return;
		}

		path.add(root.val);
		workingSum = workingSum + root.val;

		pathSumHelper(root.left, workingSum, sum, path, allPaths);
		pathSumHelper(root.right, workingSum, sum, path, allPaths);

		if (root.left == null && root.right == null) {
			if (workingSum == sum)
				allPaths.add((List<Integer>) path.clone());
		}

		path.remove(path.size() - 1);
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum(root, 0, sum);
	}

	public boolean hasPathSum(TreeNode root, int workingSum, int sum) {
		if (root == null) {
			return false;
		}

		workingSum = workingSum + root.val;

		if (hasPathSum(root.left, workingSum, sum)) {
			return true;
		}

		if (hasPathSum(root.right, workingSum, sum)) {
			return true;
		}

		if (root.left == null && root.right == null) {
			if (workingSum == sum) {
				return true;
			}
		}
		
		return false;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
