package org.examples.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBST {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> allNodes = new ArrayList<>();
		LinkedList<TreeNode> nodesToProcess = new LinkedList<>();
		nodesToProcess.add(root);

		int level = 0;
		while (nodesToProcess.size() > 0) {

			int numOfNodesToProcess = nodesToProcess.size();
			if (allNodes.size() <= level) {
				allNodes.add(level, new ArrayList<Integer>());
			}

			for (int i = 0; i < numOfNodesToProcess; i++) {
				TreeNode node = nodesToProcess.poll();
				allNodes.get(level).add(node.val);

				if (node.left != null) {
					nodesToProcess.add(node.left);
				}

				if (node.right != null) {
					nodesToProcess.add(node.right);
				}
			}
			level++;
		}

		return allNodes;
	}

	public List<List<Integer>> recursiveLevelOrder(TreeNode root) {
		List<List<Integer>> levelOrders = new ArrayList<List<Integer>>();
		recursiveLevelOrder(root, levelOrders, 0);
		return levelOrders;
	}

	public void recursiveLevelOrder(TreeNode node, List<List<Integer>> levelOrders, int level) {
		if (node == null) {
			return;
		}

		List<Integer> nodesAtLevel = levelOrders.get(level);
		if (nodesAtLevel == null) {
			nodesAtLevel = new ArrayList<Integer>();
			levelOrders.add(level, nodesAtLevel);
		}

		nodesAtLevel.add(node.val);
		if (node.left != null) {
			recursiveLevelOrder(node.left, levelOrders, level + 1);
		}

		if (node.right != null) {
			recursiveLevelOrder(node.right, levelOrders, level + 1);
		}
	}

}
