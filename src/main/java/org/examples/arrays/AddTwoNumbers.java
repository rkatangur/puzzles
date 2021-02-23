package org.examples.arrays;

/**
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
 * 807.
 * 
 * 
 * @author rkata
 *
 */

public class AddTwoNumbers {

	/**
	 * Definition for singly-linked list.
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode l1Node = l1;
		ListNode l2Node = l2;

		ListNode result = null;
		ListNode curResult = null;
		int carry = 0;

		while (l1Node != null || l2Node != null) {
			int l1Val = 0;
			if (l1Node != null) {
				l1Val = l1Node.val;
				l1Node = l1Node.next;
			}

			int l2Val = 0;
			if (l2Node != null) {
				l2Val = l2Node.val;
				l2Node = l2Node.next;
			}

			int sum = l1Val + l2Val + carry;
			ListNode sumNodeVal = new ListNode(sum % 10);

			if (result == null) {
				result = sumNodeVal;
			}
			carry = sum / 10;

			if (curResult == null) {
				curResult = result;
			} else {
				curResult.next = sumNodeVal;
				curResult = sumNodeVal;
			}
		}
		
		if(carry >0) {
			ListNode carryNodeVal = new ListNode(carry);
			if (curResult != null) {
				curResult.next = carryNodeVal;
				curResult = carryNodeVal;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1_2 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2_5 = new ListNode(5, new ListNode(6, new ListNode(4)));

		AddTwoNumbers solver = new AddTwoNumbers();
		solver.addTwoNumbers(l1_2, l2_5);
	}
	
	public static void printNode(ListNode node) {
		while(node !=null) {
			System.out.print(node.val);
			node = node.next;
		}
		System.out.println();
	}

}
