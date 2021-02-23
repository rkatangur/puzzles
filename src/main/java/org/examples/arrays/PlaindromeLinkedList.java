package org.examples.arrays;

/**
 * 
 * Given a singly linked list, determine if it is a palindrome. Example 1:
 * 
 * Input: 1->2 Output: false Example 2:
 * 
 * Input: 1->2->2->1 Output: true Follow up: Could you do it in O(n) time and
 * O(1) space?
 * 
 * 
 * @author rkata
 *
 */
public class PlaindromeLinkedList {

	public static void main(String[] args) {
		PlaindromeLinkedList solver = new PlaindromeLinkedList();
//		1,2,3,2,1
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
		System.out.println(solver.isPalindrome(head));
	}

	public boolean isPalindrome(ListNode node) {
		isPalindromeHelper(node, node);
		return isPalindrome;
	}

	boolean isPalindrome = true;

	public ListNode isPalindromeHelper(ListNode node, ListNode head) {
		if (node == null) {
			return head;
		}

		ListNode headhNodeToUse = isPalindromeHelper(node.next, head);
		if (headhNodeToUse == node) {
			return null;
		}

		if (headhNodeToUse != null) {
			if (node.val != headhNodeToUse.val) {
				isPalindrome = false;
			} else {
				return headhNodeToUse.next;
			}
		}

		return null;
	}

	/**
	 * 
	 * Definition for singly-linked list.
	 * 
	 * @param val
	 * @param next
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
