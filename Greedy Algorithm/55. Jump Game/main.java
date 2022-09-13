class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 1) return true;
        int coverRange = nums[0];
        for (int i = 1; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, nums[i] + i);
            if (coverRange >= nums.length - 1) return true;
        }
        return false;
    }
}
