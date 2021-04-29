package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 974. Subarray Sums Divisible by K
 * 
 * Given an array A of integers, return the number of (contiguous, non-empty)
 * subarrays that have a sum divisible by K.
 * 
 * Example 1:
 * 
 * Input: A = [4,5,0,-2,-3,1], K = 5 Output: 7 Explanation: There are 7
 * subarrays with a sum divisible by K = 5: [4, 5, 0, -2, -3, 1], [5], [5, 0],
 * [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 30000 -10000 <= A[i] <= 10000 2 <= K <= 10000
 * 
 * 
 * 
 * @author rkata
 *
 */
public class SubarraySumsDiviByK {

	public static void main(String[] args) {
		SubarraySumsDiviByK solver = new SubarraySumsDiviByK();
		System.out.println(solver.subarraysDivByKV1(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
		System.out.println(solver.subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
	}

	public int subarraysDivByKV1(int[] A, int K) {
		int[] prefixSums = new int[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			prefixSums[i + 1] = prefixSums[i] + A[i];
		}

		int[] count = new int[K];
		for (int i = 0; i < prefixSums.length; i++) {
			count[(prefixSums[i] % K + K) % K]++;
		}

		int numOfSubArrays = 0;
		for (int i = 0; i < count.length; i++) {
			numOfSubArrays += (count[i] * (count[i] - 1)) / 2;
		}

		return numOfSubArrays;
	}

	public int subarraysDivByK(int[] A, int K) {
		Map<Integer, Integer> mapOfSums = new HashMap<>();
		mapOfSums.put(0, 1);
		int numOfSubarrays = 0;
		int prefixSum = 0;
		for (int i = 0; i < A.length; i++) {
			int rem = A[i] % K;
			prefixSum += rem + K;
			prefixSum = prefixSum % K;

			if (mapOfSums.containsKey(prefixSum)) {
				numOfSubarrays += mapOfSums.get(prefixSum);
			}
			mapOfSums.put(prefixSum, mapOfSums.getOrDefault(prefixSum, 0) + 1);
		}

		return numOfSubarrays;
	}

}
