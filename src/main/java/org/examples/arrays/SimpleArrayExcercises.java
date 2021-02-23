package org.examples.arrays;

public class SimpleArrayExcercises {

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		SimpleArrayExcercises solver = new SimpleArrayExcercises();
		solver.maxProfit(prices);

		System.out.println("------------------------------------------------------------");
		System.out.println("maxSubarray: " + solver.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	public int maxProfit1(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}

		return maxProfit;
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int buyDay = 0;
		int sellDay = 0;

		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (profit > 0 && profit > maxProfit) {
					maxProfit = profit;
					buyDay = i + 1;
					sellDay = j + 1;
				}
			}
		}

		System.out.println("maxProfit " + maxProfit + ", buyDay " + buyDay + ", sellDay " + sellDay);
		return maxProfit;
	}

	public int maxSubArray(int[] nums) {
		int curSum = nums[0];
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			curSum = Math.max(curSum + nums[i], nums[i]);

			if (curSum > maxSum) {
				maxSum = curSum;
			}
		}
		return maxSum;
	}
}
