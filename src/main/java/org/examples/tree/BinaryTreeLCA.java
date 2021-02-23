package org.examples.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*			
 			1	
	2				3
4		5		6		7

*LCA(4, 5) = 2
*LCA(4, 6) = 1
*LCA(3, 4) = 1
*LCA(2, 4) = 2
*/

/**
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree. According to the definition of LCA on Wikipedia: “The lowest
 * common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a
 * descendant of itself).”
 * 
 * 
 * @author rkata
 *
 */
public class BinaryTreeLCA {
//	
//	regions = [["Earth","North America","South America"],
//	           ["North America","United States","Canada"],
//	           ["United States","New York","Boston"],
//	           ["Canada","Ontario","Quebec"],
//	           ["South America","Brazil"]],
//	           region1 = "Quebec",
//	           region2 = "New York"
	
	[["tQvrH","QG","ZcyyW","TTHy"],["QG","uzBJT","iM","fHC","iJ","Uc"],["ZcyyW","rw"],["TTHy","RHY","dL","we","s"],["RHY","WsJi","lQmkd","WIaw"],["dL","dKC","XSoQ"],["dKC","vwg"],["rw","wTRE","GHhXN","bq"],["wTRE","rEr","LO","mn","x","QJ"],["uzBJT","DKhq"],["XSoQ","qGUn"],["WsJi","wJIR","JSZ","V"],["GHhXN","B"],["iM","umVT","m"],["fHC","fHYsT","n"],["umVT","W"],["B","tScvQ"],["DKhq","CjbVa"],["JSZ","sjZWd"],["sjZWd","Yo","y"],["rEr","dnzXI"],["LO","M"],["lQmkd","SPvwQ"],["Yo","ArrX"],["M","b"],["W","S"]]
//			"V"
//			"WIaw"


	public static void main(String[] args) {
		List<List<String>> regionsList = new ArrayList<List<String>>();
//		regionsList.add(Arrays.asList("Earth", "North America", "South America"));
//		regionsList.add(Arrays.asList("North America", "United States", "Canada"));
//		regionsList.add(Arrays.asList("United States", "New York", "Boston"));
//		regionsList.add(Arrays.asList("Canada", "Ontario", "Quebec"));
//		regionsList.add(Arrays.asList("South America", "Brazil"));
		
		regionsList.add(Arrays.asList("tQvrH","QG","ZcyyW","TTHy"));
		regionsList.add(Arrays.asList("QG","uzBJT","iM","fHC","iJ","Uc"));
		pop("ZcyyW","rw");
		,["TTHy","RHY","dL","we","s"],["RHY","WsJi","lQmkd","WIaw"],["dL","dKC","XSoQ"],["dKC","vwg"],["rw","wTRE","GHhXN","bq"],["wTRE","rEr","LO","mn","x","QJ"],["uzBJT","DKhq"],["XSoQ","qGUn"],["WsJi","wJIR","JSZ","V"],["GHhXN","B"],["iM","umVT","m"],["fHC","fHYsT","n"],["umVT","W"],["B","tScvQ"],["DKhq","CjbVa"],["JSZ","sjZWd"],["sjZWd","Yo","y"],["rEr","dnzXI"],["LO","M"],["lQmkd","SPvwQ"],["Yo","ArrX"],["M","b"],["W","S"]

		BinaryTreeLCA solver = new BinaryTreeLCA();
		System.out.println(solver.findSmallestRegion(regionsList, "Canada", "Brazil"));
	}

