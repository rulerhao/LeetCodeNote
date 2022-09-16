// non-empty array: nums
// positive integers

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 == 1 || nums.length <= 1) return false;
            
        int halfSum = sum / 2;
        int[] dp = new int[halfSum + 1];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        
        return dp[dp.length - 1] == dp.length - 1;
    }
    
    private int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum = sum + nums[i];
        
        return sum;
    } 
}
