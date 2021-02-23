package org.examples.collections;

public class LinkedList<D> {
  private Link<D> first;

  public void insertLast(D data) {
    if (first == null) {
      first = new Link<D>(data);
    } else {
      Link<D> link = first;
      while (link.nextLink != null) {
        link = link.nextLink;
      }

      link.nextLink = new Link<D>(data);
    }
  }

  public void insertFist(D data) {
    Link<D> newLink = new Link<D>(data);
    if (first == null) {
      first = newLink;
    } else {
      newLink.nextLink = first;
      first = newLink;
    }
  }

  private static class Link<E> {
    private final E data;
    private Link<E> nextLink;

    public Link(E data) {
      this.data = data;
    }

    public Link(E data, Link<E> nextLink) {
      this.data = data;
      this.nextLink = nextLink;
    }

    public E getData() {
      return data;
    }

    public Link getNextLink() {
      return nextLink;
    }

  }

}
