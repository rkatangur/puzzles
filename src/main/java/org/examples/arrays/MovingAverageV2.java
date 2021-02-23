package org.examples.arrays;

public class MovingAverageV2 {

	int size, head = 0, windowSum = 0, count = 0;
	int[] queue;

	public MovingAverageV2(int size) {
		this.size = size;
		queue = new int[size];
	}

	public double next(int val) {
		++count;
		// calculate the new sum by shifting the window
		int tail = (head + 1) % size;
		windowSum = windowSum - queue[tail] + val;
		// move on to the next head
		head = (head + 1) % size;
		queue[head] = val;
		return windowSum * 1.0 / Math.min(size, count);
	}

	public static void main(String[] args) {
		MovingAverageV2 m = new MovingAverageV2(3);
		System.out.println(m.next(1)); // 1
		System.out.println(m.next(10)); // (1 + 10) / 2
		System.out.println(m.next(3)); // (1 + 10 + 3) / 3
		System.out.println(m.next(5)); // (10 + 3 + 5) / 3
	}

}
