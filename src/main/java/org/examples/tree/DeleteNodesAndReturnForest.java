package org.examples.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 1110. Delete Nodes And Return Forest
 * 
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * 
 * After deleting all nodes with a value in to_delete, we are left with a forest
 * (a disjoint union of trees).
 * 
 * Return the roots of the trees in the remaining forest. You may return the
 * result in any order.
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5] Output:
 * [[1,2,null,4],[6],[7]] Example 2:
 * 
 * Input: root = [1,2,4,null,3], to_delete = [3] Output: [[1,2,4]]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the given tree is at most 1000. Each node has a
 * distinct value between 1 and 1000. to_delete.length <= 1000 to_delete
 * contains distinct values between 1 and 1000.
 * 
 * 
 * @author rkata
 *
 */
public class DeleteNodesAndReturnForest {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		List<TreeNode> results = new ArrayList<TreeNode>();
		Set<Integer> nodesToDel = new HashSet<Integer>();

		Arrays.stream(to_delete).forEach(s -> {
			nodesToDel.add(s);
		});

		if (!nodesToDel.contains(root.val)) {
			results.add(root);
		}

		delNodesHelper(root, nodesToDel, results);

		return results;
	}

	public TreeNode delNodesHelper(TreeNode root, Set<Integer> nodesToDel, List<TreeNode> results) {
		if (root == null) {
			return null;
		}

		root.left = delNodesHelper(root.left, nodesToDel, results);
		root.right = delNodesHelper(root.right, nodesToDel, results);

		if (nodesToDel.contains(root.val)) {
			if (root.left != null)
				results.add(root.left);

			if (root.right != null)
				results.add(root.right);
			return null;
		}

		return root;
	}

}
