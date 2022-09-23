class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] length = new int[nums1.length][nums2.length];
        
        int maxLength = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (i >= 1 && j >= 1) {
                        length[i][j] = length[i - 1][j - 1] + 1;
                    } else {
                        length[i][j] = 1;
                    }
                    maxLength = Math.max(maxLength, length[i][j]);
                } else {
                    length[i][j] = 0;
                }
            }
        }
        
        return maxLength;
    }
}
