
class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int res = nums[0];
        int max = 1;
        int min = 1;

        for (int n : nums) {
            int tmpMax = max * n;
            int tmpMin = min * n;
            max = getMax(n, tmpMax, tmpMin);
            min = getMin(n, tmpMax, tmpMin);
            res = Math.max(res, max);
        }
        return res;
    }
    
    private int getMax(int n1, int n2, int n3) {
        return Math.max(n1, Math.max(n2, n3));
    }
    
    private int getMin(int n1, int n2, int n3) {
        return Math.min(n1, Math.min(n2, n3));
    }
}
