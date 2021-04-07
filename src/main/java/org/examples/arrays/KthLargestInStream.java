package org.examples.arrays;

import java.util.PriorityQueue;

/**
 * 
 * 703. Kth Largest Element in a Stream
 * 
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Implement KthLargest class:
 * 
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and
 * the stream of integers nums. int add(int val) Returns the element
 * representing the kth largest element in the stream.
 * 
 * Example 1:
 * 
 * 
 * Input
 * 
 * ["KthLargest", "add", "add", "add", "add", "add"] [[3, [4, 5, 8, 2]], [3],
 * [5], [10], [9], [4]]
 * 
 * Output [null, 4, 5, 5, 8, 8]
 * 
 * Explanation
 * 
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]); kthLargest.add(3);
 * // return 4 kthLargest.add(5); // return 5 kthLargest.add(10); // return 5
 * kthLargest.add(9); // return 8 kthLargest.add(4); // return 8
 * 
 */
public class KthLargestInStream {

	private PriorityQueue<Integer> sortedElements = new PriorityQueue<Integer>();
	int kMaxElements;
	public KthLargestInStream(int k, int[] nums) {
		sortedElements = new PriorityQueue<Integer>(k);
		this.kMaxElements = k;
		for (int num : nums) {
//			sortedElements.offer(num);
			add(num);
		}
	}

	public int add(int val) {
		if (sortedElements.size() < kMaxElements) {
			sortedElements.offer(val);
		} else if (sortedElements.peek() < val) {
			sortedElements.poll();
			sortedElements.offer(val);
		}

		return sortedElements.peek();
	}

}
