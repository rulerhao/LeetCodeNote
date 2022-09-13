// 1. non-negative nums
// 2. init pos index 0
// 3. element means max jump length
// 4. Goal: reach last index with min jump times

class Solution {
    public int jump(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return 0;
        
        int count = 0;
        int curRange = 0;
        int maxRange = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxRange = Math.max(maxRange, nums[i] + i);
            
            if (maxRange >= nums.length - 1) {
                count++;
                break;
            }
            
            if (i == curRange) {
                curRange = maxRange;
                count++;
            }
        }
        
        return count;
    }
}
