package org.examples;

import java.util.Scanner;

public class EncryptionStr {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    char[][] encryptedCharArr = encryptStr(s);
    printEncryptedArr(encryptedCharArr, s.length());
  }

  private static void printEncryptedArr(char[][] encryptedCharArr, int length) {
    StringBuilder output = new StringBuilder();

    for (int j = 0; j < encryptedCharArr[0].length; j++) {
      int i = 0;
      for (; i < encryptedCharArr.length; i++) {
        if (encryptedCharArr[i][j] == '\0' || encryptedCharArr[i][j] == ' ') {
          continue;
        }else {
          output.append(encryptedCharArr[i][j]);
        }
      }
      output.append(" ");
    }

    System.out.print(output.toString().trim());
  }

  // fto ehg ee dd
  public static char[][] encryptStr(String str) {
    double strLenghtSqrt = Math.sqrt(str.length());
    int rows = (int) Math.floor(strLenghtSqrt);
    int clms = (int) Math.ceil(strLenghtSqrt);
    if (rows * clms < str.length()) {
      rows = rows + 1;
    }

    char[][] encryptedChrArr = new char[rows][clms];

    for (int i = 0; i < encryptedChrArr.length; i++) {
      for (int j = 0; j < encryptedChrArr[i].length; j++) {
        if (i * encryptedChrArr[i].length + j < str.length()) {
          encryptedChrArr[i][j] = str.charAt(i * encryptedChrArr[i].length + j);
        }
      }
    }

    return encryptedChrArr;
  }

}
