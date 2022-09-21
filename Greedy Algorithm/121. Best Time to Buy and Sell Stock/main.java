class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lowest = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            lowest = Math.min(prices[i], lowest);
            max = Math.max(prices[i] - lowest, max);
        }
        
        return max;
    }
}
