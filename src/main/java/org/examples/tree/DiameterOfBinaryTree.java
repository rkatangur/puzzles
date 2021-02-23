package org.examples.tree;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode left4Node = new TreeNode(4);
		TreeNode left5Node = new TreeNode(5, new TreeNode(7), null);

		TreeNode right6Node = new TreeNode(6, new TreeNode(8), null);

		TreeNode left2Node = new TreeNode(2, left4Node, left5Node);
		TreeNode right3Node = new TreeNode(3, null, right6Node);

		TreeNode rootNode = new TreeNode(1, left2Node, right3Node);

		DiameterOfBinaryTree solver = new DiameterOfBinaryTree();
		int[] diameterData =  solver.diameterOfBinaryTreeV1(rootNode);

		System.out.println("Height " + diameterData[0]+ " .");
		System.out.println("Diameter " + diameterData[1]+ " .");

	}

	public int[] diameterOfBinaryTreeV1(TreeNode node) {

		if (node == null) {
			return new int[] { 0, 0 };
		}

		int[] leftNodeData = diameterOfBinaryTreeV1(node.left);
		int[] rightNodeData = diameterOfBinaryTreeV1(node.right);

		int heightOfNode = Math.max(1 + leftNodeData[0], 1 + rightNodeData[0]);

		int diameter = Math.max(leftNodeData[0] + 1 + rightNodeData[0], Math.max(leftNodeData[1], rightNodeData[1]));

		return new int[] { heightOfNode, diameter };
	}

	

    public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);

		int leftDia = diameterOfBinaryTree(root.left);
		int rightDia = diameterOfBinaryTree(root.right);

		int diameter = Math.max(leftHeight + rightHeight, Math.max(leftDia, rightDia));
		return diameter;
	}

	public int findHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int tempHeight = 1 + findHeight(node.left);
		int tempHeight2 = 1 + findHeight(node.right);

		return Math.max(tempHeight, tempHeight2);
	}

}
