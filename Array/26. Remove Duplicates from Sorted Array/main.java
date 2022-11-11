class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int keyIdx = 0;
        int val = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                val = nums[i];
                nums[keyIdx] = val;
                keyIdx++;
            } else {
                continue;
            }
        }

        return keyIdx;
    }
}
