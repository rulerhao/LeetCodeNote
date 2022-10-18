class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int layer = 0;
        int layersNum = (len + 1) / 2;
        for (int i = 0; i < layersNum; i++) {
            int size = len - i * 2 - 1;
            for (int j = 0; j < size; j++) {
                int leftTop = matrix[i][i + j];
                matrix[i][i + j] = matrix[len - 1 - i - j][i];
                matrix[len - 1 - i - j][i] = matrix[len - 1 - i][len - 1 - i - j];
                matrix[len - 1 - i][len - 1 - i - j] = matrix[i + j][len - 1 - i];
                matrix[i + j][len - 1 - i] = leftTop;
            }
        }
    }
}
