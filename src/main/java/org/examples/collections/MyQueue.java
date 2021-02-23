package org.examples.collections;

public class MyQueue {
	private int[] queueElems = new int[1000];
	int front = 0;
	int rear = 0;

	/** Initialize your data structure here. */
	public MyQueue() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
//		if(rear>=1000) {
//			rear = 0;
//		}
		queueElems[rear++] = x;
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (rear == front) {
			return -1;
		}
		return queueElems[front++];
	}

	/** Get the front element. */
	public int peek() {
		if (front == rear) {
			return -1;
		}
		return queueElems[front];
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return (front == rear)? true : false;
	}

	/**
	 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
	 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
	 * obj.peek(); boolean param_4 = obj.empty();
	 */
}
