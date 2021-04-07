package org.examples.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 107. Binary Tree Level Order Traversal II
 * 
 * Given the root of a binary tree, return the bottom-up level order traversal
 * of its nodes' values. (i.e., from left to right, level by level from leaf to
 * root).
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [[15,7],[9,20],[3]]
 * 
 * 
 * Example 2:
 * 
 * Input: root = [1]
 * 
 * Output: [[1]]
 * 
 * 
 * Example 3:
 * 
 * Input: root = [] Output: []
 * 
 * @author rkata
 *
 */
public class BinaryTreeLevelOrderTraversal_2 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		LinkedList<TreeNode> bfsQ = new LinkedList<TreeNode>();
		bfsQ.add(root);

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		while (!bfsQ.isEmpty()) {
			int bfsQSize = bfsQ.size();
			List<Integer> elemsAtThisLevel = new ArrayList<Integer>();
			for (int i = 0; i < bfsQSize; i++) {
				TreeNode node = bfsQ.poll();
				elemsAtThisLevel.add(node.val);

				if (node.left != null)
					bfsQ.add(node.left);

				if (node.right != null)
					bfsQ.add(node.right);
			}
			results.add(0, elemsAtThisLevel);
		}

		return results;
	}

}
