package org.examples.collections;

import java.util.EmptyStackException;

public class Stack<E> {

  private Object[] elements;
  private int maxElements = 20;
  private int top = -1;

  public Stack() {
    elements = new Object[maxElements];
  }


  public Stack(int numElements) {
    elements = new Object[numElements];
  }

  public void push(E elem) {
    elements[++top] = elem;
  }

  public E pop() {
    if (top == -1) {
      throw new EmptyStackException();
    }
    return (E) elements[top--];
  }

  public E peek() {
    if (top == -1) {
      throw new EmptyStackException();
    }
    return (E) elements[top];
  }

  public boolean isEmpty() {
    return top == -1;
  }

}
