class Solution {

    int res = 0;

    public int islandPerimeter(int[][] grid) {
        boolean finished = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, j, i);
                    finished = true; // Because only have 1 island.
                    break;
                }
            }
            if (finished) break;
        }

        return res;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[y][x] == 0) {
            res++;
            return;
        } else if (grid[y][x] == -1) return;

        grid[y][x] = -1;
        for (int[] dir: dirs) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }
}
