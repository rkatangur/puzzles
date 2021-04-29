package org.examples.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * 
 * Implement the BSTIterator class that represents an iterator over the in-order
 * traversal of a binary search tree (BST):
 * 
 * 
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor. The pointer should
 * be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to
 * the right of the pointer, otherwise returns false.
 * 
 * int next() Moves the pointer to the right, then returns the number at the
 * pointer. Notice that by initializing the pointer to a non-existent smallest
 * number, the first call to next() will return the smallest element in the BST.
 * 
 * You may assume that next() calls will always be valid. That is, there will be
 * at least a next number in the in-order traversal when next() is called.
 * 
 * @author rkata
 *
 */
public class BSTIterator {

	TreeNode rootNode = null;
	Stack<TreeNode> nodeToProcess = new Stack<TreeNode>();
	List<Integer> inOrderNodeVals = new ArrayList<Integer>();

	public BSTIterator(TreeNode root) {
		rootNode = root;

//		buildInOrderNodeVals(root, inOrderNodeVals);
		addElementsToStack(root);
	}

//	public int next() {
//		if (!inOrderNodeVals.isEmpty()) {
//			return inOrderNodeVals.remove(0);
//		} else {
//			return -1;
//		}
//	}
//
//	private void buildInOrderNodeVals(TreeNode node, List<Integer> inOrderNodeVals) {
//		if (node == null) {
//			return;
//		}
//		buildInOrderNodeVals(node.left, inOrderNodeVals);
//		inOrderNodeVals.add(node.val);
//		buildInOrderNodeVals(node.right, inOrderNodeVals);
//	}
//	
//	public boolean hasNext() {
//		if (inOrderNodeVals.isEmpty()) {
//			return false;
//		}
//		return true;
//	}

	private void addElementsToStack(TreeNode node) {
		while (node != null) {
			nodeToProcess.push(node);
			node = node.left;
		}
	}

	public int next() {
		if (nodeToProcess.isEmpty()) {
			return -1;
		} else {
			TreeNode node = nodeToProcess.pop();
			addElementsToStack(node.right);
			return node.val;
		}
	}

	public boolean hasNext() {
		if (nodeToProcess.isEmpty()) {
			return false;
		}
		return true;
	}

}
