package org.examples.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class PrisionCellsAfterNDays {

	public int[] prisonAfterNDays(int[] cells, int n) {

		HashSet<String> uniqCellStrs = new HashSet<>();
		boolean hasCycle = false;
		for (int i = 0; i < n; i++) {
			int[] cells2 = changeCells(cells);
			if (!uniqCellStrs.contains(Arrays.toString(cells2))) {
				uniqCellStrs.add(Arrays.toString(cells2));
			} else {
				hasCycle = true;
				break;
			}
			cells = cells2;
		}

		System.out.println("hasCycle " + hasCycle + ", uniqCellStrs " + uniqCellStrs.size());

		if (hasCycle) {
			n = n % uniqCellStrs.size();
			while (n > 0) {
				cells = changeCells(cells);
				n--;
			}
		}
		return cells;
	}

	public int[] changeCells(int[] cells) {
		int[] cells2 = new int[cells.length];
		for (int j = 1; j < cells.length - 1; j++) {
			if (cells[j - 1] == cells[j + 1]) {
				cells2[j] = 1;
			} else {
				cells2[j] = 0;
			}
		}
		return cells2;
	}

}
