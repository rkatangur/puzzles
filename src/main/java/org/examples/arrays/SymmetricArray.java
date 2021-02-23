package org.examples.arrays;

import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input. //imports for BufferedReader import
 * java.io.BufferedReader; import java.io.InputStreamReader;
 * 
 * //import for Scanner and other utility classes import java.util.*;
 */
public class SymmetricArray {
  public static void main(String args[]) throws Exception {
    /*
     * Read input from stdin and provide input before running Use either of these methods for input
     */

    // BufferedReader
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // String line = br.readLine();
    // int N = Integer.parseInt(line);

    // Scanner
    Scanner s = new Scanner(System.in);
    int N = s.nextInt();

    // System.out.println("Num of tests "+N);

    for (int i = 0; i < N; i++) {
      int twoDimArrSize = s.nextInt();
      // System.out.println("twoDimArrSize "+twoDimArrSize);
      int[][] twoDimArray1 = new int[twoDimArrSize][];
      for (int j = 0; j < twoDimArrSize; j++) {
        String intLine = s.next();
        // System.out.println("intLine "+intLine);
        twoDimArray1[j] = new int[intLine.length()];
        for (int k = 0; k < intLine.length(); k++) {
          twoDimArray1[j][k] = Integer.parseInt(String.valueOf(intLine.charAt(k)));
        }
      }
      // printTwoDimArray(twoDimArray1);
      System.out.println(isSymmetric(twoDimArray1) ? "YES" : "NO");
    }
  }


  static boolean isSymmetric(int[][] twoDimArray) {
    int numOfRows = twoDimArray.length;

    for (int i = 0; i < numOfRows / 2; i++) {
      int firstArrIndex = i;
      int lastArrIndex = numOfRows - 1 - i;
      int numOfClmns = twoDimArray[i].length;

      for (int j = 0; j < numOfClmns; j++) {
        if (twoDimArray[firstArrIndex][j] != twoDimArray[lastArrIndex][j]) {
          return false;
        }
      }
    }

    int numOfColumns = twoDimArray[0].length;

    for (int i = 0; i < numOfColumns / 2; i++) {
      int firstClmIndex = i;
      int lastClmIndex = numOfColumns - 1 - i;

      for (int j = 0; j < numOfRows; j++) {
        if (twoDimArray[j][firstClmIndex] != twoDimArray[j][lastClmIndex]) {
          return false;
        }
      }
    }

    return true;
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
