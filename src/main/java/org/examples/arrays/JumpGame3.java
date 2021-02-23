package org.examples.arrays;

import java.util.LinkedList;

/**
 * 
 * 1306. Jump Game III
 * 
 * 
 * Given an array of non-negative integers arr, you are initially positioned at
 * start index of the array. When you are at index i, you can jump to i + arr[i]
 * or i - arr[i], check if you can reach to any index with value 0.
 * 
 * Notice that you can not jump outside of the array at any time.
 * 
 * Input: arr = [4,2,3,0,3,1,2], start = 5 Output: true
 * 
 * Explanation: All possible ways to reach at index 3 with value 0 are: index 5
 * -> index 4 -> index 1 -> index 3 index 5 -> index 6 -> index 4 -> index 1 ->
 * index 3
 * 
 * @author rkata
 *
 */

public class JumpGame3 {

	public static void main(String[] args) {
		JumpGame3 solver = new JumpGame3();

		int[] arr = new int[] { 4, 2, 3, 0, 3, 1, 2 };
		int start = 5;

		System.out.println(solver.canReach(arr, start));
	}

	public boolean canReach(int[] arr, int start) {
		boolean canReach = false;
		LinkedList<Integer> queueOfPos = new LinkedList<Integer>();
		queueOfPos.add(start);
		while (!queueOfPos.isEmpty()) {
			Integer posToProcess = queueOfPos.poll();
			if (posToProcess != null) {
				int valAtPos = arr[posToProcess];
				if (valAtPos == 0) {
					canReach = true;
					break;
				}
				int nextPos1 = (valAtPos + posToProcess);
				int nextPos2 = (posToProcess - valAtPos);

				if (nextPos1 <= arr.length - 1 && nextPos1 >= 0) {
					queueOfPos.add(nextPos1);
				}

				if ((nextPos2) <= arr.length - 1 && nextPos2 >= 0) {
					queueOfPos.add(nextPos2);
				}
			}
		}

		return canReach;
	}

}
