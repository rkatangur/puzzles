package org.examples.arrays.traversal;

import java.util.LinkedList;
import java.util.Queue;

import org.examples.arrays.ArraysUtil;

public class WallsAndGates {

	public static void main(String[] args) {

		int[][] rooms = new int[][] { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };

		WallsAndGates solver = new WallsAndGates();
		solver.wallsAndGates(rooms);
		ArraysUtil.printMatrix(rooms);
	}

	public void wallsAndGates(int[][] rooms) {
		LinkedList<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				// it is a gate
				if (rooms[i][j] == 0) {
					wallsAndGatesHelper(i, j, 0, rooms, queue);
				}
			}
		}
	}

	private void wallsAndGatesHelper(int i, int j, int distance, int[][] rooms, Queue<Integer> queue) {
		fill(i, j, distance, rooms, queue);

		int numOfRows = rooms.length;
		int numOfColumns = rooms[0].length;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				Integer cord = queue.poll();
				int x = cord / numOfColumns;
				int y = cord % numOfColumns;

				fill(x - 1, y, distance + 1, rooms, queue);
				fill(x + 1, y, distance + 1, rooms, queue);
				fill(x, y - 1, distance + 1, rooms, queue);
				fill(x, y + 1, distance + 1, rooms, queue);
			}
			distance++;
		}
	}

	private void fill(int row, int col, int distance, int[][] rooms, Queue<Integer> queue) {

		int numOfRows = rooms.length;
		int numOfColumns = rooms[0].length;

		if (row < 0 || row >= rooms.length || col < 0 || col >= numOfColumns) {
			return;
		}

		if (rooms[row][col] == -1) {
			return;
		}

		if (rooms[row][col] == -1) {
			return;
		}

		if (distance > rooms[row][col]) {
			return;
		}

		if (distance < rooms[row][col]) {
			rooms[row][col] = distance;
		}

		int cord = row * numOfColumns + col;
		queue.offer(cord);
	}
}
