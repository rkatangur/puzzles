package org.examples.arrays;

import java.util.Scanner;

public class ArrayManipulation {

  long out = 2497169732l;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    if ((n >= 3 && n <= Math.pow(10, 7)) && (m >= 1 && m <= 2 * Math.pow(10, 5))) {
      long[] srcArr = new long[n];
      for (int i = 0; i < m; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        long k = in.nextLong();

        if ((k >= 0 && k <= Math.pow(10, 9)) && (a >= 1 && a <= n) && (b >= a && b <= n)) {
          for (int j = 1; j <= srcArr.length; j++) {
            if (j >= a && j <= b) {
              srcArr[j - 1] = srcArr[j - 1] + k;
            }
          }
        }
      }

      long maxVal = 0;
      for (int i = 0; i < srcArr.length; i++) {
        if (i == 0) {
          maxVal = srcArr[i];
        } else {
          maxVal = Math.max(maxVal, srcArr[i]);
        }
      }

      System.out.println(maxVal);

      in.close();
    }
  }

}
