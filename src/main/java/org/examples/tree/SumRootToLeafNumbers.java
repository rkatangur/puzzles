package org.examples.tree;

import java.util.Stack;

/**
 * 
 * 129. Sum Root to Leaf Numbers
 * 
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 * 
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers.
 * 
 * A leaf node is a node with no children.
 * 
 * @author rkata
 *
 */

public class SumRootToLeafNumbers {

	int total =0;
	public int sumNumbers(TreeNode root) {
		sumNumbersRecursiveDFS(root, 0);
		return total;
	}

	public void sumNumbersRecursiveDFS(TreeNode root, int curNum) {
		if(root == null) {
			return;
		}
		
		curNum = curNum*10 + root.val;
		if(root.left == null && root.right == null) {
			total += curNum;
		}
		
		sumNumbersRecursiveDFS(root.left, curNum);
		sumNumbersRecursiveDFS(root.right, curNum);
	}
	
	public int sumNumbersIterativeDFS(TreeNode root) {

		Stack<Object[]> dfsStack = new Stack<Object[]>();
		dfsStack.add(new Object[] { root, 0 });
		int totalNum = 0;

		while (!dfsStack.isEmpty()) {
			Object[] nodePoped = dfsStack.pop();
			TreeNode nodeToProcess = (TreeNode) nodePoped[0];
			int prevNumVal = (Integer) nodePoped[1];
			int curNum = prevNumVal * 10 + nodeToProcess.val;

			if (nodeToProcess.left == null && nodeToProcess.right == null) {
				// build the number and add it to the total
				totalNum += curNum;
			} else {

				if (nodeToProcess.right != null) {
					dfsStack.add(new Object[] { nodeToProcess.right, curNum });
				}

				if (nodeToProcess.left != null) {
					dfsStack.add(new Object[] { nodeToProcess.left, curNum });
				}
			}
		}

		return totalNum;
	}
}
