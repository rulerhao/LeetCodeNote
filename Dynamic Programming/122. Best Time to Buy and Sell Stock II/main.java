// dp
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];

        dp[0] = 0; // Not Own
        dp[1] = - prices[0]; // Own
        for(int i = 1; i <= prices.length; i++){
            // "+" means sell the holding stock and get the money.
            dp[0] = Math.max(dp[0], dp[1] + prices[i - 1]);
            // "-" means buy the stock of the day and take the money.
            dp[1] = Math.max(dp[1], dp[0] - prices[i - 1]);
        }
        return dp[0];
    }
}
