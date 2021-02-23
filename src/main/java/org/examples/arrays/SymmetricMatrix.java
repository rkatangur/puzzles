package org.examples.arrays;

/*
Find a Symmetric matrix of order N that contain integers from 0 to N-1 and main diagonal should contain only 0’s
Given an integer N. The task is to generate a symmetric matrix of order N*N having the following properties.

Main diagonal should contain only 0’s
The matrix should contain elements from 0 to N-1 only.
Examples:

Input: N = 4
Output:
0 2 3 1
2 0 1 3
3 1 0 2
1 3 2 0

Input: N = 5
Output:
0 2 3 4 1
2 0 4 1 3
3 4 0 2 1
4 1 2 0 3
1 3 1 3 0
*/

public class SymmetricMatrix {

	public static void main(String[] args) {
		int[][] symmetricMatrix4by4 = buildSymmetricMatrix(4);
		printTwoDimArray(symmetricMatrix4by4);
		int[][] symmetricMatrix5by5 = buildSymmetricMatrix(5);
		printTwoDimArray(symmetricMatrix5by5);
	}

	private static int[][] buildSymmetricMatrix(int n) {
		int[][] symmetricMatrix = new int[n][n];
		for (int i = 0; i < symmetricMatrix.length - 1; i++) {
			int startElem = i + 1;
			for (int j = 0; j < symmetricMatrix[i].length - 1; j++) {
				symmetricMatrix[i][j] = startElem;
				if (startElem + 1 > symmetricMatrix.length - 1) {
					startElem = 1;
				} else {
					startElem++;
				}
			}

			int elemToSwap = symmetricMatrix[i][i];
			symmetricMatrix[i][i] = 0;
			symmetricMatrix[i][symmetricMatrix[i].length - 1] = elemToSwap;
			symmetricMatrix[symmetricMatrix[i].length - 1][i] = elemToSwap;
		}

		return symmetricMatrix;
	}

	// not working.
	private static int[][] buildSymmetricMatrix1(int n) {
		int[][] symmetricMatrix = new int[n][n];
		for (int i = 0; i < symmetricMatrix.length; i++) {
			int rowStartElem = (i + 1 >= symmetricMatrix.length) ? 1 : i + 1;
			int elemCounter = rowStartElem;
			int[] arrElemsTracker = new int[symmetricMatrix[i].length];
			for (int j = 0; j < symmetricMatrix[i].length; j++) {
				if (i == j) {
					symmetricMatrix[i][j] = 0;
					symmetricMatrix[i][symmetricMatrix[i].length - 1] = elemCounter;
					arrElemsTracker[elemCounter] = 1;
					arrElemsTracker[0] = 1;
				} else {
					symmetricMatrix[i][j] = elemCounter;
					arrElemsTracker[elemCounter] = 1;
				}
				boolean allClmsFilled = false;
				int curElemCounter = elemCounter;
				while (arrElemsTracker[elemCounter] == 1) {
					if (elemCounter + 1 >= symmetricMatrix[i].length) {
						elemCounter = 1;
					} else {
						elemCounter++;
					}
					if (elemCounter == curElemCounter) {
						allClmsFilled = true;
						break;
					}
				}

				if (allClmsFilled) {
					break;
				}
			}
		}
		return symmetricMatrix;
	}

	private static void printTwoDimArray(int[][] arrOfNumbers) {
		int i = 0;
		for (; i < arrOfNumbers.length; i++) {
			printArray(arrOfNumbers[i]);
			System.out.println();
		}
	}

	private static void printArray(int[] arrOfNumbers) {
		int i = 0;
		for (; i < arrOfNumbers.length; i++) {
			System.out.print(arrOfNumbers[i]);
		}
	}

}
