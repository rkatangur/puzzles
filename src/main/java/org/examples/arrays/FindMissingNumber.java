package org.examples.arrays;

public class FindMissingNumber {

	public static void main(String[] args) {
		FindMissingNumber solver = new FindMissingNumber();
		System.out.println(solver.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
	}

	public int missingNumber(int[] nums) {

		long totalSum = ((nums.length + 1)* (nums.length)) / 2;
		long actualSum = 0;

		for (int num : nums) {
			actualSum += num;
		}

		return (int) (totalSum - actualSum);
	}
}
