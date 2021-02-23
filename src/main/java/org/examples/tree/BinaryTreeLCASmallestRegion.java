package org.examples.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class BinaryTreeLCASmallestRegion {
//	
//	regions = [["Earth","North America","South America"],
//	           ["North America","United States","Canada"],
//	           ["United States","New York","Boston"],
//	           ["Canada","Ontario","Quebec"],
//	           ["South America","Brazil"]],
//	           region1 = "Quebec",
//	           region2 = "New York"

//	[["tQvrH","QG","ZcyyW","TTHy"],["QG","uzBJT","iM","fHC","iJ","Uc"],["ZcyyW","rw"],["TTHy","RHY","dL","we","s"],["RHY","WsJi","lQmkd","WIaw"],["dL","dKC","XSoQ"],["dKC","vwg"],["rw","wTRE","GHhXN","bq"],["wTRE","rEr","LO","mn","x","QJ"],["uzBJT","DKhq"],["XSoQ","qGUn"],["WsJi","wJIR","JSZ","V"],["GHhXN","B"],["iM","umVT","m"],["fHC","fHYsT","n"],["umVT","W"],["B","tScvQ"],["DKhq","CjbVa"],["JSZ","sjZWd"],["sjZWd","Yo","y"],["rEr","dnzXI"],["LO","M"],["lQmkd","SPvwQ"],["Yo","ArrX"],["M","b"],["W","S"]]
//			"V"
//			"WIaw"

	public static void main(String[] args) {
		List<List<String>> regionsList = new ArrayList<List<String>>();
		regionsList.add(Arrays.asList("Earth", "North America", "South America"));
		regionsList.add(Arrays.asList("North America", "United States", "Canada"));
		regionsList.add(Arrays.asList("United States", "New York", "Boston"));
		regionsList.add(Arrays.asList("Canada", "Ontario", "Quebec"));
		regionsList.add(Arrays.asList("South America", "Brazil"));

//		regionsList.add(Arrays.asList("tQvrH","QG","ZcyyW","TTHy"));
//		regionsList.add(Arrays.asList("QG","uzBJT","iM","fHC","iJ","Uc"));
//		regionsList.add(Arrays.asList("ZcyyW","rw"));
//		regionsList.add(Arrays.asList("TTHy","RHY","dL","we","s"));
//		regionsList.add(Arrays.asList("RHY","WsJi","lQmkd","WIaw"));
//		regionsList.add(Arrays.asList("dL","dKC","XSoQ"));
//		regionsList.add(Arrays.asList("dKC","vwg"));
//		regionsList.add(Arrays.asList("rw","wTRE","GHhXN","bq"));
//		regionsList.add(Arrays.asList("wTRE","rEr","LO","mn","x","QJ"));
//		regionsList.add(Arrays.asList("uzBJT","DKhq"));
//		regionsList.add(Arrays.asList("XSoQ","qGUn"));
//		regionsList.add(Arrays.asList("WsJi","wJIR","JSZ","V"));
//		regionsList.add(Arrays.asList("GHhXN","B"));
//		regionsList.add(Arrays.asList("iM","umVT","m"));
//		regionsList.add(Arrays.asList("fHC","fHYsT","n"));
//		regionsList.add(Arrays.asList("umVT","W"));
//		,["B","tScvQ"],["DKhq","CjbVa"],["JSZ","sjZWd"],["sjZWd","Yo","y"],["rEr","dnzXI"],["LO","M"],["lQmkd","SPvwQ"],["Yo","ArrX"],["M","b"],["W","S"]

		BinaryTreeLCASmallestRegion solver = new BinaryTreeLCASmallestRegion();
//		System.out.println(solver.findSmallestRegion(regionsList, "Canada", "Brazil"));
		System.out.println(solver.findSmallestRegionV2(regionsList, "Quebec", "New York"));
	}

	public String findSmallestRegionV2(List<List<String>> regions, String region1, String region2) {

		TreeNode rootNode = buildTree(regions);

		List<TreeNode> region1Path = new ArrayList<TreeNode>();
		findPath(rootNode, region1, region1Path);

		List<TreeNode> region2Path = new ArrayList<TreeNode>();
		findPath(rootNode, region2, region2Path);

		int size = Math.min(region1Path.size(), region2Path.size());
		String smallestRegion = null;
		for (int i =0; i<size; i++) {
			if (region1Path.get(i).val.equals(region2Path.get(i).val)) {
				smallestRegion = region1Path.get(i).val;
				break;
			}
		}
		return smallestRegion;
	}

	private boolean findPath(TreeNode root, String nodeVal, List<TreeNode> nodePath) {
		if (root == null) {
			return false;
		}

		if (root.val.equals(nodeVal)) {
			nodePath.add(root);
			return true;
		}

		if (findPath(root.left, nodeVal, nodePath)) {
			nodePath.add(root);
			return true;
		} else if (findPath(root.right, nodeVal, nodePath)) {
			nodePath.add(root);
			return true;
		}

		return false;
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
}
