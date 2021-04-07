package org.examples.arrays;

public class BuyAndSellStockIII {

	public static void main(String[] args) {
		BuyAndSellStockIII solver = new BuyAndSellStockIII();
		System.out.println(solver.maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
	}

    public int maxProfit(int[] prices) {
    	int initialPrice = prices[0];
        for(int i =1; i<prices.length; i++){
           int price = prices[i];
           if()
           if(price < prices[j]){
               profits[i][j] = prices[j] - price;
           }
        }
        
        return -1;
     }
}
