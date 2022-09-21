// Arranged in a circle.
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int result = Math.max(getEarning(nums, 0), getEarning(nums, 1));
        
        return result;
    }
    
    private int getEarning(int[] nums, int startPos) {
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[startPos];
        dp[1] = Math.max(dp[0], nums[startPos + 1]);
        
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[startPos + i]);
        }
        
        return dp[nums.length - 2];
    }
}
