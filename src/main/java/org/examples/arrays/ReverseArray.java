package org.examples.arrays;

public class ReverseArray {

  public static void main(String[] args) {
    int[] arrOfNumbers = new int[] {1, 3, 4, 5, 7, 8};
    reverseArray(arrOfNumbers);
  }

  private static void reverseArray(int[] arrOfNumbers) {
    int i = 0;
    for (; i < arrOfNumbers.length / 2; i++) {
      int temp = arrOfNumbers[i];
      arrOfNumbers[i] = arrOfNumbers[arrOfNumbers.length - 1 - i];
      arrOfNumbers[arrOfNumbers.length - 1 - i] = temp;
    }
    printArray(arrOfNumbers);
  }


  private static void printArray(int[] arrOfNumbers) {
    int i = 0;
    StringBuilder sb = new StringBuilder();
    for (; i < arrOfNumbers.length; i++) {
      sb.append(arrOfNumbers[i] + " ");
    }

    System.out.println(sb.toString());
  }

}
