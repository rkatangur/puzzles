package org.examples.arrays.traversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
 * 
 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 * 
 * 
 * 
 * @author rkata
 *
 */
public class PerfectSquares {

	public static void main(String[] args) {
		PerfectSquares solver = new PerfectSquares();
//		System.out.println(" isPerfectSquareV1(13) " + solver.isPerfectSquareV1(13));
//		System.out.println(" isPerfectSquareV2(13) " + solver.isPerfectSquareV2(13));
//
//		System.out.println(" isPerfectSquareV1(2) " + solver.isPerfectSquareV1(2));
//		System.out.println(" isPerfectSquareV2(2) " + solver.isPerfectSquareV2(2));
//
//		System.out.println(" isPerfectSquareV1(9) " + solver.isPerfectSquareV1(9));
//		System.out.println(" isPerfectSquareV2(9) " + solver.isPerfectSquareV2(9));

//		System.out.println(" numSquares(13) " + solver.numSquares(13));
//		System.out.println(" numSquares(12): " + solver.numSquares(12));

//		System.out.println(" numSquares(5): " + solver.numSquares(5));
		System.out.println(" numSquares(5): " + solver.numSquares(7));
		System.out.println(" numSquares(5): " + solver.numSquares(13));
//		System.out.println(" numSquares(29): " + solver.numSquares(29));
	}

	
	/**
	 * 
	 * To calculate the value of numSquares(n), first we need to calculate all the values before n, i.e. numSquares(n-k) for all {k} in {square numbers}
	 * numSquares(n-k) where k belongs to {square numbers}. If we have already kept the solution for the number 
	 * n-k in somewhere, we then would not need to resort to the recursive calculation which prevents the stack overflow.
	 * 
	 * @param n
	 * @return
	 */
	public int numSquares(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		// bottom case
		dp[0] = 0;

		// pre-calculate the square numbers.
		int max_square_index = (int) Math.sqrt(n) + 1;
		int square_nums[] = new int[max_square_index];
		for (int i = 1; i < max_square_index; ++i) {
			square_nums[i] = i * i;
		}

		for (int i = 1; i <= n; ++i) {
			for (int s = 1; s < max_square_index; ++s) {
				if (i < square_nums[s])
					break;
				dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
			}
		}
		return dp[n];
	}

	private int numSquares1(int n) {
		Map<Integer, Integer> minSqsMap = new HashMap<Integer, Integer>();

		for (int i = 1; i * i <= n; i++) {
			int sqOfI = i * i;
			minSqsMap.put(sqOfI, 1);
		}

		return numSquaresDP(n, minSqsMap);
	}

	public int numSquaresDP(int n, Map<Integer, Integer> minSqsMap) {
		if (n == 0) {
			return 0;
		}

		Integer minSqsOfN = minSqsMap.get(n);
		if (minSqsOfN != null) {
			return minSqsOfN;
		}

		int curNumOfSqs = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			int sqOfI = i * i;

			int leftOverN = n % sqOfI;
			int numOfSqsUsed = n / sqOfI;

//			System.out.println(
//					"n " + n + ", sqOfI " + sqOfI + ", numOfSqsUsed " + numOfSqsUsed + ", leftOverN " + leftOverN);			
			int numOfSqsForLeftOverN = numSquaresDP(leftOverN, minSqsMap);

//			System.out.println(
//					"n " + n + ", sqOfI " + sqOfI + ", numOfSqsForLeftOverN " + numOfSqsForLeftOverN + ", leftOverN " + leftOverN);

			curNumOfSqs = Math.min(curNumOfSqs, numOfSqsUsed + numOfSqsForLeftOverN);
			minSqsMap.put(n, curNumOfSqs);
		}

		return curNumOfSqs;
	}

	public int numSquaresRecursion(int n) {
		if (n == 0) {
			return 0;
		}

		if (n <= 3) {
			return n;
		}

		int curNumOfSqs = Integer.MAX_VALUE;
		for (int i = n / 2; i * i > 0; i--) {
			int sqOfI = i * i;
			if (sqOfI > n) {
				continue;
			}

			int leftOverN = n % sqOfI;
			int numOfSqsUsed = n / sqOfI;
			System.out.println(
					"n " + n + ", sqOfI " + sqOfI + ", numOfSqsUsed " + numOfSqsUsed + ", leftOverN " + leftOverN);
			curNumOfSqs = Math.min(curNumOfSqs, numOfSqsUsed + numSquares(leftOverN));
		}

		return curNumOfSqs;
	}

	public int isPerfectSquareV1(int n) {

		for (int i = 1; i * i <= n; i++) {
			int remainder = (int) (n % i);
			int dividedParts = (int) (n / i);
			if (remainder == 0 && dividedParts == i) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * left =1 right =9 mid = (1+9)/2 = 5
	 * 
	 */
	public int isPerfectSquareV2(int num) {
		int left = 1, right = num;
		int mid = 0;
		int mid1 = (left + right) / 2;
		while (left < right) {

			mid1 = (left + right) / 2;

			if (mid1 * mid1 == num) {
				mid = mid1;
				break;
			}

			if (mid1 * mid1 > num) {
				right = mid1 - 1;
			} else {
				left = mid1 + 1;
			}
		}
		return mid;
	}

}
