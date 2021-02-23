package org.examples.recursion;

public class SimpleRecursion {

	public static void main(String[] args) {
		System.out.println("------------------");
		printStringReversly("hello");
		System.out.println("");
		System.out.println("------------------");
		reverseString("hello");
		
		System.out.println(fibonaci(1));
	}
	
	public static int fibonaci(int num) {
		if(num <= 1) {
			return num;
		}
		return fibonaci(num - 1) + fibonaci(num - 2);
	}

	public static void printStringReversly(String arg) {
		printStringReversly(arg.toCharArray(), 0);
	}

	public static void printStringReversly(char[] strChars, int index) {
		if (strChars == null || index >= strChars.length) {
			return;
		}

		printStringReversly(strChars, index + 1);
		System.out.print(strChars[index]);
	}

	public static void reverseString(String arg) {
		char[] origCharArr = arg.toCharArray();
		reverseString(origCharArr, 0, origCharArr.length - 1);
		System.out.println("OriginalStr " + arg + ", reverseString " + new String(origCharArr));
	}

	public static void reverseString(char[] origCharArr, int startIndex, int endIndex) {
		if (origCharArr == null || startIndex >= endIndex) {
			return;
		}

		char tempChar = origCharArr[startIndex];
		origCharArr[startIndex] = origCharArr[endIndex];
		origCharArr[endIndex] = tempChar;

		reverseString(origCharArr, startIndex + 1, endIndex - 1);
	}

	public void reverseString(char[] s, int index) {
		if (s == null || index >= (s.length / 2)) {
			return;
		}

		char temp = s[index];
		s[index] = s[s.length - 1 - index];
		s[s.length - 1 - index] = temp;

		reverseString(s, index + 1);
	}

//	Given a linked list, swap every two adjacent nodes and return its head.
//			e.g.  for a list 1-> 2 -> 3 -> 4, one should return the head of list as 2 -> 1 -> 4 -> 3.
	public ListNode swapPairs(ListNode head) {
		if (head != null) {
			return swapPairs(head, head.next);
		} else {
			return head;
		}
	}

	public static ListNode swapPairs(ListNode node, ListNode nextNode) {
		if (node == null || nextNode == null) {
			return node;
		}

		ListNode temp = nextNode.next;
		nextNode.next = node;
		System.out.println("Processing node.val " + node.val + ", nextNodVal " + node.next.val);
		if (temp != null) {
			node.next = swapPairs(temp, temp.next);
		} else {
			node.next = null;
		}
		return nextNode;
	}

	public static ListNode reverseLinkedList(ListNode node) {
		return reverseLinkedList(null, node, null);
	}

	public static ListNode reverseLinkedList(ListNode prevNode, ListNode curNode, ListNode head) {

		ListNode nextNode = curNode.next;
		if (nextNode != null) {
			head = reverseLinkedList(curNode, nextNode, head);
		} else {
			head = curNode;
		}

		curNode.next = prevNode;
		return head;
	}
	
	public static ListNode reverseLinkedListV1(ListNode head) {
		
		if(head == null) {
			return head;
		}

		//this is new head
		if(head.next == null) {
			return head;
		}
		
		ListNode newHead = reverseLinkedListV1(head.next);
		
        // change references for middle chain 
		head.next.next = head;
		head.next = null;
	
		return newHead;
	}


	/**
	 * 
	 * Definition for singly-linked list.
	 *
	 */
	public class ListNode {
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
