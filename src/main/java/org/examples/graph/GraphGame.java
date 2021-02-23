package org.examples.graph;

/*
 * Give you a map as 0,1 matrix (1 means blocked, 0 means not blocked) a start point x and end point y.
 * Determine if you can start from x and end at y.
 * Move rule:
 * 1. You can only fo up, left, down or right.
 * 2. For each move, you have to all the way until you hit the blocker(value 1) or you hit map boundary.
 * Example:
 * 0 0 0 1 0 0
 * 0 0 0 0 0 0
 * 1 0 0 0 1 0
 * 0 0 0 0 0 0
 * 0 0 0 1 0 1
 * 
 * 
 * (0, 0) (0,2)--->true
 * (0, 0) (0,1)--->false
 * start: (0,0) end: (4,2)->true
 * start: (0,0) end: (2,2)->false
 * 
 */

public class GraphGame {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 1 } };

		GraphGame solver = new GraphGame();
		System.out.println(solver.canStop(arr, new int[] { 0, 0 }, new int[] { 0, 2 }));
		System.out.println(solver.canStop(arr, new int[] { 0, 0 }, new int[] { 0, 4 }));// --true
		System.out.println(solver.canStop(arr, new int[] { 0, 0 }, new int[] { 0, 5 }));// --true
		System.out.println(solver.canStop(arr, new int[] { 0, 0 }, new int[] { 0, 1 }));
		System.out.println(solver.canStop(arr, new int[] { 0, 0 }, new int[] { 4, 2 }));// True
		System.out.println(solver.canStop(arr, new int[] { 0, 0 }, new int[] { 2, 2 }));// False
	}

	public boolean canStop(int[][] arr, int[] sttpoint, int[] endpoint) {
		int a = sttpoint[0];
		int b = sttpoint[1];
		int[][] stoppedPositions = new int[arr.length][arr[0].length];
		return canStop(arr, a, b, endpoint, 1, stoppedPositions) || canStop(arr, a, b, endpoint, 2, stoppedPositions)
				|| canStop(arr, a, b, endpoint, 3, stoppedPositions)
				|| canStop(arr, a, b, endpoint, 4, stoppedPositions);
	}

	/**
	 * 
	 * Operation 1 = moving to right 2 = moving to left 3 = moving up 4 = moving
	 * down
	 * 
	 * @param arr
	 * @param rowPos
	 * @param colPos
	 * @param endpoint
	 * @param operation
	 * @return
	 */
	public boolean canStop(int[][] arr, int rowPos, int colPos, int[] endpoint, int operation,
			int[][] stoppedPositions) {

		if (rowPos < 0 || colPos < 0 || rowPos >= arr.length || colPos >= arr[0].length || arr[rowPos][colPos] == 1) {
			return false;
		}

		// moving to right
		if (operation == 1) {
			boolean canStop = false;
			if (colPos + 1 >= arr[0].length || arr[rowPos][colPos + 1] == 1) {
				canStop = true;
			}

			if (canStop && stoppedPositions[rowPos][colPos] == 0) {
				if (reachedEndPos(rowPos, colPos, endpoint)) {
					return true;
				}

				stoppedPositions[rowPos][colPos] = 1;
				System.out.println("Stopped at rowPos " + rowPos + ", colPos " + colPos);

				return canStop(arr, rowPos - 1, colPos, endpoint, 3, stoppedPositions)
						|| canStop(arr, rowPos + 1, colPos, endpoint, 4, stoppedPositions);
			} else {
				return canStop(arr, rowPos, colPos + 1, endpoint, operation, stoppedPositions);
			}
		}

		// moving left
		if (operation == 2) {

			boolean canStop = false;
			if (colPos - 1 < 0 || arr[rowPos][colPos - 1] == 1) {
				canStop = true;
			}

			if (canStop && stoppedPositions[rowPos][colPos] == 0) {
				if (reachedEndPos(rowPos, colPos, endpoint)) {
					return true;
				}

				stoppedPositions[rowPos][colPos] = 1;
				System.out.println("Stopped at rowPos " + rowPos + ", colPos " + colPos);
				return canStop(arr, rowPos - 1, colPos, endpoint, 3, stoppedPositions)
						|| canStop(arr, rowPos + 1, colPos, endpoint, 4, stoppedPositions);
			} else {
				return canStop(arr, rowPos, colPos - 1, endpoint, operation, stoppedPositions);
			}
		}

		// 3 = moving up
		if (operation == 3) {
			boolean canStop = false;
			if (rowPos - 1 < 0 || arr[rowPos - 1][colPos] == 1) {
				canStop = true;
			}

			if (canStop && stoppedPositions[rowPos][colPos] == 0) {
				if (reachedEndPos(rowPos, colPos, endpoint)) {
					return true;
				}

				stoppedPositions[rowPos][colPos] = 1;
				System.out.println("Stopped at rowPos " + rowPos + ", colPos " + colPos);
				return canStop(arr, rowPos, colPos - 1, endpoint, 2, stoppedPositions)
						|| canStop(arr, rowPos, colPos + 1, endpoint, 1, stoppedPositions);
			} else {
				return canStop(arr, rowPos - 1, colPos, endpoint, operation, stoppedPositions);
			}
		}

		// 4 = moving down
		if (operation == 4) {
			boolean canStop = false;
			if (rowPos + 1 >= arr.length || arr[rowPos + 1][colPos] == 1) {
				canStop = true;
			}

			if (canStop && stoppedPositions[rowPos][colPos] == 0) {
				if (reachedEndPos(rowPos, colPos, endpoint)) {
					return true;
				}

				stoppedPositions[rowPos][colPos] = 1;
				System.out.println("Stopped at rowPos " + rowPos + ", colPos " + colPos);
				return canStop(arr, rowPos, colPos - 1, endpoint, 2, stoppedPositions)
						|| canStop(arr, rowPos, colPos + 1, endpoint, 1, stoppedPositions);
			} else {
				return canStop(arr, rowPos + 1, colPos, endpoint, operation, stoppedPositions);
			}
		}

		return false;
	}

	private boolean reachedEndPos(int rowPos, int colPos, int[] endpoint) {
		if (rowPos == endpoint[0] && colPos == endpoint[1]) {
			System.out.println("Reached end - rowPos " + rowPos + ", colPos " + colPos);
			return true;
		}
		return false;
	}

}
