class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buyingPrice = prices[0] + fee;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buyingPrice) {
                buyingPrice = prices[i] + fee; // if meet a day that price is lower than before than change buying day to it.
            } else if (prices[i] > buyingPrice) {
                sum = sum + prices[i] - buyingPrice;
                buyingPrice = prices[i];
            }
        }
        
        return sum;
    }
}
