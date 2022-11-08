class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1 && nums[0] < target) return 1;
        else if (nums.length == 1 && nums[0] > target) return 0;

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (right - left <= 1 && nums[left] < target && target < nums[right]) {
            return left + 1;
        } else if (right - left <= 1 && target < nums[left]) {
            return left;
        } else if (right - left <= 1 && nums[right] < target) {
            return right + 1;
        }
        int mid = (right + left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }
}
