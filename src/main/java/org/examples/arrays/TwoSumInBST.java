package org.examples.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given the root of a Binary Search Tree and a target number k, return true if
 * there exist two elements in the BST such that their sum is equal to the given
 * target. Input: root = [5,3,6,2,4,null,7], k = 9 Output: true
 * 
 * 
 * @author rkata
 *
 */
public class TwoSumInBST {

	public static void main(String[] args) {
		TwoSumInBST solver = new TwoSumInBST();
//		
//		5,3,6,2,4,null,7

		TreeNode node3 = new TreeNode(3, new TreeNode(2), new TreeNode(4));
		TreeNode node6 = new TreeNode(6, null, new TreeNode(7));

		TreeNode rootNode5 = new TreeNode(5, node3, node6);

		System.out.println(solver.findTarget(rootNode5, 9));
		
//		TreeNode node3 = new TreeNode(3, new TreeNode(2), new TreeNode(4));
//		TreeNode node6 = new TreeNode(6, null, new TreeNode(7));

//		TreeNode rootNode5 = new TreeNode(5, node3, node6);

	}

	public boolean findTarget(TreeNode root, int sum) {
		Set<Integer> treeNums = new HashSet<>();
		return findTargetHelper(root, sum, treeNums);
	}

	public boolean findTargetHelper(TreeNode root, int sum, Set<Integer> treeNums) {

		if (root == null) {
			return false;
		}

		if (findTargetHelper(root.left, sum, treeNums)) {
			return true;
		}

		if (findTargetHelper(root.right, sum, treeNums)) {
			return true;
		}

		int leftoverSum = sum - root.val;
		if (treeNums.contains(leftoverSum)) {
			return true;
		}
		treeNums.add(root.val);

		return false;
	}

	static public class TreeNode {
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
