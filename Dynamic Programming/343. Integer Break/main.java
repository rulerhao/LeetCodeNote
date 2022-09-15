class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++){
            for(int j = 1; j <= i - j; j++){
                dp[i] = Math.max(
                    dp[i], 
                    Math.max(
                        j * (i - j), 
                        j * dp[i - j]
                    )
                );
                // j * (i - j) 把整數 i 拆分為兩個數 也就是 i, i - j，再相乘
                // 而 j * dp[i - j] 是將 i 拆分成兩個以及兩個以上的個數，再相乘
            }
        }
        return dp[n];
    }
}
