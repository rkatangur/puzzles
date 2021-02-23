package org.examples;

public class NonDivisibleSubset {


  public static void main(String[] args) {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
     * named Solution.
     */
    // int arr[] = {1, 2, 3, 4, 5};
    int arr[] = {1, 7, 2, 4};

    int r = 3;
    findNonDivisibleCombination(arr, r, 1);
  }

  private static void findNonDivisibleCombination(int[] arr, int r, int offset) {
    if (arr.length - offset == 1) {
      return;
    }

    if (findNonDivisbleSubset(arr, arr.length - offset, r)) {

    } else {
      findNonDivisibleCombination(arr, r, offset + 1);
    }
  }

  private static boolean findNonDivisbleSubset(int[] arr, int subsetSize, int divisor) {
    int[] data = new int[subsetSize];
    return fillCombinations(arr, data, 0, arr.length - 1, 0, subsetSize, divisor);
  }

  private static boolean fillCombinations(int[] arr, int[] data, int start, int end, int index,
      int subsetSize, int divisor) {
    if (index == subsetSize) {
      if (!checkIsDataDivisible(data, divisor)) {
        printArray(data);
        return true;
      }
    }

    for (int i = start; i <= end && end - i + 1 >= subsetSize - index; i++) {
      data[index] = arr[i];
      fillCombinations(arr, data, i + 1, end, index + 1, subsetSize, divisor);
    }

    return false;
  }

  private static boolean checkIsDataDivisible(int[] arr, int divisor) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if ((arr[i] + arr[j]) % divisor == 0) {
          return true;
        }
      }
    }
    return false;
  }

  public static void printArray(int[] subArr) {
    for (int i : subArr)
      System.out.print(i);
    System.out.println();
  }
}
