// class Solution {
//     public int numSquares(int n) {
//         int[] dp = new int[n + 1];
        
//         for (int i = 0; i < dp.length; i++) dp[i] = i;
//         for (int i = 2; i <= Math.sqrt(n); i++) {
//             for (int j = 0; j <= n; j++) {
//                 if (j >= i * i) {
//                     dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
//                 }
//             }
//         }
        
//         return dp[n];
//     }
// }

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                    continue;
                }
                if (dp[i] == 0) dp[i] = dp[i - j * j] + dp[j * j];
                else {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + dp[j * j]);
                }
            }
        }
        
        return dp[n];
    }
}
