package org.examples.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Vector2D {

	LinkedList<Iterator<Integer>> iteratorsList = new LinkedList<Iterator<Integer>>();

	public Vector2D(int[][] vec) {

		for (int i = 0; i < vec.length; i++) {
			if (vec[i].length > 0) {
				List<Integer> listUsingJava8 = Arrays.stream(vec[i]).boxed().collect(Collectors.toList());
				iteratorsList.add(listUsingJava8.iterator());
			}
		}
	}

	public int next() {
		Iterator<Integer> iteToProcess = iteratorsList.peek();
		while (iteToProcess != null) {
			if (!iteToProcess.hasNext()) {
				iteratorsList.poll();
				iteToProcess = iteratorsList.peek();
			} else {
				break;
			}
		}

		if (iteToProcess != null && iteToProcess.hasNext()) {
			int valToReturn = iteToProcess.next();
			if (!iteToProcess.hasNext()) {
				iteratorsList.poll();
			}
			return valToReturn;
		} else {
			return -1;
		}

	}

	public boolean hasNext() {
		if (iteratorsList.isEmpty()) {
			return false;
		} else {
			return iteratorsList.peek().hasNext();
		}
	}
}