class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] longestLength = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            longestLength[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    longestLength[i][j] = longestLength[i + 1][j - 1] + 2;
                } else {
                    longestLength[i][j] = Math.max(longestLength[i + 1][j], Math.max(longestLength[i][j], longestLength[i][j - 1]));
                }
            }
        }
        
        return longestLength[0][s.length() - 1];
    }
}
