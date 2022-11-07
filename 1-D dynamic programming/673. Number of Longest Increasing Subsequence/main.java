class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] maxLens = new int[nums.length];
        for (int i = 0; i < maxLens.length; i++) maxLens[i] = 1;

        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            boolean getLarger = false;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    maxLens[i] = Math.max(maxLens[i], maxLens[j] + 1);
                    maxLen = Math.max(maxLen, maxLens[i]);
                }
            }
        }
        int[] count = new int[nums.length];
        for (int i = 0; i < count.length; i++) {
            if (maxLens[i] == 1) {
                count[i] = 1;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (maxLens[j] == maxLens[i] - 1) {
                    if (nums[j] < nums[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("maxLens: " + maxLens[i] + ", count: " + count[i]);
            if (maxLens[i] == maxLen) {
                res += count[i];
            }
        }

        return res;
    }
}
