package org.examples.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 652. Find Duplicate Subtrees
 * 
 * Given the root of a binary tree, return all duplicate subtrees.
 * 
 * For each kind of duplicate subtrees, you only need to return the root node of
 * any one of them.
 * 
 * Two trees are duplicate if they have the same structure with the same node
 * values.
 * 
 * 
 * 
	We can serialize each subtree. For example, the tree
	
	   1
	  / \
	 2   3
	    / \
	   4   5
	can be represented as the serialization 1,2,#,#,3,4,#,#,5,#,#, which is a unique representation of the tree.
 * 
 * @author rkata
 *
 */
public class FindDuplicateSubtrees {

	private List<TreeNode> dups = new ArrayList<TreeNode>();
	private Map<String, Integer> subtreeCount = new HashMap<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		buildTreeString(root);
		return dups;
	}

	public String buildTreeString(TreeNode root) {
		if (root == null) {
			return "#";
		}

		String treeStr = root.val + "," + buildTreeString(root.left) + "," + buildTreeString(root.right);
		subtreeCount.put(treeStr, subtreeCount.getOrDefault(treeStr, 0) + 1);
		if (subtreeCount.get(treeStr) >= 2) {
			dups.add(root);
		}
		return treeStr;
	}
}
