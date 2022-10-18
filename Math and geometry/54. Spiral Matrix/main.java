class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int maxX = matrix[0].length - 1;
        int minX = 0;
        int maxY = matrix.length - 1;
        int minY = 0;
        
        while (maxX - minX >= 0 && maxY - minY >= 0) {
            for (int i = minX; i <= maxX; i++) {
                res.add(matrix[minY][i]);
            }
            minY++;
            if (maxY - minY < 0) break;
            for (int i = minY; i <= maxY; i++) {
                res.add(matrix[i][maxX]);
            }
            maxX--;
            if (maxX - minX < 0) break;
            for (int i = maxX; i >= minX; i--) {
                res.add(matrix[maxY][i]);
            }
            maxY--;
            if (maxY - minY < 0) break;
            for (int i = maxY; i >= minY; i--) {
                res.add(matrix[i][minX]);
            }
            minX++;
            if (maxX - minX < 0) break;
        }
        return res;
    }
}
