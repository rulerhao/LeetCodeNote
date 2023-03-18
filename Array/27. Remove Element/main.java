class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        int removedCount = 0;
        while (left <= right) {
            // If the one is same as val.
            if (nums[left] == val) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    left++;
                    right--;
                    removedCount++;
                } else {
                    right--;
                    removedCount++;
                }
            } else {
                left++;
            }
        }

        return nums.length - removedCount;
    }
}
