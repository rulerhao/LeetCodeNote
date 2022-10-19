class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int prev = (mid - 1 + nums.length) % nums.length;
            int next = (mid + 1) % nums.length;
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return nums[mid];
            } else if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else if (nums[left] < nums[mid] || nums[left] > nums[mid]) {
                right = mid - 1;
            }
        }
        
        return 0;
    }
}
