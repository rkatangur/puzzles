package org.examples.arrays;

public class FindPairWithMaxDistance {

	// ray[] = [3, 6, 5, 10, 2, 6]
	// 0, 1, 2, 3, 4, 5
	// target = 12
	// multiple pars that can
	// find the pair that is farther in distance with the target sum.

	public static int findMaxDistance(int[] arr, int target) {
		int[][] arrPairs = new int[arr.length][2];
		int pairsFound = 0;
		for (int i = 0; i < arr.length; i++) {
			int leftOver = target - arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (leftOver == arr[j]) {
					arrPairs[pairsFound++] = new int[] { i, j };
					break;
				}
			}
		}

		int maxPairDistance = -1;
		for (int i = 0; i < pairsFound; i++) {
			if (arrPairs[i].length >= 2) {
				int pairDistance = arrPairs[i][1] - arrPairs[i][0];
				if (maxPairDistance < pairDistance) {
					maxPairDistance = pairDistance;
				}
			}
		}

		printTwoDimArray(arrPairs, pairsFound);
		return maxPairDistance;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 6, 5, 10, 2, 6 };
		System.out.println(findMaxDistance(arr, 12));
	}

	private static void printTwoDimArray(int[][] arrOfNumbers, int arrLength) {
		int i = 0;
		for (; i < arrLength; i++) {
			printArray(arrOfNumbers[i]);
			System.out.println();
		}
	}

	private static void printArray(int[] arrOfNumbers) {
		int i = 0;
		for (; i < arrOfNumbers.length; i++) {
			System.out.print(arrOfNumbers[i] + " ");
		}
	}
}
