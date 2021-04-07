package org.examples.tree;

import java.util.Stack;

/**
 * 
 * 536. Construct Binary Tree from String
 * 
 * 
 * You need to construct a binary tree from a string consisting of parenthesis
 * and integers.
 * 
 * The whole input represents a binary tree. It contains an integer followed by
 * zero, one or two pairs of parenthesis. The integer represents the root's
 * value and a pair of parenthesis contains a child binary tree with the same
 * structure.
 * 
 * You always start to construct the left child node of the parent first if it
 * exists.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "4(2(3)(1))(6(5))"
 * 
 * Output: [4,2,6,3,1,5]
 * 
 * Example 2:
 * 
 * Input: s = "4(2(3)(1))(6(5)(7))"
 * 
 * Output: [4,2,6,3,1,5,7]
 * 
 * 
 * Example 3:
 * 
 * Input: s = "-4(2(3)(1))(6(5)(7))"
 * 
 * Output: [-4,2,6,3,1,5,7]
 * 
 * 
 * @author rkata
 *
 */
public class ConstructBinaryTreeFromString {

	public TreeNode str2tree(String s) {
		Stack<TreeNode> stackOfNodes = new Stack<TreeNode>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			Character sChar = s.charAt(i);
			if (sChar == '(') {
				if (sb.length() > 0) {
					TreeNode newNode = new TreeNode(Integer.parseInt(sb.toString()));
					stackOfNodes.push(newNode);
				}
				sb = new StringBuilder();
			} else if (sChar == ')') {

				if (sb.length() > 0) {
					TreeNode newNode = new TreeNode(Integer.parseInt(sb.toString()));
					stackOfNodes.push(newNode);
				}

				TreeNode popedNode = stackOfNodes.pop();
				if (!stackOfNodes.isEmpty()) {
					if (!stackOfNodes.isEmpty()) {
						if (stackOfNodes.peek().left == null) {
							stackOfNodes.peek().left = popedNode;
						} else {
							stackOfNodes.peek().right = popedNode;
						}
					}
				}
				sb = new StringBuilder();
			} else {
				sb.append(sChar);
			}
		}

		if (stackOfNodes.isEmpty()) {
			if (sb.length() == 0)
				return null;
			else
				return new TreeNode(Integer.parseInt(sb.toString()));
		}
		return stackOfNodes.pop();
	}
}
