package org.examples.tree;

/*			
 			20
 				
	8				22

4		12

	10		14

*LCA(10, 14) = 12
*LCA(14, 8) = 8
*LCA(10, 22) = 20
*/

/**
 * 
 * @author rkata
 *
 *         LCA can be used to calculate the distance between two nodes n1 and
 *         n2. Distance from n1 to n2 can be computed = (distance from the root
 *         to n1 + distance from the root to n2) - 2 * (distance from the root
 *         to their lowest common ancestor).
 * 
 *
 */
public class BinarySearchTreeLCA {

	private Node root;

	public static class Node {
		public Node(int value) {
			super();
			this.value = value;
		}

		int value;
		Node left;
		Node right;
	}

	public void insert(Node node) {
		if (root == null) {
			root = node;
		} else {
			Node curNode = root;
			while (curNode != null) {
				if (node.value > curNode.value) {
					if (curNode.right == null) {
						curNode.right = node;
						break;
					} else {
						curNode = curNode.right;
					}
				} else {
					if (curNode.left == null) {
						curNode.left = node;
						break;
					} else {
						curNode = curNode.left;
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		BinarySearchTreeLCA binarySearchTree = new BinarySearchTreeLCA();
		binarySearchTree.insert(new Node(20));
		binarySearchTree.insert(new Node(8));
		binarySearchTree.insert(new Node(22));
		binarySearchTree.insert(new Node(4));
		binarySearchTree.insert(new Node(12));
		binarySearchTree.insert(new Node(10));
		binarySearchTree.insert(new Node(14));

		binarySearchTree.toString();

		System.out.println(binarySearchTree.findLCA(binarySearchTree.root, 10, 14));
		System.out.println(binarySearchTree.findLCA(binarySearchTree.root, 14, 8));
		System.out.println(binarySearchTree.findLCA(binarySearchTree.root, 10, 22));
	}

	private int findLCA(Node node, int n1, int n2) {
		if (node == null) {
			return -1;
		}

		if (n1 > node.value && n2 > node.value) {
			return findLCA(node.right, n1, n2);
		} else if (n1 < node.value && n2 < node.value) {
			return findLCA(node.left, n1, n2);
		} else {
			return node.value;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Value of current node or parent node.
		int parentVal = root.val;

		// Value of p
		int pVal = p.val;

		// Value of q;
		int qVal = q.val;

		if (pVal > parentVal && qVal > parentVal) {
			// If both p and q are greater than parent
			return lowestCommonAncestor(root.right, p, q);
		} else if (pVal < parentVal && qVal < parentVal) {
			// If both p and q are lesser than parent
			return lowestCommonAncestor(root.left, p, q);
		} else {
			// We have found the split point, i.e. the LCA node.
			return root;
		}
	}

	public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
		// Value of p
		int pVal = p.val;

		// Value of q;
		int qVal = q.val;
		TreeNode nodeToProcess = root;

		while (nodeToProcess != null) {
			if (pVal > nodeToProcess.val && qVal > nodeToProcess.val) {
				nodeToProcess = nodeToProcess.right;
			} else if (pVal < nodeToProcess.val && qVal < nodeToProcess.val) {
				nodeToProcess = nodeToProcess.left;
			} else {
				return nodeToProcess;
			}
		}
		return null;
	}

}
