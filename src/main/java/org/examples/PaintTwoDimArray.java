package org.examples;

public class PaintTwoDimArray {

  public static void main(String[] args) {
    int[][] imgData = new int[5][7];
    for (int i = 0; i < imgData.length; i++) {
      for (int j = 0; j < imgData[0].length; j++) {
        if (i == 0 || j == 0) {
          imgData[i][j] = 1;
        }
      }
    }
    paint(imgData, 3, 5);
  }

  private static void paint(int[][] imgData, int i, int j) {

    if (i < 0 || i >= imgData.length || j >= imgData[0].length || j < 0 || imgData[i][j] == 1) {
      return;
    }
    imgData[i][j] = 1;
    paint(imgData, i, j + 1);
    paint(imgData, i, j - 1);
    paint(imgData, i + 1, j);
    paint(imgData, i - 1, j);
  }
}
