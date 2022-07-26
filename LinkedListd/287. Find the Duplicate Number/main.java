class Solution {

    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        boolean first = true;
        while (first || fast != slow) {
            if (first) first = false;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int slow2 = nums[0];
        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow;
    }
}
