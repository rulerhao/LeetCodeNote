class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        
        int nonPositiveCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nonPositiveCount = i;
                break;
            }
            if (i == nums.length - 1) {
                nonPositiveCount = nums.length;
                break;
            }
        }

        int result = 0;
        if ((k - nonPositiveCount) % 2 == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0 && k > i) {
                    result = result - nums[i];
                } else {
                    result = result + nums[i];
                }
            }
        } else {
            if (k < nonPositiveCount) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] < 0 && k > i) {
                        result = result - nums[i];
                    } else {
                        result = result + nums[i];
                    }
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (i == 0 && nonPositiveCount == 0) {
                        result = result - nums[i];
                    } else if (i == nums.length - 1 && nonPositiveCount == nums.length) {
                        result = result + nums[i];
                    } else if (i == nonPositiveCount - 1 && nonPositiveCount > 0 && nonPositiveCount < nums.length) {
                        result = result + Math.abs(nums[nonPositiveCount - 1] + nums[nonPositiveCount]);
                        continue;
                    } else if (i == nonPositiveCount && nonPositiveCount > 0 && nonPositiveCount < nums.length) {
                        continue;
                    } else if (nums[i] < 0 && k > i) {
                        result = result - nums[i];
                    } else {
                        result = result + nums[i];
                    }
                }
            }
        }
        
        return result;
    }
}
