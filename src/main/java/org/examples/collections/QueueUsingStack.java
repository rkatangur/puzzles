package org.examples.collections;

import java.util.Stack;

public class QueueUsingStack {

	private Stack<Integer> s1Stack = new Stack<Integer>();
	private Stack<Integer> s2Stack = new Stack<Integer>();

	/** Initialize your data structure here. */
	public QueueUsingStack() {
	}

	/** Push element x to the back of queue. */
	public void push(int x) {

		moveStackElems(s1Stack, s2Stack);

		s2Stack.add(x);

		moveStackElems(s2Stack, s1Stack);
	}

	private void moveStackElems(Stack<Integer> s1Stack, Stack<Integer> s2Stack) {
		while (true) {
			Integer elem = s1Stack.pop();
			if (elem == null) {
				break;
			}
			s1Stack.add(elem);
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return s1Stack.pop();
	}

	/** Get the front element. */
	public int peek() {
		return s1Stack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s1Stack.empty();
	}

	/**
	 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
	 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
	 * obj.peek(); boolean param_4 = obj.empty();
	 */
}
