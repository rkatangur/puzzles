package org.examples.arrays;

public class NextPermutation {

	public static void main(String[] args) {
		NextPermutation solver = new NextPermutation();
		int[] arr = new int[] { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
		solver.nextPermutation(arr);
		ArraysUtil.printIntArr(arr);

		int[] arr1 = new int[] { 4, 3, 2, 1 };
		solver.nextPermutation(arr1);
		ArraysUtil.printIntArr(arr1);

	}

	public void nextPermutation(int[] nums) {

		int indexOfI = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				indexOfI = i;
				break;
			}
		}

		System.out.println("indexOfI " + indexOfI);
		if (indexOfI > 0) {
			int firstNumIndexGtThanI = indexOfI;
			for (int j = nums.length - 1; j >= indexOfI; j--) {
				if (nums[j] > nums[indexOfI - 1]) {
					firstNumIndexGtThanI = j;
					break;
				}
			}

			int tempNum = nums[indexOfI - 1];
			nums[indexOfI - 1] = nums[firstNumIndexGtThanI];
			nums[firstNumIndexGtThanI] = tempNum;
		}

		// reverse between the indexOfI to length of the arr
		int startIndex = indexOfI;
		int endIndex = nums.length - 1;
		while (startIndex < endIndex) {
			int temp = nums[endIndex];
			nums[endIndex] = nums[startIndex];
			nums[startIndex] = temp;
			startIndex++;
			endIndex--;
		}

	}

	private void rotateLeft(int[] nums, int length) {
		while (length > 0) {
			int index = nums.length - 1;
			int temp = nums[index];
			while (index > 0) {
				nums[index] = nums[index - 1];
				index--;
			}
			nums[index] = temp;
			length--;
		}
	}
}
