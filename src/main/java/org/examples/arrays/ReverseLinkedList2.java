package org.examples.arrays;

/**
 * 92. Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in one-pass. Note: 1 <= m
 * <= n <=length of list
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 * 
 * @author rkata
 *
 */
public class ReverseLinkedList2 {

	public static void main(String[] args) {
		ReverseLinkedList2 solver = new ReverseLinkedList2();

//		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//		solver.reverseBetween(head, 2, 4);
		
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
		solver.reverseBetween(head, 1, 2);
	}

	 public ListNode reverseBetween(ListNode head, int m, int n) {

			int pos = 0;
			ListNode curNode = head;
			ListNode prevNode = null;
			ListNode nodeAtM = null;
			ListNode nodeAtN = null;
			ListNode prevNodeOfM = null;
			while (curNode != null && pos<n) {
				pos++;
				ListNode tmp = curNode.next;
				if (pos >= m && pos <= n) {
					curNode.next = prevNode;
					if (pos == m) {
						nodeAtM = curNode;
	                    if(prevNode != null){
	                        prevNode.next = null;   
	                    }
						prevNodeOfM = prevNode;
					}
	                if (pos == n) {
						nodeAtN = curNode;
	                    if(prevNodeOfM != null) {
						    prevNodeOfM.next = nodeAtN;
	                    }
						nodeAtM.next = tmp;
					}
				}
				prevNode = curNode;
				curNode = tmp;
			}

			if (m <=n && m ==1 && n == pos) {
				head = nodeAtN;
			}
			return head;
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
