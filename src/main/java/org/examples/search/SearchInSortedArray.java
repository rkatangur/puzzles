package org.examples.search;

/**
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * 
 * @author rkata
 *
 */
public class SearchInSortedArray {

	public static void main(String[] args) {
		SearchInSortedArray solver = new SearchInSortedArray();
		System.out.println(solver.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(solver.search(new int[] { 6, 7, 0, 1, 2, 4, 5 }, 0));
		System.out.println(solver.search(new int[] { 2, 4, 5, 6, 7, 0, 1 }, 0));
	}

	public int search(int[] numbers, int element) {
		int left = 0;
		int right = numbers.length - 1;
		int mid = -1;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (numbers[mid] > numbers[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		System.out.println("mid " + mid + ", start " + left + ", endIndex " + right);

		int start = left;
		left = 0;
		right = numbers.length - 1;

		if (element >= numbers[start] && element <= numbers[right]) {
			left = start;
		} else {
			right = start;
		}

		int elemPos = -1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (numbers[mid] == element) {
				elemPos = mid;
				break;
			}

			if (numbers[mid] > element) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println("mid " + mid + ", start " + left + ", endIndex " + right);

		return elemPos;
	}

}
