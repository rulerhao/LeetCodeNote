class Solution {
    int[][] dp;
    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;

        dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dfs(matrix, j, i, -1, 0);
            }
        }

        return max;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(int[][] matrix, int x, int y, int preVal, int preLen) {
        if (x < 0 || y < 0 || x > matrix[0].length - 1 || y > matrix.length - 1) {
            return;
        }

        int val = matrix[y][x];
        if (preVal <= val && preVal != -1) return;
        if (preLen + 1 >= dp[y][x]) dp[y][x] = preLen + 1;
        else return;
        max = Math.max(max, dp[y][x]);
        matrix[y][x] = Integer.MAX_VALUE;
        for (int[] dir: dirs) dfs(matrix, x + dir[0], y + dir[1], val, dp[y][x]);
        matrix[y][x] = val;
    }
}
