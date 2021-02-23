package org.examples.collections;

public class MyHeap {
	private int maxSize;
	private int currentSize = -1;
	private int[] elements;
	private boolean minHeap = true;

	public MyHeap(int maxSize, boolean minHeap) {
		this.maxSize = maxSize;
		this.elements = new int[this.maxSize];
		this.minHeap = minHeap;
	}

	private int parent(int index) {
		if (index == 0) {
			return index;
		}
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		int lChildIndex = 2 * index + 1;
		if (lChildIndex > currentSize) {
			return -1;
		}
		return lChildIndex;
	}

	private int rigtChild(int index) {
		int rChildIndex = 2 * index + 2;
		if (rChildIndex > currentSize) {
			return -1;
		}
		return rChildIndex;
	}

	public void insert(int elem) {
		elements[++currentSize] = elem;
		int elemIndex = currentSize;
		bubbleUp(elemIndex);
	}

	public int size() {
		if(currentSize == -1) {
			return 0;
		}
		return currentSize + 1;
	}

	private void bubbleUp(int elemIndex) {
		while (elemIndex > 0) {
			int elemParentIndex = parent(elemIndex);
			if ((minHeap && elements[elemIndex] < elements[elemParentIndex])
					|| (!minHeap && elements[elemIndex] > elements[elemParentIndex])) {
				int tempElem = elements[elemParentIndex];
				elements[elemParentIndex] = elements[elemIndex];
				elements[elemIndex] = tempElem;
				elemIndex = elemParentIndex;
			} else {
				break;
			}
		}
	}

	public int remove() {
		if (currentSize == -1) {
			// it is empty no element to return
			return -1;
		} else {
			int elementToReturn = elements[0];
			elements[0] = elements[currentSize];
			elements[currentSize--] = 0;
			bubbleDown(0);
			return elementToReturn;
		}
	}

	public int peek() {
		if (currentSize == -1) {
			// it is empty no element to return
			return -1;
		} else {
			return elements[0];
		}
	}

	private void bubbleDown(int elemIndex) {

		while (elemIndex <= currentSize) {

			int lChildIndex = leftChild(elemIndex);
			int rChildIndex = rigtChild(elemIndex);

			if (lChildIndex == -1 && rChildIndex == -1) {
				break;
			}

			int childIndexToUse = 0;
			if (lChildIndex != -1 && rChildIndex != -1) {
				if ((minHeap && elements[lChildIndex] < elements[rChildIndex])
						|| (!minHeap && elements[lChildIndex] > elements[rChildIndex])) {
					childIndexToUse = lChildIndex;
				} else {
					childIndexToUse = rChildIndex;
				}
			} else if (lChildIndex != -1) {
				childIndexToUse = lChildIndex;
			} else {
				childIndexToUse = rChildIndex;
			}

			// if it is greater, swap with parent
			if ((minHeap && elements[elemIndex] > elements[childIndexToUse])
					|| (!minHeap && elements[elemIndex] < elements[childIndexToUse])) {
				int tempElem = elements[elemIndex];
				elements[elemIndex] = elements[childIndexToUse];
				elements[childIndexToUse] = tempElem;
			}

			elemIndex = childIndexToUse;
		}

	}

	public static void main(String[] args) {
		MyHeap minHeap = new MyHeap(15, true);
		minHeap.insert(4);
		minHeap.insert(4);
		minHeap.insert(8);
		minHeap.insert(9);
		minHeap.insert(4);
		minHeap.insert(11);
		minHeap.insert(13);
//		minHeap.insert(12);
//		minHeap.insert(9);
//		minHeap.insert(7);
//		minHeap.insert(10);
//		minHeap.insert(5);
		System.out.println(minHeap.remove());
	}

}
