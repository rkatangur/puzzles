package org.examples.collections;

import java.util.LinkedList;

public class StackUsingQueue {

	private LinkedList<Integer> queueWithAllElements = new LinkedList<Integer>();
	private LinkedList<Integer> emptyQueue = new LinkedList<Integer>();

	/** Initialize your data structure here. */
	public StackUsingQueue() {
	}

	/** Push element x onto stack. */
	public void push(int x) {
		emptyQueue.add(x);
		while (!queueWithAllElements.isEmpty()) {
			emptyQueue.add(queueWithAllElements.poll());
		}
		LinkedList<Integer> tempQ = this.queueWithAllElements;
		this.queueWithAllElements = emptyQueue;
		this.emptyQueue = tempQ;

	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return this.queueWithAllElements.poll();
	}

	/** Get the top element. */
	public int top() {
		return this.queueWithAllElements.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return this.queueWithAllElements.isEmpty();
	}
}
