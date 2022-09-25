class Solution {
    public int minDistance(String word1, String word2) {
        int[][] minChange = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i <= word1.length(); i++) {
            minChange[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            minChange[0][i] = i;
        }
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minChange[i][j] = minChange[i - 1][j - 1];
                } else {
                    minChange[i][j] = Math.min(minChange[i - 1][j - 1], Math.min(minChange[i - 1][j], minChange[i][j - 1])) + 1;
                }
            }
        }
        
        return minChange[word1.length()][word2.length()];
    }
}
