package org.examples.arrays;

import org.examples.arrays.ReorderList.ListNode;

/**
 * 
 * 61. Rotate List
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], k = 2 Output: [4,5,1,2,3]
 * 
 * 
 * @author rkata
 *
 */
public class RotateLinkedList {

	public ListNode rotateRight(ListNode head, int k) {

		if (head == null) {
			return head;
		}
		ListNode curHead = head;
		ListNode prevNode = head;

		int lListSize = 1;
		while (k > 0) {
			ListNode nodeToProcess = curHead;
			while (nodeToProcess.next != null) {
				prevNode = nodeToProcess;
				nodeToProcess = nodeToProcess.next;
				lListSize++;
			}

			nodeToProcess.next = curHead;
			curHead = nodeToProcess;
			prevNode.next = null;
			if (k > lListSize) {
				k = k % lListSize;
				if(k == 0) {
					return head;
				}
			}
			
			k--;
		}

		return curHead;
	}

}
