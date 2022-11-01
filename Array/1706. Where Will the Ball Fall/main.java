class Solution {
    public int[] findBall(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return new int[0];
        else if (grid[0].length == 1) return new int[]{-1};
        
        int[] arr = new int[grid[0].length];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int x = arr[j];
                if (x == -1) continue;
                if (x == arr.length - 1 && grid[i][x] == 1) {
                    arr[j] = -1;
                    continue;
                } else if (x == 0 && grid[i][x] == -1) {
                    arr[j] = -1;
                    continue;
                }
                
                if (grid[i][x] == 1) {
                    if (grid[i][x + 1] == -1) {
                        arr[j] = -1;
                    } else {
                        arr[j] = x + 1;
                    }
                } else if (grid[i][x] == -1) {
                    if (grid[i][x - 1] == 1) {
                        arr[j] = -1;
                    } else {
                        arr[j] = x - 1;
                    }
                }
            }
        }
        return arr;
    }
}
