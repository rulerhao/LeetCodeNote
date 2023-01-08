class Solution {
    public long maxKelements(int[] nums, int k) {
        long result = 0;
        for (int i = 0; i < k; i++) {
            int maxVal = Integer.MIN_VALUE;
            int maxIdx = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > maxVal) {
                    maxVal = nums[j];
                    maxIdx = j;
                }
            }
            result += maxVal;
            nums[maxIdx] = (int) Math.ceil(maxVal / 3.0);
        }
        
        return result;
    }
}
