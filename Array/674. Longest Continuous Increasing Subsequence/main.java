class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxLength = 0;
        int length = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 1;
            }
            max = nums[i];
        }
        
        return maxLength;
    }
}
