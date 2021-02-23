package org.examples.arrays;

/*
A Boolean Matrix Question
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) 
then make all the cells of ith row and jth column as 1.
Example 1
The matrix
1 0
0 0
should be changed to following
1 1
1 0

Example 2
The matrix
0 0 0
0 0 1
should be changed to following
0 0 1
1 1 1

Example 3
The matrix
1 0 0 1
0 0 1 0
0 0 0 0
should be changed to following
1 1 1 1
1 1 1 1
1 0 1 1
*/
public class BooleanMatrix {

	public static void main(String[] args) {
		int mat[ ][ ] = { {1, 0, 0, 1}, 
                {0, 0, 1, 0}, 
                {0, 0, 0, 0},}; 
            
      System.out.println("Matrix Intially"); 
        
      ArraysUtil.printMatrix(mat, 3, 4);
      int[][] clonedMat = populateBooleanMatrix(mat);
      ArraysUtil.printMatrix(clonedMat, 3, 4);
	}

	public static int[][] populateBooleanMatrix(int[][] args) {
		int[][] argsClone = new int[args.length][args[0].length];

		for (int i = 0; i < args.length; i++) {
			for (int j = 0; j < args[i].length; j++) {
				if (args[i][j] == 1) {
					populateOnes(i, j, args[i].length, argsClone);
				}
			}
		}

		return argsClone;
	}

	private static void populateOnes(int rowIdx, int columnIdx, int numOfClms, int[][] argsClone) {
		for (int i = 0; i < numOfClms; i++) {
			argsClone[rowIdx][i] = 1;
		}

		for (int i = 0; i < argsClone.length; i++) {
			argsClone[i][columnIdx] = 1;
		}
	}

}
