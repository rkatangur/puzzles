package org.examples.arrays;

/**
 * 
 * Find a middle node of the linked list. If there are two middle nodes, return
 * the second middle node. Example: for the list 1->2->3->4->5->6, the middle
 * element is 4. Once a middle node has been found, reverse the second part of
 * the list.
 * 
 * Example: convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4. Now merge the
 * two sorted lists. Example: merge 1->2->3->4 and 6->5->4 into
 * 1->6->2->5->3->4.
 * 
 * @author rkata
 *
 */
public class ReorderList {

	// convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4.
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode slowP = head;
		ListNode fastP = head;

		while (fastP != null && fastP.next != null) {
			slowP = slowP.next;
			fastP = fastP.next.next;
		}

		// reverse the secoundHalf
		ListNode prevNode = null;
		ListNode curNode = slowP;

		while (curNode != null) {
			ListNode nextNode = curNode.next;
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = nextNode;
		}

		// now merge the head and curNode values which would the starting points.
		System.out.println("head.val " + head.val);
		System.out.println("prevNode.val " + prevNode.val);

		ListNode lListNode1 = head;
		ListNode lListNode2 = prevNode;
		while (lListNode2.next != null) {
			ListNode lList1NextNode = lListNode1.next;
			lListNode1.next = lListNode2;
			lListNode1 = lList1NextNode;

			ListNode lList2NextNode = lListNode2.next;
			lListNode2.next = lListNode1;
			lListNode2 = lList2NextNode;
		}
	}

	public static void main(String[] args) {
		ReorderList solver = new ReorderList();

		ListNode head = new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
		solver.reorderList(head);

		while (head != null) {
			System.out.println(head.val + "->");
			head = head.next;
		}
	}

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

		public ListNode next() {
			return next;
		}
	}
}
