package org.examples.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTRightSideView {

	public static void main(String[] args) {
		BSTRightSideView solver = new BSTRightSideView();

		TreeNode left2Node = new TreeNode(2);
//		left2Node.left = new TreeNode(3);
		left2Node.right = new TreeNode(5);

		TreeNode right3Node = new TreeNode(3);
		right3Node.right = new TreeNode(4);

		TreeNode root = new TreeNode(1);
		root.left = left2Node;
		root.right = right3Node;

		List<Integer> nodesReturned = solver.rightSideView(root);
		nodesReturned.stream().forEach(e -> System.out.println(e));
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> nodes = new ArrayList<Integer>();

		LinkedList<TreeNode> bfsQ = new LinkedList<TreeNode>();
		bfsQ.add(root);

		while (!bfsQ.isEmpty()) {
			int initialQSize = bfsQ.size();
			for (int i = 0; i < initialQSize; i++) {
				TreeNode nodeToProcess = bfsQ.poll();
				if (nodeToProcess != null) {

					if (i == initialQSize - 1)
						nodes.add(nodeToProcess.val);

					if (nodeToProcess.left != null) {
						bfsQ.add(nodeToProcess.left);
					}

					if (nodeToProcess.right != null) {
						bfsQ.add(nodeToProcess.right);
					}
				}
			}
		}

		return nodes;
	}

}
