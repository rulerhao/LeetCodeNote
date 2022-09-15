// if n == 3
// dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2] (Added node at root. dp[2] * dp[0] means left has 2 node and right has 1 node)
class Solution {
    public int numTrees(int n) {
        if (n == 0) return 1;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[i] + dp[i - j - 1] * dp[j];
            }
        }
        
        return dp[n];
    }
}   
