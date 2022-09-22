class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] profit = new int[k * 2];
        
        for (int i = 0; i < k; i++) profit[i * 2] = - prices[0];
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    profit[j * 2] = Math.max(profit[j * 2], - prices[i]);
                    profit[j * 2 + 1] = Math.max(profit[j * 2 + 1], profit[j * 2] + prices[i]);
                    continue;
                } 
                profit[j * 2] = Math.max(profit[j * 2], profit[j * 2 - 1] - prices[i]);
                profit[j * 2 + 1] = Math.max(profit[j * 2 + 1], profit[j * 2] + prices[i]);
            }
        }
        
        return profit[profit.length - 1];
    }
}
