package org.examples.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Before going to the current problem with the tree, let's check the idea on a
 * simpler example Find a number of continuous subarrays that sum to target.
 * 
 * Use a variable to track the current prefix sum and a hashmap "prefix sum ->
 * how many times was it seen so far".
 * 
 * @author rkata
 */
public class ContinuousSubarraysSumToTarget {

	public static void main(String[] args) {
		ContinuousSubarraysSumToTarget solver = new ContinuousSubarraysSumToTarget();
		System.out.println(solver.pathSum(new int[] { 3, 4, 1, 6, -3 }, 7));
	}

	// target sum =7
	// {3, 4, 1, 6, -3}
	public int pathSum(int[] arr, int targetSum) {

		Map<Integer, Integer> prefSumMap = new HashMap<>();
		int currSum = 0;
		int countOfSubArrays = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum == targetSum) {
				countOfSubArrays++;
			}
			
			if (prefSumMap.containsKey(currSum - targetSum)) {
				countOfSubArrays += prefSumMap.get(currSum - targetSum);
			}
			prefSumMap.put(currSum, prefSumMap.getOrDefault(currSum, 0) + 1);
		}
		return countOfSubArrays;
	}

}
