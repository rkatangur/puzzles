package org.examples.arrays;

public class RightRotation {

	public static void main(String[] args) {
		char[] carr = new char[] { 'c', 'o', 'f', 'f', 'e', 'e' };
//		rotateArray(carr, 3);
		rightRotation(carr, 3);

		// Rotate an array of n elements to the right by k steps.
		// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
		// [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotateArray(arr, 3);
	}

	public static void rotateArray(char[] carr, int numOfRotations) {
		if (numOfRotations == 0)
			return;

		char tempChar = carr[0];
		for (int i = 1; i < carr.length; i++) {
			char charAtNextIdex = carr[i];
			carr[i] = tempChar;
			tempChar = charAtNextIdex;
		}
		carr[0] = tempChar;

		ArraysUtil.displayWord(carr);
		rotateArray(carr, --numOfRotations);
		return;
	}

	static char[] rightRotation(char[] a, int d) {
		if (d <= 0) {
			return a;
		}

		char elemAtLastIndex = a[a.length - 1];
		for (int i = a.length - 1; i > 0; i--) {
			a[i] = a[i - 1];
		}
		a[0] = elemAtLastIndex;
		d--;
		ArraysUtil.displayWord(a);
		return rightRotation(a, d);
	}

	// Bubble the elements from the back...
	public static void rotateArray(int[] arr, int k) {
		if (k > arr.length)
			k = k % arr.length;

		for (int i = 0; i < k; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
			ArraysUtil.printIntArr(arr);
		}

	}

}
