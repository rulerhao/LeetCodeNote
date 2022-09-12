class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        
        int count = 0;
        int preDif = 0;
        int curDif = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) count++;
            else if (i == 1) {
                preDif = nums[i] - nums[i - 1];
                if (preDif != 0) count++;
            } else {
                curDif = nums[i] - nums[i - 1];
                // Illegal
                if (curDif * preDif > 0 || curDif == 0) {
                    preDif = curDif + preDif;
                } else if (preDif == 0 && curDif != 0) {
                    count++;
                    preDif = curDif;
                } else { // Legal
                    count++;
                    preDif = curDif;
                }
            }
        }
        
        return count;
    }
}
