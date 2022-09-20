class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] > j || dp[j - coins[i]] == -1) continue;
                if (dp[j] != -1)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                else 
                    dp[j] = dp[j - coins[i]] + 1;
            }
        }
        
        return dp[amount];
    }
}
