package org.examples;

import java.util.Scanner;

public class MatrixRotation {
  // It is guaranteed that the minimum of M and N will be even.
  //
  // Input Format
  // First line contains three space separated integers, M, N and R, where M is the number of rows,
  // N is number of columns in matrix, and R is the number of times the matrix has to be rotated.
  // Then M lines follow, where each line contains N space separated positive integers. These M
  // lines represent the matrix.
  //
  // Constraints
  // 2 <= M, N <= 300
  // 1 <= R <= 109
  // min(M, N) % 2 == 0
  // 1 <= aij <= 108, where i ∈ [1..M] & j ∈ [1..N]

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    int rotations = in.nextInt();

    int[][] matrix = new int[m][n];

    // int matrix[][] = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = in.nextInt();
      }
    }

    rotateMatrix(matrix, rotations);
    printTwoDimArray(matrix);
  }

  // An Inplace function to rotate a N x N matrix in anti-clockwise direction
  static void rotateMatrix(int mat[][], int numOfRotations) {

    for (int i = 0; i < numOfRotations; i++) {
      rotateMatrix(mat);
    }
  }

  private static void rotateMatrix(int[][] mat) {
    int numOfRows = mat.length;
    int numOfClms = mat[0].length;
    int numOfCycles = Math.min(numOfRows, numOfClms) / 2;
    // Consider all cycles one by one
    for (int x = 0; x < numOfCycles; x++) {
      rotateCycle(x, mat);
    }
  }

  private static void rotateCycle(int cycleNum, int[][] mat) {
    int rowStartIdx = cycleNum;
    int clmStartIdx = cycleNum;

    int numOfClms = mat[rowStartIdx].length;

    int lastRowIdx = mat.length - cycleNum - 1;
    int lastClmIdx = numOfClms - cycleNum - 1;

    boolean isAcross = false;
    boolean increment = true;

    int movingIdx = rowStartIdx;

    int temp = mat[rowStartIdx][clmStartIdx];
    int prevVal = temp;

    int rowToUse = !isAcross ? movingIdx : rowStartIdx;
    int clmToUse = isAcross ? movingIdx : clmStartIdx;

    while (true) {
      if (isAcross) {
        movingIdx = increment ? movingIdx + 1 : movingIdx - 1;
        prevVal = mat[rowToUse][movingIdx];
        mat[rowToUse][movingIdx] = temp;
        temp = prevVal;
        if (movingIdx >= lastClmIdx || movingIdx <= clmStartIdx) {
          isAcross = false;
          increment = increment ? false : true;

          clmToUse = movingIdx;
          movingIdx = rowToUse;

          if (rowToUse == rowStartIdx && clmToUse == clmStartIdx) {
            break;
          }

        }

      } else {
        movingIdx = increment ? movingIdx + 1 : movingIdx - 1;
        prevVal = mat[movingIdx][clmToUse];
        mat[movingIdx][clmToUse] = temp;
        temp = prevVal;
        if (movingIdx >= lastRowIdx || movingIdx <= rowStartIdx) {
          isAcross = true;
          increment = increment ? true : false;
          rowToUse = movingIdx;
          movingIdx = clmToUse;
          if (rowToUse == rowStartIdx && clmToUse == clmStartIdx) {
            break;
          }
        }
      }
    }
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
      System.out.print(arrOfNumbers[i] + " ");
    }
  }
}
