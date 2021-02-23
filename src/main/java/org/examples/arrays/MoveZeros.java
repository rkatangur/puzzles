package org.examples.arrays;

/**
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements. Example:
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * 
 * 
 * 
 * @author rkata
 *
 */
public class MoveZeros {

	public static void main(String[] args) {
		MoveZeros solver = new MoveZeros();
		solver.moveZeroesV1(new int[] { 0, 1, 0, 3, 12 });
//		solver.moveZeroesV1(new int[] { 1, 2, 3, 1 });
//		System.out.println(solver.numberToWords(1003));
	}

	public void moveZeroes(int[] nums) {

		int zeroNumIndex = 0;
		if (nums[0] != 0) {
			zeroNumIndex = -1;
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != 0 && zeroNumIndex != -1) {
				// swap
				nums[zeroNumIndex] = nums[i];
				nums[i] = 0;

				int nextZeroIndex = zeroNumIndex;
				zeroNumIndex = -1;
				while (nextZeroIndex < i) {
					if (nums[++nextZeroIndex] == 0) {
						zeroNumIndex = nextZeroIndex;
						break;
					}
				}
			} else if (nums[i] == 0) {
				if (zeroNumIndex == -1)
					zeroNumIndex = i;
			}
		}
	}

	public void moveZeroesV1(int[] nums) {
		int lastNonZeroIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				System.out.println("Swapping " + nums[i] + " at i " + i + " to lastNonZeroIndex " + lastNonZeroIndex);
				nums[lastNonZeroIndex++] = nums[i];
			}
		}

		for (int i = lastNonZeroIndex; i < nums.length; i++) {
			nums[lastNonZeroIndex++] = 0;
		}
	}

}
