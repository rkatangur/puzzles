package org.examples.collections;

public class Heap<E extends Comparable<E>> {
  private int maxSize;
  private int currentSize;
  private E[] elements;

  public boolean insert(E element) {
    if (currentSize == maxSize) {
      return false;
    }
    elements[currentSize++] = element;
    trickleUp();
    return true;
  }

  private void trickleUp() {
    int index = currentSize - 1;
    int parentIndex = (index - 1) / 2;

    E bottom = elements[parentIndex];

    while (index > 0 && elements[parentIndex].compareTo(bottom) <= -1) {
      elements[index] = elements[parentIndex];
      index = parentIndex;
      parentIndex = (index - 1) / 2;
    }

    elements[index] = bottom;
  }


  public E remove() {
    E eToRemove = elements[0];
    elements[0] = elements[--currentSize];
    trickleDown();
    return eToRemove;
  }

  private void trickleDown() {

    int currIdx = 0;
    E elemToTrickleDown = elements[currIdx];

    while (currIdx < currentSize / 2) {
      int child1Idx = 2 * currIdx + 1;
      int child2Idx = child1Idx + 1;

      if (child2Idx < currentSize && (elements[currIdx].compareTo(elements[child1Idx]) < 0
          || elements[currIdx].compareTo(elements[child2Idx]) < 0)) {

        if (elements[child1Idx].compareTo(elements[child2Idx]) < 0) {
          elements[currIdx] = elements[child2Idx];
          currIdx = child2Idx;
        } else {
          elements[currIdx] = elements[child1Idx];
          currIdx = child1Idx;
        }
      } else {
        break;
      }
    }

    elements[currIdx] = elemToTrickleDown;
  }

}

