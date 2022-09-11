class Solution {
    List<List<String>> result = new ArrayList<>();
    
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return new ArrayList<>();
        
        initBoard(n);
        
        solveRow(n, 0);
        return result;
    }
    
    private void solveRow(int n, int rowPos) {
        if (rowPos == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(String.valueOf(board[i]));
            }
            result.add(temp);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            board[rowPos][i] = 'Q';
            if (!isValid(i, rowPos, board)) {
                board[rowPos][i] = '.';
                continue;
            }
            solveRow(n, rowPos + 1);
            board[rowPos][i] = '.';
        }
    }
     
    private boolean isValid(int colPos, int rowPos, char[][] board) {
        // Check the elements above it;
        for (int i = 0; i < rowPos; i++) {
            if (board[i][colPos] == 'Q') {
                return false;
            }
        }
        
        for (int i = rowPos - 1; i >= 0; i--) {
            // Check the angle 45
            int xPos45 = colPos + rowPos - i;
            if (xPos45 < board[i].length) {
                if (board[i][xPos45] == 'Q') {
                    return false;
                }
            }
            // Check the angle 135
            int xPos135 = colPos + i - rowPos;
            if (xPos135 >= 0) {
                if (board[i][xPos135] == 'Q') {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void initBoard(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
    }
}
