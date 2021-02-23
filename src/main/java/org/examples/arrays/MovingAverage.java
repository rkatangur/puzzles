package org.examples.arrays;

import java.util.LinkedList;

public class MovingAverage {
	int size;
	private LinkedList<Integer> queue = new LinkedList<Integer>();

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		queue = new LinkedList<Integer>();
	}

	public double next(int val) {
		if (queue.size() == size) {
			queue.poll();
		}
		queue.add(val);

		return calMovingAverage();
	}

	public double calMovingAverage() {
		double sum = 0;
		for (Integer e : queue) {
			sum = sum + e;
		}

		double movingAvg = sum / queue.size();
		return movingAvg;
	}
	
	
	

}
