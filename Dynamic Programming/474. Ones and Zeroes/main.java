class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (String str: strs) {
            int count0 = 0;
            int count1 = 0;
            for (char c: str.toCharArray()) {
                if (c == '0') count0++;
                else if(c == '1') count1++;
            }
            for (int i = dp.length - 1; i >= count0; i--) {
                for (int j = dp[i].length - 1; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
