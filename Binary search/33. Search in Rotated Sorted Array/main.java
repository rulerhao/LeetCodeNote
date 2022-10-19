class Solution {
    public int search(int[] nums, int target) {
        int mid = getMid(nums);
        int leftRes = binarySearch(nums, 0, mid - 1, target);
        int rightRes = binarySearch(nums, mid, nums.length - 1, target);
        
        if (leftRes != -1) return leftRes;
        else if (rightRes != -1) return rightRes;
        else return -1;
    }
    
    public int getMid(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = (mid - 1 + nums.length) % nums.length;
            int next = (mid + 1) % nums.length;
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid - 1;
            } else if (nums[mid] >= nums[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else return mid;
        }
        
        return -1;
    }
}
