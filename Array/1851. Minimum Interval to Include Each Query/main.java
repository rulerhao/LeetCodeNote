class Solution {
    // ans.length: 2 * nums.length;
    // ans[i] == nums[i];
    // ans[i + n] == nums[i] when 0 <= i < n
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }

        return ans;
    }
}
