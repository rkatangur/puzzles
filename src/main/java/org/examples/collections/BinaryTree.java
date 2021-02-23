package org.examples.collections;

public class BinaryTree<E extends Comparable<E>> {

  private Node<E> rootNode;

  public void insert(E val) {
    Node<E> newNode = new Node<E>(val);
    if (rootNode == null) {
      rootNode = newNode;
    } else {
      Node<E> current = rootNode;
      while (true) {
        Node<E> currNLeftChild = current.leftChild;
        Node<E> currNRightChild = current.rightChild;
        if (current.val.compareTo(val) <= 0) {
          if (currNLeftChild == null) {
            currNLeftChild = newNode;
            current.leftChild = currNLeftChild;
            break;
          } else {
            current = currNLeftChild;
          }
        } else {
          if (currNRightChild == null) {
            currNRightChild = newNode;
            current.rightChild = currNRightChild;
            break;
          } else {
            current = currNRightChild;
          }
        }
      }
    }
  }

  public void delete(E val) {
    if (rootNode == null) {
      return;
    } else {

      Node<E> parent = rootNode;
      Node<E> current = rootNode;
      Node<E> nodeToDel = null;

      boolean isLeftChild = false;
      boolean isRightChild = false;

      while (!current.val.equals(val)) {
        parent = current;
        if (val.compareTo(current.val) < 0) {
          current = current.leftChild;
          isLeftChild = true;
        } else if (val.compareTo(current.val) >= 0) {
          current = current.rightChild;
          isRightChild = true;
        }

        // didn't find anything
        if (current == null) {
          return;
        }
      }

      nodeToDel = current;

      // found the current
      // If the current is the leaf node.
      if (nodeToDel.leftChild == null && nodeToDel.rightChild == null) {
        if (isLeftChild) {
          parent.leftChild = null;
        } else if (isRightChild) {
          parent.rightChild = null;
        }
      } else if (nodeToDel.leftChild != null && nodeToDel.rightChild != null) {
        // both the childs are not null.
        // find in order sucessor and remove it.
        Node<E> sucessorParent = nodeToDel;
        Node<E> sucessor = nodeToDel;
        Node<E> incurrent = sucessor.rightChild;

        while (incurrent != null) {
          sucessorParent = sucessor;
          sucessor = incurrent;
          incurrent = incurrent.leftChild;
        }

        if (sucessor != nodeToDel.rightChild) {
          sucessorParent.leftChild = sucessor.rightChild;
          sucessor.rightChild = nodeToDel.rightChild;
        } else if (sucessor != nodeToDel.rightChild) {
          sucessorParent.leftChild = sucessor.rightChild;
          sucessor.rightChild = nodeToDel.rightChild;
        }

        sucessor.leftChild = nodeToDel.leftChild;
        if (isLeftChild) {
          parent.leftChild = sucessor;
        } else {
          parent.rightChild = sucessor;
        }

      } else {
        // only child available for the deleted node.
        // left child is not null.
        Node<E> nodeToAttach = null;
        if (nodeToDel.leftChild != null) {
          nodeToAttach = nodeToDel.leftChild;
        }
        // right child is not null.
        else if (nodeToDel.rightChild != null) {
          nodeToAttach = nodeToDel.rightChild;
        }

        if (isLeftChild) {
          parent.leftChild = nodeToAttach;
        } else {
          parent.rightChild = nodeToAttach;
        }
      }
    }
  }



  private static class Node<E extends Comparable<E>> {
    private E val; // reference to person object

    public Node(E val) {
      this.val = val;
    }

    private Node<E> leftChild; // this node’s left child
    private Node<E> rightChild; // this node’s right child
  }

}
