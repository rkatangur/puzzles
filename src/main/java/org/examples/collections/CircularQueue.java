package org.examples.collections;

public class CircularQueue<E> {
  private E[] elements;
  private int front = 0;
  private int rear = 0;
  private int maxElements = 0;
  private boolean full = false;

  @SuppressWarnings("unchecked")
  public CircularQueue() {
    elements = (E[]) new Object[10];
    maxElements = 10;
  }

  @SuppressWarnings("unchecked")
  public CircularQueue(int initialCapacity) {
    maxElements = initialCapacity;
    elements = (E[]) new Object[maxElements];
  }

  public void add(E e) {
    if (size() == maxElements) {
      remove();
    }

    if (rear >= maxElements) {
      rear = 0;
    }

    elements[rear++] = e;

    if (rear == front) {
      full = true;
    }
  }

  private int size() {
    if (rear > front) {
      return rear - front;
    } else if (rear < front) {
      return maxElements - front + rear;
    } else {
      return full ? maxElements : (rear - front);
    }
  }

  public E remove() {
    E element = elements[front];

    if (front >= maxElements) {
      front = 0;
    }

    elements[front++] = null;

    full = false;
    return element;
  }

  public E get(int index) {
    int idx = (front + index) % maxElements;
    System.out.println("idx" + idx);
    return elements[idx];
  }

  // Write a method for the Queue class in the queue.java program (Listing 4.4) that
  // displays the contents of the queue. Note that this does not mean simply
  // displaying the contents of the underlying array. You should show the queue
  // contents from the first item inserted to the last, without indicating to the
  // viewer whether the sequence is broken by wrapping around the end of the
  // array. Be careful that one item and no items display properly, no matter where
  // front and rear are.

  public void printData() {
    int startIdx = front;
    while (true) {
      System.out.println(elements[startIdx++]);
      if (startIdx >= maxElements) {
        startIdx = 0;
      }
      if (startIdx == rear) {
        break;
      }
    }
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public static void main(String[] args) {
    CircularQueue<Integer> intList = new CircularQueue<>(5);
    intList.add(1);
    intList.add(2);
    intList.add(3);
    intList.add(4);
    System.out.println(intList.get(3));
    intList.remove();
    intList.remove();
    intList.remove();
    intList.printData();
    System.out.println("--------------");
    intList.add(5);
    intList.add(6);
    intList.add(7);
    intList.add(8);
    intList.printData();
  }

}
