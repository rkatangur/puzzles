package org.examples.sort;

/**
 * 
 * Bubble Sort
 * 
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 * swapping the adjacent elements if they are in wrong order. Example: First
 * Pass: ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two
 * elements, and swaps since 5 > 1. ( 1 5 4 2 8 ) –> ( 1 4 5 2 8 ), Swap since 5
 * > 4 ( 1 4 5 2 8 ) –> ( 1 4 2 5 8 ), Swap since 5 > 2 ( 1 4 2 5 8 ) –> ( 1 4 2
 * 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does
 * not swap them.
 * 
 * Second Pass: ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ) ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ),
 * Swap since 4 > 2 ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) ( 1 2 4 5 8 ) –> ( 1 2 4 5 8
 * ) Now, the array is already sorted, but our algorithm does not know if it is
 * completed. The algorithm needs one whole pass without any swap to know it is
 * sorted.
 * 
 * Third Pass: ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) ( 1
 * 2 4 5 8 ) –> ( 1 2 4 5 8 ) ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * 
 * @author rkata
 *
 */

public class BubbleSort {

	public static void bubbleSort2(int[] numArray) {
		for (int i = 0; i < numArray.length-1; i++) {
			//always the highest element will be pushed to the last position that is the reason 
			//j would try till (n.length - i-1) .
			for (int j = 0; j < numArray.length - i -1; j++) {
				if (numArray[j] > numArray[j + 1]) {
					int temp = numArray[j];
					numArray[j] = numArray[j + 1];
					numArray[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
//		int[] numArray = new int[] { 9, 4, 6, 3, 7, 2 };
		int[] numArray = new int[] { 64, 34, 25, 12, 22, 11, 90};
		bubbleSort2(numArray);
		for (int i : numArray) {
			System.out.print(i + ",");
		}
	}

//  public static void bubbleSort(int[] numArray) {
//    int endIndex = numArray.length;
//    for (int i = 0; i < endIndex;) {
//      for (int j = 1; j < endIndex; j++) {
//        if (numArray[j - 1] > numArray[j]) {
//          int tmp = numArray[j - 1];
//          numArray[j - 1] = numArray[j];
//          numArray[j] = tmp;
//        }
//      }
//      endIndex = endIndex - 1;
//      System.out.println("endIndex " + endIndex);
//    }
//  }
//
//  public static void bubbleSort1(int[] numArray) {
//    for (int endIndex = numArray.length - 1; endIndex > 0; endIndex--) {
//      for (int j = 0; j < endIndex; j++) {
//        if (numArray[j] > numArray[j + 1]) {
//          int tmp = numArray[j];
//          numArray[j] = numArray[j + 1];
//          numArray[j + 1] = tmp;
//        }
//      }
//    }
//  }

}
