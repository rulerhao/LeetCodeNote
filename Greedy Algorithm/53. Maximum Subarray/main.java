class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            count = count + nums[i];
            result = Math.max(count, result);
            if (count < 0) {
                count = 0;
            }
        }

        return result;
    }
}
