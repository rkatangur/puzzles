package org.examples.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Climbing Stairs
 * 
 * You are climbing a staircase. It takes n steps to reach the top. Each time
 * you can either climb 1 or 2 steps. In how many distinct ways can you climb to
 * the top?
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 2 Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step 2. 2 steps
 * 
 * Example 2:
 * 
 * Input: n = 3 Output: 3 Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 * @author rkata
 *
 */

public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs solver = new ClimbingStairs();
//		System.out.println("Number of ways: " + solver.climbStairs1(5));
//
		System.out.println("Number of ways: " + solver.climbStairs(5));
//		
//		System.out.println("Number of ways: " + solver.climbStairsUsingDP(5));
	}

	public int climbStairs(int n) {
		int[] dp = new int[n];
		return climbStairs(0, n, dp);
	}

	private int climbStairs(int i, int n, int[] dp) {
		if (i > n) {
			System.out.println("i: " + i + ", n: " + n + ", numOfWays " + 0);
			return 0;
		}

		if (i == n) {
			System.out.println("i: " + i + ", n: " + n + ", numOfWays " + 1);
			return 1;
		}

		if (dp[i] > 0) {
			return dp[i];
		}

		dp[i] = climbStairs(i + 1, n, dp) + climbStairs(i + 2, n, dp);

		return dp[i];
	}

	private Map<Integer, Integer> numOfWaysMap = new HashMap<>();

	public int climbStairs1(int n) {
		Integer waysForN = numOfWaysMap.get(n);
		if (waysForN != null) {
			return waysForN;
		}

		if (n == 0) {
			return 1;
		}
		
		waysForN = 0;
		if (n - 1 >= 0) {
			waysForN = climbStairs1(n - 1);
		}

		if (n - 2 >= 0) {
			waysForN += climbStairs1(n - 2);
		}

		numOfWaysMap.put(n, waysForN);

		return waysForN;
	}

	public int climbStairsUsingDP(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			int numOfWays = dp[i - 1] + dp[i - 2];
			dp[i] = numOfWays;
		}

		return dp[n];
	}

}
