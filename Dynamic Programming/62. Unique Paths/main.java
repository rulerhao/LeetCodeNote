class Solution {
    public int uniquePaths(int m, int n) {
        if (m < 1 && n < 1) return 0;
        else if (m == 1 || n == 1) return 1;
        
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
