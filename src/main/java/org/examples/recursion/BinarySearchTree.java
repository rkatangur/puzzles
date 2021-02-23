package org.examples.recursion;

import org.examples.tree.TreeNode;

/**
 * 
 * Given the root node of a binary search tree (BST) and a value. You need to
 * find the node in the BST that the node's value equals the given value. Return
 * the subtree rooted with that node. If such node doesn't exist, you should
 * return NULL.
 * 
 * For example,
 * 
 * Given the tree: 4 / \ 2 7 / \ 1 3
 * 
 * And the value to search: 2 You should return this subtree:
 * 
 * 2 / \ 1 3 In the example above, if we want to search the value 5, since there
 * is no node with value 5, we should return NULL.
 * 
 * Note that an empty tree is represented by NULL, therefore you would see the
 * expected output (serialized tree format) as [], not null.
 * 
 * 
 * 
 * @param args
 */

public class BinarySearchTree {

	public static void main(String[] args) {

	}
	
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftNodeDepth = 1 + maxDepth(root.left);
		int rightNodeDepth = 1 + maxDepth(root.right);

		return Math.max(leftNodeDepth, rightNodeDepth);
	}

//	public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//    
//    
//    public boolean isValidBST(TreeNode node, long min, long max) {
//        boolean validBst = true;
//           
//        if(validBst && node.left != null)
//        {
//            long max1 = Math.min(node.val, max);
//             
//            if(node.left.val<node.val && node.left.val > min && node.left.val < max1) {
//                validBst = isValidBST(node.left, min, max1);
//                System.out.println("processing leftnode "+node.left.val+", min "+min+", max "+max1+" validBst "+validBst);                
//            } else {
//                validBst = false;
//                System.out.println("processing rightnode "+node.left.val+", min "+min+", max "+max1+", validBst "+validBst);
//            }
//        }
//    
//        if(validBst && node.right != null){
//            long min1 = Math.max(node.val, min);
//            if(node.right.val>node.val && node.right.val > min1 && node.right.val < max) {
//                validBst = isValidBST(node.right, min1, max);
//                System.out.println("processing rightnode "+node.right.val+", min "+min1+", max "+max+" validBst "+validBst);
//            } else {
//                validBst = false;
//                System.out.println("processing rightnode "+node.right.val+", min "+min1+", max "+max+", validBst "+validBst);
//            }
//        }
//        
//        return validBst;
//    }
//    

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			return true;
		}

		if (lower != null && node.val <= lower) {
			return false;
		}

		if (upper != null && node.val >= upper) {
			return false;
		}

		if (node.left != null) {
			Integer upper1 = null;
			if (upper != null) {
				upper1 = Math.min(node.val, upper);
			} else {
				upper1 = node.val;
			}

			if (!isValidBST(node.left, lower, upper1)) {
				return false;
			}
		}

		if (node.right != null) {
			Integer lower1 = null;
			if (lower != null) {
				lower1 = Math.max(node.val, lower);
			} else {
				lower1 = node.val;
			}

			if (!isValidBST(node.right, lower1, upper)) {
				return false;
			}
		}

		return true;
	}
}
