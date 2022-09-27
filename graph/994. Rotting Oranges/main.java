class Solution {
    
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Queue<int[]> ros = new LinkedList<>();
        
        int n = grid[0].length;
        int m = grid.length;
        
        int freshNumber = 0;
        // Get the rotten and fresh oranges information.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    ros.offer(new int[] {i, j});
                else if (grid[i][j] == 1)
                    freshNumber++;
            }
        }
        
        int minute = 0;
        while (!ros.isEmpty() && freshNumber != 0) {
            int roNumber = ros.size();
            minute++;
            for (int i = 0; i < roNumber; i++) {
                int[] ro = ros.poll();
                for (int j = 0; j < 4; j++) {
                    int x = ro[1] + dirs[j][1];
                    int y = ro[0] + dirs[j][0];
                    if (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1 && grid[y][x] == 1) {
                        grid[y][x] = 2;
                        ros.offer(new int[] {y, x});
                        freshNumber--;
                    }
                }
            }
        }
        
        if (freshNumber == 0) return minute;
        else return -1;
    }
}
