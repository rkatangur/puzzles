package org.examples.recursion;

//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//Example:
//
//Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//Output:  True  //There is a subset (4, 5) with sum 9.
public class SubsetSum {

	public boolean isSubsetSum(int[] arr, int n, int sum) {
		if (sum == 0) {
			return true;
		} else if (n == 0 && sum != 0) {
			System.out.println("n " + n + ", sum " + sum);
			return false;
		}

		System.out.println("Comparing elem " + arr[n - 1] + ", sum " + sum + " at index " + (n - 1));
		int elem = arr[n - 1];
		if (elem > sum) {
			return isSubsetSum(arr, n - 1, sum);
		} else {
			/*
			 * else, check if sum can be obtained by any of the following (a) including the
			 * last element (b) excluding the last element
			 */
			return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - elem);
		}
	}

	public static void main(String[] args) {
		SubsetSum subsetSum = new SubsetSum();
		int set[] = { 3, 34, 4, 12, 5, 2 };
		System.out.println(subsetSum.isSubsetSum(set, set.length, 9));
		System.out.println(subsetSum.isSubsetSum2(set, 0, 9));

	}

	static boolean isSubsetSum2(int[] set, int index, int sum) {
		if (sum == 0) {
			return true;
		} else if (index == 0 && sum > 0) {
			return false;
		}
		if (set[index] > sum) {
			return isSubsetSum2(set, index + 1, sum);
		} else {
			return isSubsetSum2(set, index + 1, sum) || isSubsetSum2(set, index + 1, sum - set[index]);
		}
	}

}
