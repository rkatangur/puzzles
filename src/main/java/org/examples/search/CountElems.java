package org.examples.search;

public class CountElems {

	public static void main(String[] args) {
		CountElems solver = new CountElems();
		int leftPos = solver.binarySearch(5, new int[] { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 }, true);
		System.out.println("leftPos for 5 " + leftPos);

		int leftPosOf6 = solver.binarySearch(6, new int[] { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 }, true);
		System.out.println("leftPos of 6 " + leftPosOf6);

		// 1, 4, 5, 5, 6
		// 0, 1, 2, 3, 4
		int leftPosOf5 = solver.binarySearch(5, new int[] { 1, 4, 5, 5, 6 }, true);
		System.out.println("leftPos of 5 " + leftPosOf5);

		int leftPosOf5WithDups = solver.binarySearch(5, new int[] { 1, 4, 5, 5, 5, 5, 6 }, true);
		System.out.println("leftPosOf5WithDups of 5 " + leftPosOf5WithDups);

		int leftPosOf2 = solver.binarySearch(2, new int[] { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 }, true);
		System.out.println("leftPos of 2 " + leftPosOf2);

		// elem doesn't exist should return -1
		int leftPosOf4 = solver.binarySearch(4, new int[] { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 }, true);
		System.out.println("leftPos of 4 " + leftPosOf4);

		int leftPosOf9 = solver.binarySearch(9, new int[] { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 }, true);
		System.out.println("leftPos of 9 " + leftPosOf9);

		int numOfElems9 = solver.countElems(9, new int[] { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 });
		System.out.println("countElems(9) " + numOfElems9);

		int numOfElems5 = solver.countElems(5, new int[] { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 });
		System.out.println("countElems(5) " + numOfElems5);

		// elem not exists
		int numOfElems4 = solver.countElems(4, new int[] { 2, 5, 5, 5, 6, 6, 8, 9, 9, 9 });
		System.out.println("countElems(4) " + numOfElems4);
	}

	int countElems(int elem, int[] array) {
		int numOfElems = 0;
		int elemLeftPos = binarySearch(elem, array, true);

		if (elemLeftPos != -1) {
			int lastElem = array[array.length - 1];
			int rightmostPos = -1;

			if (elem == lastElem) {
				rightmostPos = array.length;
			} else {
				int nextElem = elem + 1;
				while (nextElem <= lastElem) {
					rightmostPos = binarySearch(nextElem, array, true);
					if (rightmostPos != -1) {
						break;
					} else {
						nextElem++;
					}
				}
			}

			return (rightmostPos - elemLeftPos);
		}

		return numOfElems;
	}

	// 1, 4, 5, 5, 6
	// 0, 1, 2, 3, 4

	// 1, 4, 5, 5, 6, 6
	int binarySearch(int elem, int[] array, boolean findLeftMost) {
		int leftPos = 0;
		int rightPos = array.length - 1;
		int mid = 0;
		int result = -1;

		while (leftPos <= rightPos) {
			mid = leftPos + (rightPos - leftPos) / 2;
			if (elem == array[mid]) {
				result = mid;
				// elem is found;
				if (findLeftMost) {
					rightPos = mid - 1;
				}
			} else {
				if (elem < array[mid]) {
					rightPos = mid - 1;
				} else if (elem > array[mid]) {
					leftPos = mid + 1;
				}
			}
		}

		return result;
	}

}
