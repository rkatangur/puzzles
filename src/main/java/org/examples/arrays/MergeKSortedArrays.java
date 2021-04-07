package org.examples.arrays;

import org.examples.arrays.AddTwoNumbers.ListNode;

/**
 * 
 * 23. Merge k Sorted Lists
 * 
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * Example 1:
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6
 * 
 * Example 2:
 * 
 * Input: lists = [] Output: []
 * 
 * 
 * Example 3:
 * 
 * Input: lists = [[]] Output: []
 * 
 * 
 * Constraints:
 * 
 * k == lists.length 0 <= k <= 10^4 0 <= lists[i].length <= 500 -10^4 <=
 * lists[i][j] <= 10^4 lists[i] is sorted in ascending order. The sum of
 * lists[i].length won't exceed 10^4.
 * 
 * @author rkata
 *
 */
public class MergeKSortedArrays {

	public static void main(String[] args) {
//		[[1,4,5],[1,3,4],[2,6]]
		MergeKSortedArrays solver = new MergeKSortedArrays();
		ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode list3 = new ListNode(2, new ListNode(6));

		ListNode[] lists = new ListNode[] { list1, list2, list3 };
		solver.mergeKLists(lists);
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeKLists(lists, 0, lists.length - 1);
	}

	private ListNode mergeKLists(ListNode[] lists, int i, int j) {
		if (i == j) {
			return lists[i];
		}

		int mid = (i + j) / 2;

		ListNode list1 = mergeKLists(lists, i, mid);
		ListNode list2 = mergeKLists(lists, mid + 1, j);

		ListNode head = new ListNode();
		ListNode mergedListNode = head;
		while (list1 != null || list2 != null) {
			if (list1 != null && list2 != null) {
				if (list1.val < list2.val) {
					ListNode temp = list1.next;
					mergedListNode.next = list1;
					mergedListNode.next.next = null;
					mergedListNode = mergedListNode.next;
					list1 = temp;
				} else if (list1.val > list2.val) {
					ListNode temp = list2.next;
					mergedListNode.next = list2;
					mergedListNode.next.next = null;
					mergedListNode = mergedListNode.next;
					list2 = temp;
				} else {
					ListNode temp = list1.next;
					mergedListNode.next = list1;
					mergedListNode.next.next = null;
					mergedListNode = mergedListNode.next;
					list1 = temp;

					temp = list2.next;
					mergedListNode.next = list2;
					mergedListNode.next.next = null;
					mergedListNode = mergedListNode.next;
					list2 = temp;
				}
			} else if (list1 != null) {
				ListNode temp = list1.next;
				mergedListNode.next = list1;
				mergedListNode.next.next = null;
				mergedListNode = mergedListNode.next;
				list1 = temp;
			} else if (list2 != null) {
				ListNode temp = list2.next;
				mergedListNode.next = list2;
				mergedListNode.next.next = null;
				mergedListNode = mergedListNode.next;
				list2 = temp;
			}
		}

		return head.next;
	}

}
