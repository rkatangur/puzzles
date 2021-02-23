package org.examples.recursion;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class FindNumberInSortedArray {

	public static void main(String[] args) {
//	     ArrayList<String> strings = new ArrayList<String>();
//	     strings.add("Hello, World!");
//	     strings.add("Welcome to CoderPad.");
//	     strings.add("This pad is running Java " + Runtime.version().feature());

//	     for (String string : strings) {
//	       System.out.println(string);
//	     }

//		System.out.println(elementExists(new int[] { 1, 2, 4, 6, 9 }, 2));
//		System.out.println(elementExists(new int[] { 1, 2, 4, 6, 9 }, 5));
//
//		System.out.println(elementExists(new int[] { 9, 1, 2, 4, 6 }, 2));
//		System.out.println(elementExists(new int[] { 9, 1, 2, 4, 6 }, 5));
//
//		System.out.println(elementExists(new int[] { 6, 9, 1, 2, 4 }, 2));
//		System.out.println(elementExists(new int[] { 6, 9, 1, 2, 4 }, 5));
//
//		System.out.println(elementExists(new int[] { 4, 6, 9, 1, 2 }, 2));
//		System.out.println(elementExists(new int[] { 4, 6, 9, 1, 2 }, 5));

		// System.out.println(elementExists(new int[]{6, 9, 1, 2, 4}, 2));

//	     [6, 9, 1, 2, 4] and looking for 2

		FindNumberInSortedArray solver = new FindNumberInSortedArray();
//		System.out.println(solver.search(new int[] { 6, 9, 1, 2, 4 }, 2));
//		System.out.println(solver.search(new int[] { 6, 9, 1, 2, 4 }, 6));
//		System.out.println(solver.search(new int[] { 4,5,6,7,0,1,2 }, 0));

		System.out.println(solver.search(new int[] { 3, 1 }, 1));
	}

	public int search(int[] nums, int target) {
		int startPos = 0;
		int endPos = nums.length - 1;

		while (startPos <= endPos) {

			int mid = (startPos + endPos) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] >= nums[startPos]) {
				// numbers from the start to mid are sorted and the rotation or unsorted array
				// is
				// seen after mid.
				// search unsorted
				if (target >= nums[startPos] && target < nums[mid]) {
					// search sorted side. to the left of mid
					endPos = mid - 1;
				} else {
					// search unsorted side to the right of mid
					startPos = mid + 1;
				}

			} else {
//				nums[mid] < nums[startPos];

				if (target > nums[mid] && target <= nums[endPos]) {
					// search sorted side to the right of the mid.
					startPos = mid + 1;
				} else {
					// search the unsorted side to the left of the mid.
					endPos = mid - 1;
				}
			}
		}

		return -1;
	}

	private static boolean elementExists(int[] numbers, int element) {
		int startPos = 0;
		int endPos = numbers.length - 1;

		boolean elementFound = elementExistsHelper(numbers, startPos, endPos, element);
		return elementFound;
	}

	/**
	 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
	 * 
	 * @param numbers
	 * @param startPos
	 * @param endPos
	 * @param element
	 * @param isSortedHalf
	 * @return
	 */
	private static boolean elementExistsHelper(int[] numbers, int startPos, int endPos, int element) {

		if (startPos > endPos) {
			return false;
		}

		int mid = (startPos + endPos) / 2;
		if (numbers[mid] == element) {
			return true;
		}

		// do a search in the left sorted side
		if (numbers[startPos] <= numbers[mid]) {
			// sorted array is the left of the mid
			if (element >= numbers[startPos] && element <= numbers[mid]) {
				return elementExistsHelper(numbers, startPos, mid - 1, element);
			}

			/*
			 * If key not lies in first half subarray, Divide other half into two subarrays,
			 * such that we can quickly check if key lies in other half
			 */
			return elementExistsHelper(numbers, mid + 1, endPos, element);
		}

		/*
		 * If arr[l..mid] first subarray is not sorted, then arr[mid... h] must be
		 * sorted subarry
		 */
		if (numbers[mid] <= numbers[endPos] && element >= numbers[mid] && element <= numbers[endPos]) {
			// sorted array is the right side of the mid
			return elementExistsHelper(numbers, mid + 1, endPos, element);
		}

		return elementExistsHelper(numbers, startPos, mid - 1, element);
	}

}
