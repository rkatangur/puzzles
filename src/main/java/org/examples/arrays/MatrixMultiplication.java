package org.examples.arrays;

/**
 * For matrix multiplication to happen the column of the first matrix should be equal to the row of
 * the second matrix.
 * 
 * @author rkatangu
 *
 */
public class MatrixMultiplication {

  public static void main(String[] args) {
    int[][] arr1 = new int[][] {
                                {1, 2}, 
                                {4, 5}, 
                                {7, 8}
                               };
                               
    int[][] arr2 = new int[][] {
                                {1, 2, 3}, 
                                {4, 5, 6}
                               };
      
    int[][] arr3 = multiply(arr1, arr2);
    
    System.out.println("arr3 " + (arr3 == null));
    
    printTwoDimArray(arr3);
  }

  public static int[][] multiply(int[][] arr1, int[][] arr2) {
    int arr1RowLength = arr1.length;
    int arr1ColLength = arr1[0].length;

    int arr2RowLength = arr2.length;
    int arr2ColLength = arr2[0].length;

    if (arr1ColLength != arr2RowLength) {
      return null;
    }

    int[][] newArr = new int[arr1RowLength][arr2ColLength];
    for (int i = 0; i < arr1RowLength; i++) {
      for (int j = 0; j < arr2ColLength; j++) {
        for (int k = 0; k < arr1ColLength; k++) {
          newArr[i][j] = newArr[i][j] + arr1[i][k] * arr2[k][j];
        }
      }
    }
    
    return newArr;
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
      System.out.print(arrOfNumbers[i]+" ");
    }
  }


}
