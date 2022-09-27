class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, travel(grid, i, j));
                }
            }
        }
        
        return result;
    }
    
    private int travel(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1) {
            return 0;
        }
        if (grid[i][j] != 1) return 0;
        int area = 1;
        grid[i][j] = 0;
        area += travel(grid, i + 1, j);
        area += travel(grid, i, j + 1);
        area += travel(grid, i - 1, j);
        area += travel(grid, i, j - 1);
        
        return area;
    }
}
