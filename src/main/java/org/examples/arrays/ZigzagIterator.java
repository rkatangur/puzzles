package org.examples.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 281. Zigzag Iterator
 * 
 * 
 * Input: v1 = [1,2], v2 = [3,4,5,6] Output: [1,3,2,4,5,6] Explanation: By
 * calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,3,2,4,5,6].
 * 
 * @author rkata
 *
 */
public class ZigzagIterator {

	LinkedList<Iterator<Integer>> iteratorsList = new LinkedList<Iterator<Integer>>();

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		if (!v1.isEmpty())
			iteratorsList.add(v1.iterator());

		if (!v2.isEmpty())
			iteratorsList.add(v2.iterator());
	}

	public int next() {
		int valToReturn = -1;
		Iterator<Integer> iteratorToProcess = iteratorsList.poll();
		while (iteratorToProcess != null) {
			if (iteratorToProcess.hasNext()) {
				valToReturn = iteratorToProcess.next();
				break;
			} else {
				iteratorToProcess = iteratorsList.poll();
			}
		}

		if (iteratorToProcess != null && iteratorToProcess.hasNext()) {
			iteratorsList.add(iteratorToProcess);
		}
		return valToReturn;
	}

	public boolean hasNext() {
		if (iteratorsList.isEmpty()) {
			return false;
		} else {
			Iterator<Integer> iteratorToProcess = iteratorsList.peek();
			return iteratorToProcess.hasNext();
		}
	}

	public static void main(String[] args) {
		ZigzagIterator solver = new ZigzagIterator(Arrays.asList(1, 2), Arrays.asList(3, 4, 5, 6));
//		ZigzagIterator solver = new ZigzagIterator(Arrays.asList(), Arrays.asList(1));
		while (solver.hasNext()) {
			System.out.println(solver.next());
		}
	}
}
