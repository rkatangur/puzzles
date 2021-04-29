package org.examples.arrays;

import org.examples.arrays.AddTwoNumbers.ListNode;

/**
 * 
 * 369. Plus One Linked List Given a non-negative integer represented as a
 * linked list of digits, plus one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * Example 1: Input: head = [1,2,3] Output: [1,2,4]
 * 
 * Example 2: Input: head = [0] Output: [1]
 * 
 * @author rkata
 *
 */
public class PlusOneLinkedList {

//	public ListNode plusOne(ListNode head) {
//		
//		ListNode sentinelHead = new ListNode();
//		sentinelHead.next= head;
//		
//		ListNode notNineHead = head;
//		
//		while(sentinelHead.next != null) {
//			if(sentinelHead.ne)
//		}
//		
//		return null;
//	}

	public ListNode plusOne(ListNode head) {
		int carry = plusOneHelper(head);
		if (carry == 1) {
			ListNode newHead = new ListNode(carry);
			newHead.next = head;
			return newHead;
		} else {
			return head;
		}
	}

	public int plusOneHelper(ListNode head) {
		if (head == null)
			return 1;

		int carry = plusOneHelper(head.next);

		if (carry == 1) {
			if (head.val == 9) {
				head.val = 0;
				return 1;
			} else {
				head.val++;
				return 0;
			}
		} else {
			return 0;
		}
	}

}
