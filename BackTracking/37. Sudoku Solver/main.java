class Solution {
    public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }
    
    private boolean solve(int rowPos, int colPos, char[][] board) {
        if (rowPos == board.length) return true;
        
        int nextRowPos = getNextRowPos(rowPos, colPos);
        int nextColPos = getNextColPos(colPos);
        if (board[rowPos][colPos] != '.') {
            if (solve(nextRowPos, nextColPos, board)) return true;
        } else {
            for (int i = 1; i <= board.length; i++) { 
                board[rowPos][colPos] = (char) (i + '0');
                if (!isValid(rowPos, colPos, board)) {
                    board[rowPos][colPos] = '.';
                    continue;
                }
                if (solve(nextRowPos, nextColPos, board)) return true;
                board[rowPos][colPos] = '.';
            }
        }
        
        return false;
    }
    
    private boolean isValid(int rowPos, int colPos, char[][] board) {
        // Check row
        for (int i = 0; i < board.length; i++) {
            if (i != colPos) {
                if (board[rowPos][i] == board[rowPos][colPos]) {
                    return false;
                }
            }
        }
        
        // Check column
        for (int i = 0; i < board.length; i++) {
            if (i != rowPos) {
                if (board[i][colPos] == board[rowPos][colPos]) {
                    return false;
                }
            }
        }
        
        // Check sub-boxes
        int boxRowIndex = rowPos / 3;
        int boxColumnIndex = colPos / 3;
        for (int i = 0; i < 3; i++) {
            int boxRowPos = boxRowIndex * 3 + i;
            for (int j = 0; j < 3; j++) {
                int boxColPos = boxColumnIndex * 3 + j;
                if (!(boxRowPos == rowPos && boxColPos == colPos)) {
                    if (board[boxRowPos][boxColPos] == board[rowPos][colPos]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private int getNextRowPos(int rowPos, int colPos) {
        if (colPos == 9 - 1) {
            return rowPos + 1;
        } else {
            return rowPos;
        }
    }
    
    private int getNextColPos(int colPos) {
        if (colPos == 9 - 1) {
            return 0;
        } else {
            return colPos + 1;
        }
    }
    
}
