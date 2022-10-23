class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i > 0) {
                    if (s1.charAt(i - 1) == s3.charAt(i - 1 + j)) {
                        if (dp[i - 1][j] == true)
                            dp[i][j] = true;
                    }
                }
                if (j > 0) {
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        if (dp[i][j - 1] == true)
                            dp[i][j] = true;
                    }
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
