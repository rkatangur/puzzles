package org.examples.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindTopKNumbers {

	public static void main(String[] args) {
//		[1,1,1,2,2,3]
//				2
		FindTopKNumbers solver = new FindTopKNumbers();
		int[] elems = solver.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
	}

	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> numsWithCounts = new HashMap<>();

		for (int num : nums) {
			Integer numCount = numsWithCounts.get(num);
			if (numCount != null) {
				numCount = numCount + 1;
			} else {
				numCount = 1;
			}
			numsWithCounts.put(num, numCount);
		}

		Comparator<int[]> objComp = (int[] o1, int[] o2) -> {
			if (o1[1] == o2[1]) {
				if (o1[0] == o2[0]) {
					return 0;
				}
				if (o1[0] < o2[0]) {
					return -1;
				} else if (o1[0] > o2[0]) {
					return 1;
				}
				return 0;
			} else if (o1[1] > o2[1]) {
				return 1;
			} else {
				return -1;
			}
		};

		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, objComp);

		for (Map.Entry<Integer, Integer> entry : numsWithCounts.entrySet()) {
			int num = entry.getKey();
			int countOfNum = entry.getValue();
			int[] numWithLowerCount = heap.peek();

			if (numWithLowerCount == null || heap.size() < k) {
				heap.add(new int[] { num, countOfNum });
			} else if (countOfNum > numWithLowerCount[1]) {
				heap.poll();
				heap.add(new int[] { num, countOfNum });
			}
		}

		int[] topElements = new int[heap.size()];
		for (int i = k - 1; i >= 0; i--) {
			int[] numWithCount = heap.poll();
			topElements[i] = numWithCount[0];
		}
		return topElements;
	}

}
