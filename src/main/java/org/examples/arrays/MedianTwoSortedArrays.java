package org.examples.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianTwoSortedArrays {

	public static void main(String[] args) {
		MedianTwoSortedArrays solver = new MedianTwoSortedArrays();
//		System.out.println(solver.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(solver.findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return -1;
				} else if (o1 < o2) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		int i = 0;
		int j = 0;
		while (i < nums1.length || j < nums2.length) {
			int numToAdd = -1;
			if (i < nums1.length && j < nums2.length) {
				if (nums1[i] < nums2[j]) {
					numToAdd = nums1[i++];
				} else if (nums2[j] < nums1[i]) {
					numToAdd = nums2[j++];
				} else {
					numToAdd = nums1[i++];
				}
			} else if (i < nums1.length) {
				numToAdd = nums1[i++];
			} else if (j < nums2.length) {
				numToAdd = nums2[j++];
			}

			if (maxHeap.isEmpty() || numToAdd < maxHeap.peek())
				maxHeap.add(numToAdd);
			else
				minHeap.add(numToAdd);

			if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
				PriorityQueue<Integer> heapWithMoreNums = null;
				PriorityQueue<Integer> heapWithLessNums = null;
				if (minHeap.size() > maxHeap.size()) {
					heapWithMoreNums = minHeap;
					heapWithLessNums = maxHeap;
				} else if (maxHeap.size() > minHeap.size()) {
					heapWithMoreNums = maxHeap;
					heapWithLessNums = minHeap;
				}

				while (heapWithMoreNums.size() - heapWithLessNums.size() > 1) {
					heapWithLessNums.add(heapWithMoreNums.poll());
				}
			}
		}

		if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.poll();
		} else if (minHeap.size() > maxHeap.size()) {
			return (double) minHeap.poll();
		} else {
			double median = ((double) maxHeap.poll() + (double) minHeap.poll()) / 2;
			return median;
		}
	}

}
