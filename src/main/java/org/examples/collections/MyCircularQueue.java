package org.examples.collections;

public class MyCircularQueue {

	private int k;
	private int[] cirQ = null;

	private int headIndex = 0;
	private int tailIndex = 0;
	private boolean full = false;

	public MyCircularQueue(int k) {
		this.k = k;
		cirQ = new int[k];
	}

	public boolean enQueue(int value) {
		if (isFull()) {
			System.out.println("unable to enQueue " + value + " as it is full, headIndex " + headIndex + ", tailIndex "
					+ tailIndex);
			return false;
		}

		System.out.println("Adding val " + value + " at tailIndex " + tailIndex);
		cirQ[tailIndex++] = value;
		System.out.println("Current tailIndex " + tailIndex);

		if (tailIndex >= k) {
			tailIndex = 0;
		}

		if (tailIndex == headIndex) {
			full = true;
		}

		// todo mark it as full if it reached the capacity;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}

		int valRemoved = cirQ[headIndex];
		cirQ[headIndex++] = 0;

		if (headIndex >= k) {
			headIndex = 0;
		}

		full = false;

		return true;
	}

	public int size() {
		if (headIndex > tailIndex) {
			return k - headIndex + tailIndex;
		} else if (headIndex == tailIndex) {
			return full ? k : 0;
		} else {
			return tailIndex - headIndex;
		}
	}

	public boolean isEmpty() {
		int size = size();
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		int size = size();
		if (size == k) {
			return true;
		} else {
			return false;
		}
	}

	public int Front() {
		if (isEmpty()) {
			return -1;
		}

		return cirQ[headIndex];
	}

	public int Rear() {
		if (isEmpty()) {
			return -1;
		}
		if (tailIndex <= 0) {
			return cirQ[k - 1];
		} else {
			return cirQ[tailIndex - 1];
		}
	}

	public static void main(String[] args) {
//		Explanation
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		myCircularQueue.enQueue(1); // return True
		myCircularQueue.enQueue(2); // return True
		myCircularQueue.enQueue(3); // return True
		myCircularQueue.enQueue(4); // return False
		myCircularQueue.Rear();     // return 3
		myCircularQueue.isFull();   // return True
		myCircularQueue.deQueue();  // return True
		System.out.println(myCircularQueue.enQueue(4)); // return True
		myCircularQueue.Rear();     // return 4
	}

}
