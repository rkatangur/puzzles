package org.examples.arrays.traversal;

public class WordSearch {

	/**
	 * {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}},
	 * }[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		WordSearch solver = new WordSearch();
		System.out.println(solver.exist(board, word));
	}

	public boolean exist(char[][] board, String word) {
		char[] wordChars = word.toCharArray();
		int charIndex = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (exist1(board, i, j, wordChars, charIndex, null)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean exist1(char[][] board, int row, int col, char[] wordChars, int charIndex, int[] visitedNodes) {
		if (row >= board.length || col >= board[0].length || row < 0 || col < 0) {
			return false;
		}

		if (board[row][col] == wordChars[charIndex]) {
			if (charIndex + 1 >= wordChars.length) {
				return true;
			}

			board[row][col] = '*';
			if (exist1(board, row + 1, col, wordChars, charIndex + 1, visitedNodes)
					|| exist1(board, row, col + 1, wordChars, charIndex + 1, visitedNodes)
					|| exist1(board, row, col - 1, wordChars, charIndex + 1, visitedNodes)
					|| exist1(board, row - 1, col, wordChars, charIndex + 1, visitedNodes)) {
				return true;
			} else {
				board[row][col] = wordChars[charIndex];
			}
		}
		return false;
	}

}
