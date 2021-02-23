package org.examples.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 *Find k closest numbers in an unsorted array
  Given an unsorted array and two numbers x and k, find k closest values to x.
 
 Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3 
 Output : 4 6 7
 Three closest values of x are 4, 6 and 7.
	
 Input : arr[] = {-10, -50, 20, 17, 80}, x = 20, k = 2
 Output : 17, 20 
 * 
 */

public class FindKClosetElements {

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 2, 14, 4, 7, 6 };
		for (Integer it : findClosestValues(arr, 3, 5)) {
			System.out.println(it);
		}

	}

	public static int[] findClosestValues(int[] arr, int k, int x) {

		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int o1Diff = o1[0];
				int o2Diff = o2[0];
				if (o1Diff < o2Diff) {
					return 1;
				} else if (o1Diff > o2Diff) {
					return -1;
				}
				return 0;
			}
		});

		int index = 0;
		for (int elem : arr) {
			int diff = Math.abs(elem - x);
			int[] elemWithLargestDiff = minHeap.peek();
			if (elemWithLargestDiff == null || minHeap.size() < 3) {
				minHeap.offer(new int[] { diff, index });
			} else if (diff < elemWithLargestDiff[0]) {
				minHeap.remove();
				minHeap.offer(new int[] { diff, index });
			}
			index++;
		}
		
		int[] kElems = new int[k];
		int i =0;
		
		int[] heapElem = minHeap.poll();
		while(heapElem != null) { 
			kElems[i++] = arr[heapElem[1]];
			heapElem = minHeap.poll();
		}
		return kElems;
	}

}
