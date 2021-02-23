package org.examples.arrays;

/*
Rotate a 2D array (n x n matrix) 90 degree close-wise without creating a new array. 
For example:
Input:
const A = 
[[ 1,  2,  3,  4],
 [ 5,  6,  7,  8],
 [ 9, 10, 11, 12],
 [13, 14, 15, 16]]

(i, j) = (0, 0) 
1  2  3  4
5  6  7  8
9 10 11 12
13 14 15 16
A[0][0] = 1;
A[0][3] = 4;
A[3][3] = 16;
A[3][0] = 13;

(i, j) = (0, 1)
1  2  3  4
5  6  7  8
9 10 11 12
13 14 15 16
A[0][1] = A[i][j] = 2;
A[1][3] = A[j][n - 1 - i] = 8;
A[3][2] = A[n - 1 - i][n - 1 - j] = 15;
A[2][0] = A[n - 1 - j][i] = 9;

rotate(A); // a function
Output:
console.log(A);
[ [ 13,  9, 5, 1 ],
  [ 14, 10, 6, 2 ],
  [ 15, 11, 7, 3 ],
  [ 16, 12, 8, 4 ] ]
*/
public class Rotate2DArray {

	private static int[][] arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

	public static void main(String[] args) {
		rotate(arr);
		printTwoDimArray(arr);
	}

	public static void rotate(int[][] arr) {
		int numOfRows = arr.length;
		int numOfColumns = arr[0].length;
		
		for (int i = 0; i < numOfRows/2; i++) {
			for (int j = i; j < numOfColumns - 1 - i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[numOfRows -1 -j][i];
				arr[numOfRows -1 -j][i] = arr[numOfRows -1 -i][numOfColumns-1-j];
				arr[numOfRows -1 -i][numOfColumns-1-j] = arr[j][numOfColumns-1-i];
				arr[j][numOfColumns-1-i] = temp;
			}
		}
	}

	private static void printTwoDimArray(int[][] arrOfNumbers) {
		int i = 0;
		System.out.println("[ ");
		for (; i < arrOfNumbers.length; i++) {
			printArray(arrOfNumbers[i]);
			System.out.println(",");
		}
		System.out.println(" ]");
	}

	private static void printArray(int[] arr) {
		System.out.print("[ ");
		for (int elem : arr) {
			System.out.print(elem + ", ");
		}
		System.out.print(" ]");
	}

}
