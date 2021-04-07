package org.examples.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> results = new ArrayList<Double>();
		if (root == null) {
			return results;
		}

		LinkedList<TreeNode> bfsQ = new LinkedList<TreeNode>();
		bfsQ.add(root);
		while (!bfsQ.isEmpty()) {
			int curSize = bfsQ.size();
			long totalLevelVal = 0;
			for (int i = 0; i < curSize; i++) {
				TreeNode node = bfsQ.poll();
				totalLevelVal += node.val;

				if (node.left != null) {
					bfsQ.add(node.left);
				}

				if (node.right != null) {
					bfsQ.add(node.right);
				}
			}
			double avgVal = Math.floor((double) (totalLevelVal / curSize));
			results.add(avgVal);
		}

		return results;
	}

}
