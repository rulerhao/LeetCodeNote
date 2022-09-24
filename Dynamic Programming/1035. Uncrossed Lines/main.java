class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] maxLength = new int[nums1.length + 1][nums2.length + 1];
        
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    maxLength[i][j] = maxLength[i - 1][j - 1] + 1;
                } else {
                    maxLength[i][j] = Math.max(maxLength[i - 1][j], maxLength[i][j - 1]);
                }
            }
        }
        
        return maxLength[nums1.length][nums2.length];
    }
}
