class Solution {
    public void setZeroes(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        boolean firstCol = false;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        firstCol = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        
        if (matrix[0][0] == 0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (firstCol) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
