package org.examples.recursion;

/**
 * 
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1. You may assume that you have an infinite
 * number of each kind of coin.
 * 
 * Example 1:
 * 
 * Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * 
 * @author rkata
 *
 */
public class CoinChange {

	public static void main(String[] args) {
		CoinChange solver = new CoinChange();
		System.out.println(solver.coinChange(new int[] { 186, 419, 83, 408 }, 6249));
//		System.out.println(solver.coinChange(new int[] { 1, 2, 5 }, 11));
//		System.out.println(solver.coinChange(new int[] { 2 }, 3));

//		System.out.println(solver.coinChangeUsingDPBottomUp(new int[] { 1, 2, 5 }, 11));
	}

	public int coinChangeUsingDPBottomUp(int[] coins, int amount) {
		int[] amountDp = new int[amount + 1];
		amountDp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin) {
					int amountAvail = i - coin;
					int numOfCoins = amountDp[amountAvail];
					if (amountDp[i] == 0 || numOfCoins < amountDp[i]) {
						amountDp[i] = numOfCoins + 1;
					}
				}
			}
		}

		return amountDp[amount];
	}

	public int coinChange(int[] coins, int amount) {
		int[] amountDp = new int[amount + 1];
		return coinChange(coins, amount, amountDp);
	}

	public int coinChange(int[] coins, int amount, int[] amountDp) {
		if (amount < 0) {
			return -1;
		}

		if (amount == 0) {
			return 0;
		}

		if (amountDp[amount] != 0) {
			return amountDp[amount];
		}

		int minNumOfCoinsNeeded = Integer.MAX_VALUE;
		for (int coin : coins) {
			int amountAvail = amount - coin;
			int minNumOfCoinsForAvailAmount = coinChange(coins, amountAvail, amountDp);
			if (minNumOfCoinsForAvailAmount >= 0 && minNumOfCoinsForAvailAmount < minNumOfCoinsNeeded) {
				minNumOfCoinsNeeded = minNumOfCoinsForAvailAmount + 1;
			}
		}

		if (amount > 0 && minNumOfCoinsNeeded == Integer.MAX_VALUE) {
			amountDp[amount] = -1;
		} else {
			amountDp[amount] = minNumOfCoinsNeeded;
		}

		return amountDp[amount];
	}
}
