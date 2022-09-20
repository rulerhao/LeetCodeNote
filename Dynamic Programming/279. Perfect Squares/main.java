class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < dp.length; i++) dp[i] = i;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= i * i) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        
        return dp[n];
    }
}
