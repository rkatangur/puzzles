package org.examples.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Input:
 * 
 * 1 / \ 2 3 \ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * 
 * @param root
 * @return
 */
public class AllPathsOfBinaryTree {

	public static void main(String[] args) {
		TreeNode left4Node = new TreeNode(4);
		TreeNode left5Node = new TreeNode(5, new TreeNode(7), null);

		TreeNode right6Node = new TreeNode(6, new TreeNode(8), null);

		TreeNode left2Node = new TreeNode(2, left4Node, left5Node);
		TreeNode right3Node = new TreeNode(3, null, right6Node);

		TreeNode rootNode = new TreeNode(1, left2Node, right3Node);

		AllPathsOfBinaryTree solver = new AllPathsOfBinaryTree();
		List<String> allPaths = solver.binaryTreePaths(rootNode);

		System.out.println("All paths " + allPaths.size() + ".");

		allPaths.forEach(System.out::println);
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> allPaths = new ArrayList<String>();
		List<String> currentPath = new ArrayList<String>();

		binaryTreePaths(root, currentPath, allPaths);
		return allPaths;
	}

	public void binaryTreePaths(TreeNode root, List<String> currentPath, List<String> allPaths) {

		if (root == null) {
			return;
		}

		currentPath.add(String.valueOf(root.val));

		if (root.left == null && root.right == null) {
			allPaths.add(buildPath(currentPath));
		}

		binaryTreePaths(root.left, currentPath, allPaths);
		binaryTreePaths(root.right, currentPath, allPaths);

		currentPath.remove(currentPath.size() - 1);
	}

	public String buildPath(List<String> currentPath) {
		StringBuilder sb = new StringBuilder();

		int size = currentPath.size();
		sb.append(currentPath.get(0));
		for (int i = 1; i < size; i++) {
			sb.append("->").append(currentPath.get(i));
		}

		return sb.toString();
	}
}
