class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int height = board.length;
        int width = board[0].length;
        
        boolean[][] adjEdge = new boolean[height][width];
        for (int i = 0; i < width; i++) {
            dfs(board, adjEdge, 0, i);
            dfs(board, adjEdge, height - 1, i);
        }
        for (int i = 1; i < height - 1; i++) {
            dfs(board, adjEdge, i, 0);
            dfs(board, adjEdge, i, width - 1);
        }
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!adjEdge[i][j]) board[i][j] = 'X';
            }
        }
    }
    
    private void dfs(char[][] board, boolean[][] adjEdge, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == 'X' || adjEdge[i][j] == true) return;
        adjEdge[i][j] = true;
        dfs(board, adjEdge, i + 1, j);
        dfs(board, adjEdge, i, j + 1);
        dfs(board, adjEdge, i - 1, j);
        dfs(board, adjEdge, i, j - 1);
    }
}
