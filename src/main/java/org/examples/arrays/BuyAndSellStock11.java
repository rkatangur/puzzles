package org.examples.arrays;

public class BuyAndSellStock11 {

	public static void main(String[] args) {
		BuyAndSellStock11 solver = new BuyAndSellStock11();
//		System.out.println(solver.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));

		System.out.println(solver.maxProfit1(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
	}

	public int maxProfit(int[] prices) {

//		int min_price = prices[0];
//		int prev_price = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				// valley
//				min_price = prices[i];
//				prev_price = min_price;
			} else {
				profit += prices[i] - prices[i - 1];
			}
		}

		return profit;
	}

	public int maxProfit1(int[] prices) {
		int length = prices.length;
		int[][] profits = new int[length][length];
		for (int i = 0; i < length; i++) {
			int price = prices[i];
			for (int j = i + 1; j < length; j++) {
				if (price < prices[j]) {
					profits[i][j] = prices[j] - price;
				}
			}
		}
		
		for (int i = 0; i < profits.length; i++) {
			for (int j = 0; j < profits.length; i++) {
				profits[i][j]
			}
		}


		return 0;
	}

}
