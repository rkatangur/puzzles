package org.examples.arrays;

import java.util.Arrays;
import java.util.List;

public class NonDivisibleSubset {

	// Driver method
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(3, 7, 2, 9, 1);
		int K = 3;
		nonDivisibleSubset(K, arr);
	}

	public static int nonDivisibleSubset(int k, List<Integer> nums) {

		int[] freqMap = new int[k];

		for (int num : nums) {
			freqMap[num % k] += 1;
		}

		int length = Math.min(freqMap[0], 1);
		if (k % 2 == 0) {
			freqMap[k / 2] = Math.min(freqMap[k / 2], 1);
		}

		for (int i = 1; i <= k / 2; i++) {
			length += Math.max(freqMap[i], freqMap[k - i]);
		}

		return length;
	}

}
