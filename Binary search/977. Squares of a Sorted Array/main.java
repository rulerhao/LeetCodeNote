class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) return new int[]{};
        else if (nums.length == 1) return new int[]{nums[0] * nums[0]};

        int minIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(nums[minIdx])) {
                minIdx = i;
            }
        }

        int left = minIdx;
        int right = minIdx;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = nums[minIdx] * nums[minIdx];
                left--;
                right++;
                continue;
            }
            if (left >= 0 && right < nums.length) {
                if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                    res[i] = nums[left] * nums[left];
                    left--;
                } else {
                    res[i] = nums[right] * nums[right];
                    right++;
                }
            } else if (left >= 0) {
                res[i] = nums[left] * nums[left];
                left--;
            } else if (right < nums.length) {
                res[i] = nums[right] * nums[right];
                right++;
            } else break;
        }

        return res;
    }
}
