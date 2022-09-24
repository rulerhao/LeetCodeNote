class Solution {
    public int minDistance(String word1, String word2) {
        int[][] deleteNums = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i <= word1.length(); i++) deleteNums[i][0] = i;
        for (int i = 0; i <= word2.length(); i++) deleteNums[0][i] = i;
        
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    deleteNums[i][j] = deleteNums[i - 1][j - 1];
                } else {
                    deleteNums[i][j] = Math.min(deleteNums[i - 1][j - 1] + 2, 
                                                Math.min(deleteNums[i - 1][j] + 1, deleteNums[i][j - 1] + 1));
                }
            }
        }
        
        return deleteNums[word1.length()][word2.length()];
    }
}
