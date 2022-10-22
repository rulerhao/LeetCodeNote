class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        else if (board.length == 0 || board[0].length == 0) return false;
                
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (findExist(board, word, 0, i, j)) return true;
            }
        }
        
        return false;
    }
    
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private boolean findExist(char[][] board, String word, int index, int i, int j) {
        if (i < 0 || i >= board.length) return false;
        else if (j < 0 || j >= board[0].length) return false;
        
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        
        board[i][j] += 52;
        
        if (index == word.length() - 1) {
            return true;
        }
        
        boolean found = false;
        for (int[] dir: dirs) {
            found = found || findExist(board, word, index + 1, i + dir[0], j + dir[1]);
        }
        
        board[i][j] -= 52;
        
        return found;
    }
}
