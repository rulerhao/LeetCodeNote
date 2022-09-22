// 1. At most 2 transactions.
// 2. Buy stock only if you don't have stock.
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] profit = new int[4];
        
        profit[0] = - prices[0]; // Buy the first stock.
        profit[1] = 0; // Sell the first stock.
        profit[2] = - prices[0]; // Buy the second stock.
        profit[3] = 0; // Sell the second stock.
        for (int i = 0; i < prices.length; i++) {
            profit[0] = Math.max(profit[0], - prices[i]);
            profit[1] = Math.max(profit[1], profit[0] + prices[i]);
            profit[2] = Math.max(profit[2], profit[1] - prices[i]);
            profit[3] = Math.max(profit[3], profit[2] + prices[i]);
        }
        
        return Math.max(profit[1], profit[3]);
    }
}
