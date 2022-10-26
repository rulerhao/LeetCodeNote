class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character> rowSet = null;
        for (int i = 0; i < board.length; i++) {
            rowSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (rowSet.contains(c)) {
                        return false;
                    } else {
                        rowSet.add(c);
                    }
                }
            }
        }
        
        Set<Character> colSet = null;
        for (int i = 0; i < board.length; i++) {
            colSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (colSet.contains(c)) {
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }
            }
        }
        
        Set<Character> matrixSet = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrixSet = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i * 3 + k][j * 3 + l];
                        if (c != '.') {
                            if (matrixSet.contains(c)) {
                                return false;
                            } else {
                                matrixSet.add(c);
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
