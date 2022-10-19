class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;
        int len = matrix[0].length * matrix.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int x = mid % width;
            int y = mid / width;
            
            if (matrix[y][x] > target) {
                right = mid - 1;
            } else if (matrix[y][x] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
