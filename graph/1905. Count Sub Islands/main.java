// m x n
// grid with {0 -> water, 1 -> land}
// island: 1
// sub island: island in grid1 overlap all of grid2
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    if (isSubIsland(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int y, int x) {
        boolean res = true;
        if (x < 0 || y < 0 || x >= grid2[0].length || y >= grid2.length || grid2[y][x] == 0) {
            return res;
        } else if (grid1[y][x] == 0) {
            res = false;
        }

        grid2[y][x] = 0;
        for (int[] dir: dirs) {
            boolean tmp = isSubIsland(grid1, grid2, y + dir[0], x + dir[1]);
            res = res && tmp;
        }
        
        return res;
    }
}
