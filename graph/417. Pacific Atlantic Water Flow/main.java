public class Solution {
    boolean[][] pacific;
    boolean[][] atlantic;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        
        int width = matrix[0].length;
        int height = matrix.length;
        
        pacific = new boolean[height][width];
        atlantic = new boolean[height][width];
        
        // Search the cell from each cells which adjacent to ocean
        for (int i = 0; i < width; i++) {
            dfs(matrix, pacific, 0, 0, i);
            dfs(matrix, atlantic, 0, height - 1, i);
        }
        for (int i = 0; i < height; i++) {
            dfs(matrix, pacific, 0, i, 0);
            dfs(matrix, atlantic, 0, i, width - 1);
        }
        
        // Travel all element, if it's pacific and atlantic is true than we add it to reuslt.
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = Arrays.asList(i, j);
                    result.add(temp);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] matrix, boolean[][] state, int height, int i, int j) {
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[i].length - 1 || state[i][j]) return;
        int nowHeight = matrix[i][j];
        if (nowHeight < height) return;
        state[i][j] = true;
        
        dfs(matrix, state, nowHeight, i, j + 1);
        dfs(matrix, state, nowHeight, i + 1, j);
        dfs(matrix, state, nowHeight, i, j - 1);
        dfs(matrix, state, nowHeight, i - 1, j);
    }
}
