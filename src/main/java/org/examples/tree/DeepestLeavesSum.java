package org.examples.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * 1302. Deepest Leaves Sum
 * 
 * Given the root of a binary tree, return the sum of values of its deepest
 * leaves.
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8] Output: 15
 * 
 * 
 * Example 2:
 * 
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5] Output: 19
 * 
 * 
 * 
 * @author rkata
 *
 */
public class DeepestLeavesSum {

	public int deepestLeavesSum(TreeNode root) {
		int[] val = deepestLeavesSumHelper(root, 0);
		return val[0];
	}

	public int[] deepestLeavesSumHelper(TreeNode root, int depth) {
		if (root == null) {
			return null;
		}

		if (root.left == null && root.right == null) {
			return new int[] { root.val, depth };
		}

		int[] nodesOnLeft = deepestLeavesSumHelper(root.left, depth + 1);
		int[] nodesOnRight = deepestLeavesSumHelper(root.right, depth + 1);

		if (nodesOnLeft != null && nodesOnRight != null) {
			if (nodesOnLeft[1] == nodesOnRight[1]) {
				// sum the val
				return new int[] { nodesOnLeft[0] + nodesOnRight[0], nodesOnLeft[1] };
			} else if (nodesOnLeft[1] > nodesOnRight[1]) {
				// return left
				return nodesOnLeft;
			} else {
				// return right
				return nodesOnRight;
			}
		} else {
			if (nodesOnLeft != null) {
				// return left
				return nodesOnLeft;
			} else {
				// return right
				return nodesOnRight;
			}
		}
	}

	public int deepestLeavesSumIterativeDFS(TreeNode root) {

		if (root == null) {
			return 0;
		}
		
		int deepestSum = 0, depth = 0;
		Stack<Object[]> dfsStack = new Stack<Object[]>();
		dfsStack.push(new Object[] { root, 0 });

		while (!dfsStack.isEmpty()) {
			Object[] objArr = dfsStack.pop();
			TreeNode nodeObj = (TreeNode) objArr[0];
			Integer currDepth = (Integer) objArr[1];

			if (nodeObj.left == null && nodeObj.right == null) {
				// if this leaf is the deepest one seen so far
				if (currDepth > depth) {
					depth = currDepth; // note new depth
					deepestSum = nodeObj.val; // start new sum
				} else if (currDepth == depth) {
					// if there were already leaves at this depth
					deepestSum += nodeObj.val; // update existing sum
				}
			} else {
				if (nodeObj.right != null) {
					dfsStack.push(new Object[] { nodeObj.right, currDepth + 1 });
				}

				if (nodeObj.left != null) {
					dfsStack.push(new Object[] { nodeObj.left, currDepth + 1 });
				}
			}
		}
		
		return deepestSum;
	}

	public int deepestLeavesSumIterativeBFS(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int deepestSum = 0, depth = 0;
		LinkedList<Object[]> bfsStack = new LinkedList<Object[]>();
		bfsStack.push(new Object[] { root, 0 });

		while (!bfsStack.isEmpty()) {
			Object[] objArr = bfsStack.pop();
			TreeNode nodeObj = (TreeNode) objArr[0];
			Integer currDepth = (Integer) objArr[1];

			if (nodeObj.left == null && nodeObj.right == null) {
				// if this leaf is the deepest one seen so far
				if (currDepth > depth) {
					depth = currDepth; // note new depth
					deepestSum = nodeObj.val; // start new sum
				} else if (currDepth == depth) {
					// if there were already leaves at this depth
					deepestSum += nodeObj.val; // update existing sum
				}
			} else {
				if (nodeObj.right != null) {
					bfsStack.push(new Object[] { nodeObj.right, currDepth + 1 });
				}

				if (nodeObj.left != null) {
					bfsStack.push(new Object[] { nodeObj.left, currDepth + 1 });
				}
			}
		}
		
		return deepestSum;
	}

}