	public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
		TreeNode rootNode = buildTree(regions);
		TreeNode lcaNode = findLCA(rootNode, region1, region2);
		return lcaNode.val;
	}

	public TreeNode findLCA(TreeNode rootNode, String region1, String region2) {

		if (rootNode == null) {
			return null;
		}

		if (rootNode.val.equals(region1) || rootNode.val.equals(region2)) {
			return rootNode;
		}

		TreeNode leftNode = findLCA(rootNode.left, region1, region2);
		TreeNode rightNode = findLCA(rootNode.right, region1, region2);

		if (leftNode != null && rightNode != null) {
			return rootNode;
		}
		
		if (leftNode != null) {
			return leftNode;
		} else {
			return rightNode;
		}
	}

	public TreeNode buildTree(List<List<String>> regions) {
		Map<String, TreeNode> nodesMap = new HashMap<>();
		TreeNode rootNode = null;
		for (List<String> region : regions) {
			String regionName = region.get(0);
			TreeNode regionNode = nodesMap.get(regionName);
			if (regionNode == null) {
				regionNode = new TreeNode(regionName);
				nodesMap.put(regionName, regionNode);
			}

			if (rootNode == null) {
				rootNode = regionNode;
			}

			TreeNode regionNeighbor1Node = buildRegionNode(nodesMap, region, 1);
			regionNode.left = regionNeighbor1Node;

			TreeNode regionNeighbor2Node = buildRegionNode(nodesMap, region, 2);
			regionNode.right = regionNeighbor2Node;
		}

		return rootNode;
	}

	private TreeNode buildRegionNode(Map<String, TreeNode> nodesMap, List<String> regions, int index) {
		TreeNode regionNode = null;
		if (regions.size() > index) {
			String regionName = regions.get(index);
			regionNode = nodesMap.get(regionName);

			if (regionNode == null) {
				regionNode = new TreeNode(regionName);
				nodesMap.put(regionName, regionNode);
			}
		}
		return regionNode;
	}

	private static class TreeNode {
		public String val;
		public TreeNode left;
		public TreeNode right;

		TreeNode() {
		}

		TreeNode(String val) {
			this.val = val;
		}

		TreeNode(String val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * 
	 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3
	 * Explanation: The LCA of nodes 5 and 1 is 3.
	 * 
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root.val == p.val || root.val == q.val) {
			return root;
		}

		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

		if (leftNode != null && rightNode != null) {
			return root;
		}

		return leftNode != null ? leftNode : rightNode;
	}

//	public static void main(String[] args) {
//		BinaryTreeLCA solver = new BinaryTreeLCA();
//
//		TreeNode left2Node = new TreeNode(2, new TreeNode(7), new TreeNode(4));
//		TreeNode rleft5Node = new TreeNode(5, new TreeNode(6), left2Node);
//
//		TreeNode rootRight1Node = new TreeNode(1, new TreeNode(0), new TreeNode(8));
//
//		TreeNode root = new TreeNode(3, rleft5Node, rootRight1Node);
//
//		TreeNode pNode = new TreeNode(2);
//		TreeNode qNode = new TreeNode(4);
//
//		TreeNode lcaNode = solver.lowestCommonAncestor(root, pNode, qNode);
//		System.out.println("lcaNode " + lcaNode.val);
//	}

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

	Integer findLCA(int n1, int n2) {

		List<Integer> n1Path = new ArrayList<Integer>();
		findPath(root, n1, n1Path);

		List<Integer> n2Path = new ArrayList<Integer>();
		findPath(root, n2, n2Path);

		return findLCAInternal(n1Path, n2Path);
	}

	private Integer findLCAInternal(List<Integer> n1Path, List<Integer> n2Path) {
		Integer LCAFound = null;
		int n1 = 0;
		for (; n1 < n1Path.size() && n1 < n2Path.size(); n1++) {
			if (n1Path.get(n1) != n2Path.get(n1)) {
				break;
			}
		}

		LCAFound = n1Path.get(n1 - 1);

		return LCAFound;
	}

	private boolean findPath(Node node, int value, List<Integer> nodesPath) {

		if (node == null) {
			return false;
		}

		nodesPath.add(node.value);

		if (node.value == value) {
			return true;
		}

		if (node.left != null && findPath(node.left, value, nodesPath)) {
			return true;
		}

		if (node.right != null && findPath(node.right, value, nodesPath)) {
			return true;
		}

		nodesPath.remove(nodesPath.size() - 1);
		return false;
	}

	public void insert(Node node) {
		if (root == null) {
			root = node;
		} else {
			LinkedList<Node> nodesToCheck = new LinkedList<Node>();
			nodesToCheck.add(root);
			Node currNode = null;
			while ((currNode = nodesToCheck.poll()) != null) {
				if (currNode.left == null) {
					currNode.left = node;
					break;
				} else if (currNode.right == null) {
					currNode.right = node;
					break;
				}

				if (currNode.left != null) {
					nodesToCheck.add(currNode.left);
				}
				if (currNode.right != null) {
					nodesToCheck.add(currNode.right);
				}
			}
		}
	}

//	public static void main(String[] args) {
//
//		BinaryTreeLCA lca = new BinaryTreeLCA();
//		lca.insert(new Node(1));
//		lca.insert(new Node(2));
//		lca.insert(new Node(3));
//		lca.insert(new Node(4));
//		lca.insert(new Node(5));
//		lca.insert(new Node(6));
//		lca.insert(new Node(7));
////		lca.toString();
//
//		System.out.println("LCA(4, 5): " + lca.findLCA(4, 5));
//		System.out.println("LCA(4, 6): " + lca.findLCA(4, 6));
//		System.out.println("LCA(3, 4): " + lca.findLCA(3, 4));
//		System.out.println("LCA(2, 4): " + lca.findLCA(2, 4));
//
//	}
}
