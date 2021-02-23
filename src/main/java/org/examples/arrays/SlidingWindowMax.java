package org.examples.arrays;

import java.util.TreeMap;

/**
 * 
 * 
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7] Explanation:
 * Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5
 * 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
 * -1 -3 5 [3 6 7] 7
 * 
 * @author rkata
 *
 */

public class SlidingWindowMax {

	public static void main(String[] args) {
		SlidingWindowMax solver = new SlidingWindowMax();

//		ArraysUtil.printIntArr(solver.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));

		ArraysUtil.printIntArr(solver.maxSlidingWindow(new int[] { -7, -8, 7, 5, 7, 1, 6, 0 }, 4));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] maxNums = new int[nums.length - k + 1];
		TreeMap<Integer, Integer> sortedNums = new TreeMap<Integer, Integer>();

		int maxNumsIndex = 0;
		int leftPointer = 0;
		int rightPointer = 0;

		while (rightPointer < nums.length) {
			int curVal = nums[rightPointer++];
			sortedNums.put(curVal, sortedNums.getOrDefault(curVal, 0) + 1);
			if (rightPointer >= k) {
				maxNums[maxNumsIndex++] = sortedNums.lastKey();
				int numAtLeftP = nums[leftPointer++];
				int countOfNum = sortedNums.get(numAtLeftP);
				if (countOfNum == 1) {
					sortedNums.remove(numAtLeftP);
				} else {
					sortedNums.put(numAtLeftP, countOfNum - 1);
				}
			}
		}

		return maxNums;
	}
}
