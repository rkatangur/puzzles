package org.examples.arrays;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class CrossWord2 {
  private static final int SIZE = 10;
  private static final char FILL = '-';
  private static final char NO_FILL = '+';

  private static void print(char[][] grid) {
    for (char[] row : grid) {
      for (int i = 0; i < SIZE; i++) {
        System.out.print(row[i]);
      }
      System.out.print("\n");
    }
  }

  private static int countOpen(char[][] grid, int row, int col, boolean down) {
    int rowAdd = (down) ? 1 : 0;
    int colAdd = (down) ? 0 : 1;
    int count = 0;
    while (true) {
      if (row >= SIZE || col >= SIZE || grid[row][col] != FILL) {
        break;
      }
      count += 1;
      row += rowAdd;
      col += colAdd;
    }
    return count;
  }

  private static boolean addWord(char[][] grid, String word, int row, int col, int down) {
    int rowAdd = (down == 1) ? 1 : 0;
    int colAdd = (down == 1) ? 0 : 1;
    int wordIdx = 0;
    for (int i = 0; i < word.length(); i++, row = row + rowAdd, col = col + colAdd) {
      if (grid[row][col] == NO_FILL) {
        return false;
      }
      if (grid[row][col] != FILL && grid[row][col] != word.charAt(wordIdx)) {
        return false;
      }
      grid[row][col] = word.charAt(wordIdx);
      wordIdx += 1;
    }
    return true;
  }

  private static int isDownStart(char[][] grid, int row, int col) {
    if (grid[row][col] == NO_FILL) {
      return 0;
    }
    if (row > 0 && grid[row - 1][col] == FILL) {
      return 0;
    }
    int count = countOpen(grid, row, col, true);
    return (count > 1) ? count : 0;
  }

  private static int isAcrossStart(char[][] grid, int row, int col) {
    if (grid[row][col] == NO_FILL) {
      return 0;
    }
    if (col > 0 && grid[row][col - 1] == FILL) {
      return 0;
    }
    int count = countOpen(grid, row, col, false);
    if (count <= 1) {
      if (row > 0 && grid[row - 1][col] == FILL) {
        return 0;
      }
      if (row + 1 < SIZE && grid[row + 1][col] == FILL) {
        return 0;
      }
    }
    return count;
  }


  private static ArrayList<int[]> findPositions(char[][] grid) {
    ArrayList<int[]> output = new ArrayList<int[]>();
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        int acrossCount = isAcrossStart(grid, i, j);
        int downCount = isDownStart(grid, i, j);
        if (downCount > 0) {
          output.add(new int[] {i, j, downCount, 1});
        }
        if (acrossCount > 0) {
          output.add(new int[] {i, j, acrossCount, 0});
        }
      }
    }
    return output;
  }

  private static char[][] copy(char[][] grid) {
    char[][] output = new char[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      output[i] = grid[i].clone();
    }
    return output;
  }

  private static char[][] helper(char[][] grid, String[] words, int wordIdx, ArrayList<int[]> pos) {
    if (wordIdx == words.length) {
      return grid;
    }
    String word = words[wordIdx];
    for (int[] p : pos) {
      if (p[2] != word.length()) {
        continue;
      }
      char[][] newGrid = copy(grid);
      if (addWord(newGrid, word, p[0], p[1], p[3])) {
        char[][] solution = helper(newGrid, words, wordIdx + 1, pos);
        if (solution != null) {
          return solution;
        }
      }
    }
    return null;
  }

  private static char[][] solve(char[][] grid, String[] words) {
    return helper(grid, words, 0, findPositions(grid));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Pattern p = Pattern.compile("[+-]");
    char[][] grid = new char[SIZE][SIZE];

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        grid[i][j] = (scanner.findWithinHorizon(p, 0)).charAt(0);
      }
    }
    scanner.nextLine();
    String[] words = (scanner.nextLine()).split(";");
    CrossWord2.print(CrossWord2.solve(grid, words));
  }
}
