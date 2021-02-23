package org.examples.collections;

public class Queue<E> {
  
  private E[] elements;
  private int front;
  private int rear;
  private int maxElems;

  public void add(E e) {
    if (rear > maxElems) {
      rear = 0;
    }
    elements[rear++] = e;
  }

  public E remove() {
    E elemToRemove = elements[front];
    elements[front++] = null;
    if (front == maxElems) {
      front = 0;
    }
    return elemToRemove;
  }

  public boolean isEmpty() {
    return false;
  }
  
}
