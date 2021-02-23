package org.examples.collections;

public class CircularQueueV2 {

	private int k;
	private int[] cirQ = null;

	private int headIndex = -1;
	private int tailIndex = -1;

	public CircularQueueV2(int k) {
		this.k = k;
		cirQ = new int[k];
	}

	public boolean enQueue(int value) {
		if (isFull()) {
			System.out.println("unable to enQueue " + value + " as it is full, headIndex " + headIndex + ", tailIndex "
					+ tailIndex);
			return false;
		}

		if (headIndex == -1) {
			headIndex = 0;
		}

		tailIndex = (tailIndex + 1) % k;
		System.out.println("Adding val " + value + " at tailIndex " + tailIndex);
		cirQ[tailIndex] = value;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}

		// removed the element at headIndex
		int valRemoved = cirQ[headIndex];
		System.out.println("Removed val " + valRemoved + " at headIndex " + headIndex);
		cirQ[headIndex] = 0;

		if (headIndex == tailIndex) {
			headIndex = -1;
			tailIndex = -1;
			return true;
		}

		// updating headIndex to the next valid position.
		headIndex = (headIndex + 1) % k;
		System.out.println("Next headIndex " + headIndex);
		return true;
	}

	public int size() {
		if (headIndex == -1) {
			return 0;
		} else if (headIndex > tailIndex) {
			return k - headIndex + tailIndex + 1;
		} else {
			return tailIndex - headIndex + 1;
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
//		 ((tail + 1) % size) == head;

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

		return cirQ[tailIndex];
	}

	public static void main(String[] args) {
//		Explanation
		CircularQueueV2 myCircularQueue = new CircularQueueV2(3);
		myCircularQueue.enQueue(1); // return True
		myCircularQueue.enQueue(2); // return True
		myCircularQueue.enQueue(3); // return True
		myCircularQueue.enQueue(4); // return False
		myCircularQueue.Rear(); // return 3
		myCircularQueue.isFull(); // return True
		myCircularQueue.deQueue(); // return True
		System.out.println(myCircularQueue.enQueue(4)); // return True
		myCircularQueue.Rear(); // return 4
	}

}
