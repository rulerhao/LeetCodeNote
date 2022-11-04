class Solution {
    public int longestPalindrome(String[] words) {
        
        int[][] dp = new int[26][26];
        int middleLength = 0;

        for (String word : words) {
            dp[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }

        int startLength = 0;

        for (int row = 0; row < 26; row++) {
            for (int column = 0; column < 26; column++) {

                if (row == column) { //aa

                    if (dp[row][column] % 2 == 0) {
                        startLength += (dp[row][column] * 2);

                    } else {
                        middleLength = 2;
                        startLength += 2 * (dp[row][column] - 1);
                    }

                } else { //ab

                    if (dp[row][column] > 0 && dp[column][row] > 0) {
                        startLength += 4 * Math.min(dp[row][column], dp[column][row]);
                        dp[column][row] = 0;
                        dp[row][column] = 0;
                    }
                }
            }
        }

        return startLength + middleLength;
    }
}
