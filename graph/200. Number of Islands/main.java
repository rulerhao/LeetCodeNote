class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') count++;
                travelAndColor(grid, i, j);
            }
        }
        
        return count;
    }
    
    private void travelAndColor(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        travelAndColor(grid, i + 1, j);
        travelAndColor(grid, i, j + 1);
        travelAndColor(grid, i - 1, j);
        travelAndColor(grid, i, j - 1);
    }
}
