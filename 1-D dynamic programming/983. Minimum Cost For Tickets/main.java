class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        for (int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;

        int[] dayNum = new int[]{1, 7, 30};

        int daysIdx = 0;
        for (int i = 1; i < dp.length; i++) {
            if (days[daysIdx] != i) {
                dp[i] = dp[i - 1];
                continue;
            }
            daysIdx++;
            for (int j = 0; j < dayNum.length; j++) {
                if (i < dayNum[j]) dp[i] = Math.min(dp[i], costs[j]);
                else {
                    dp[i] = Math.min(dp[i], dp[i - dayNum[j]] + costs[j]);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
