class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        
        int[][] profit = new int[prices.length][2];
        
        profit[0][0] = - prices[0] - fee; // Buy
        profit[0][1] = 0; // Sell
        
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] - prices[i] - fee);
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] + prices[i]);
        }
        
        return profit[prices.length - 1][1];
    }
}
