public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0; 
        for (int n: nums) sum = sum + n;
        
        // Remove the impossible option because target will never happen.
        if (target > sum || target < - sum) return 0;
        
        int[] dp = new int[sum * 2 + 1];
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[sum * 2 + 1];
            for (int j = 0; j < sum * 2 + 1; j++) {
                if (dp[j] != 0) {
                    next[j + nums[i]] = next[j + nums[i]] + dp[j];
                    next[j - nums[i]] = next[j - nums[i]] + dp[j];
                }
            }
            dp = next;
        }
        return dp[sum + target];
    }
}
