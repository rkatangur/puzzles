package org.examples.arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		RemoveDuplicates solver = new RemoveDuplicates();
//		System.out.println(solver.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
		
		System.out.println(solver.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

	/**
	 * 
	 * Input: nums = [0,0,1,1,1,2,2,3,3,4] Output: 5, nums = [0,1,2,3,4]
	 * Explanation: Your function should return length = 5, with the first five
	 * elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't
	 * matter what values are set beyond the returned length.
	 * 
	 */
	public int removeDuplicates(int[] nums) {

		int firstPointer = 0;

		for (int i = firstPointer + 1; i < nums.length; i++) {
			if (nums[firstPointer] != nums[i]) {
				if (firstPointer + 1 < i) {
					nums[firstPointer + 1] = nums[i];
					firstPointer = firstPointer + 1;
				} else {
					firstPointer = i;
				}
			}
		}

		return firstPointer + 1;
	}

}
