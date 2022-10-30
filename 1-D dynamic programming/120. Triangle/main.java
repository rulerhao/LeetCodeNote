// class Solution {
    
//     private int res;
    
//     public int minimumTotal(List<List<Integer>> triangle) {
//         res = 0;
//         return travel(triangle, 0, 0);
//     }
    
//     private int travel(List<List<Integer>> triangle, int i, int j) {
//         if (i >= triangle.size()) return 0;
        
//         int val = triangle.get(i).get(j);
//         return triangle.get(i).get(j) + Math.min(travel(triangle, i + 1, j), travel(triangle, i + 1, j + 1));
//     }
// }

class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return A[0];
    }
}
