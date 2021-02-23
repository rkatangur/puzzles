package org.examples.arrays;

import java.util.Scanner;

public class Hourglass2D {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arr[][] = new int[6][6];
    for (int arr_i = 0; arr_i < 6; arr_i++) {
      for (int arr_j = 0; arr_j < 6; arr_j++) {
        arr[arr_i][arr_j] = in.nextInt();
      }
    }

    System.out.println(findHourglassWithMaxSum(arr));
  }


  public static int findHourglassWithMaxSum(int[][] arr) {
    int maxHourGlassSum = 0;
    boolean isMaxHourGlassSumInitialized = false;
    for (int hourGlassRowIdx = 0; hourGlassRowIdx < arr.length - 2; hourGlassRowIdx++) {
      for (int hourGlassClmIdx = 0; hourGlassClmIdx < arr[0].length - 2; hourGlassClmIdx++) {
        if (!isMaxHourGlassSumInitialized) {
          maxHourGlassSum = computeHourGlassSum(hourGlassRowIdx, hourGlassClmIdx, arr);
        } else {
          maxHourGlassSum =
              Math.max(maxHourGlassSum, computeHourGlassSum(hourGlassRowIdx, hourGlassClmIdx, arr));
        }
      }
    }
    return maxHourGlassSum;
  }


  public static int computeHourGlassSum(int hourGlassRowStartIdx, int hourGlassClmStartIdx,
      int[][] arr) {
    int hourGlassRowIdx = hourGlassRowStartIdx;
    int hourGlassSum = 0;

    while (hourGlassRowIdx < arr.length) {
      int hourGlassClmIdx = hourGlassClmStartIdx;
      while (hourGlassClmIdx < arr[hourGlassRowIdx].length) {
        if (hourGlassRowIdx - hourGlassRowStartIdx == 1) {
          if (hourGlassClmIdx - hourGlassClmStartIdx == 1) {
            hourGlassSum += arr[hourGlassRowIdx][hourGlassClmIdx];
          }
        } else {
          hourGlassSum += arr[hourGlassRowIdx][hourGlassClmIdx];
        }

        if (hourGlassClmIdx >= hourGlassClmStartIdx + 2) {
          break;
        }

        hourGlassClmIdx++;
      }
      if (hourGlassRowIdx >= hourGlassRowStartIdx + 2) {
        break;
      }

      hourGlassRowIdx++;
    }

    return hourGlassSum;
  }

}
