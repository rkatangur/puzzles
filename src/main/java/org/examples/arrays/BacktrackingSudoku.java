package org.examples.arrays;

/**
 * 
 * int[][] board = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0
 * }, { 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0,
 * 0, 4, 5, 7, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6,
 * 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 }, { 0, 9, 0, 0, 0, 0, 4, 0, 0 } };
 *
 * 
 * If there's no violation of constraints, the algorithm moves to the next cell,
 * fills in all potential solutions and repeats all checks. If there's a
 * violation, then it increments the cell value. Once, the value of the cell
 * reaches 9, and there is still violation then the algorithm moves back to the
 * previous cell and increases the value of that cell. It tries all possible
 * solutions.
 * 
 * @author rkata
 *
 */
public class BacktrackingSudoku {

	private static final int BOARD_SIZE = 9;
	private static final int SUBSECTION_SIZE = 3;
	private static final int BOARD_START_INDEX = 0;

	private static final int NO_VALUE = 0;
	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 9;

	private static int[][] board = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
			{ 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
			{ 0, 9, 0, 0, 0, 0, 4, 0, 0 } };

	public static void main(String[] args) {
		solve(board);
		ArraysUtil.printMatrix(board);
	}

	private static boolean solve(int[][] board) {
		for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
			for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
				if (board[row][column] == NO_VALUE) {
					// fill it up. // we try possible numbers
					for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
						if (isValid(board, row, column, k)) {
							// number ok. it respects sudoku constraints
							board[row][column] = k;
							// we start backtracking recursively
							if (solve(board)) {
								return true;
							} else {
								// if not a solution, we empty the cell and we continue
								board[row][column] = NO_VALUE;
							}
						}
					}
					return false; // we return false
				}
			}
		}
		return true;// sudoku solved
	}

	private static boolean isValid(int[][] board, int row, int column, int number) {
		return (rowConstraint(board, row, column, number) && columnConstraint(board, row, column, number)
				&& subsectionConstraint(board, row, column, number));
	}

	private static boolean subsectionConstraint(int[][] board2, int row, int column, int number) {
		int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
		int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

		int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
		int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

		for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
			for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
				if (board2[row][column] == number)
					return false;
			}
		}
		return true;
	}

	private static boolean columnConstraint(int[][] board, int row, int column, int number) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] == number) {
				return false;
			}
		}
		return true;
	}

	private static boolean rowConstraint(int[][] board, int row, int column, int number) {
		int[] boardElems = board[row];
		for (int i = 0; i < boardElems.length; i++) {
			if (boardElems[i] == number) {
				return false;
			}
		}
		return true;
	}

}
