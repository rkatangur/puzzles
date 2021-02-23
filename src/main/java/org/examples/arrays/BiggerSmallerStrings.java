package org.examples.arrays;

import java.util.Scanner;

public class BiggerSmallerStrings {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOfLines = Integer.parseInt(sc.nextLine());

    String[] wordsToOrder = new String[numOfLines];
    for (int i = 0; i < numOfLines; i++) {
      wordsToOrder[i] = sc.nextLine();
    }

    for (String word : wordsToOrder) {
      System.out.println(String.valueOf(findBiggerAndSmallerString(word)));
    }
  }

  private static char[] findBiggerAndSmallerString(String word) {
    char[] origWordArray = word.toCharArray();
    boolean noMatch = true;

    for (int i = origWordArray.length - 1; i >= 0; i--) {
      char c = origWordArray[i];
      if (i == 0) {
        continue;
      } else {
        char cAtUpperPos = origWordArray[i - 1];
        if (cAtUpperPos < c) {
          noMatch = false;
          char nextHiggerC = c;
          int nextHiggerCPos = i;
          // step#1: Find the next higher char that can get into it.
          for (int j = i; j < origWordArray.length; j++) {
            if (origWordArray[j] <= nextHiggerC && origWordArray[j] > cAtUpperPos) {
              nextHiggerC = origWordArray[j];
              nextHiggerCPos = j;
            }
          }
          origWordArray[i - 1] = nextHiggerC;
          origWordArray[nextHiggerCPos] = cAtUpperPos;

          // sort the characters
          sort(origWordArray, i);

          break;
        }
      }
    }

    if (noMatch) {
      return "no answer".toCharArray();
    } else {
      return origWordArray;
    }
  }

  private static void sort(char[] origWordArray, int position) {
    int arrayLengthToSort = origWordArray.length - position;

    for (int i = 0; i < arrayLengthToSort; i++) {
      for (int j = origWordArray.length - 1; j > position + i; j--) {
        if (origWordArray[j] < origWordArray[j - 1]) {
          char temp = origWordArray[j];
          origWordArray[j] = origWordArray[j - 1];
          origWordArray[j - 1] = temp;
        }
      }
    }
  }

}
