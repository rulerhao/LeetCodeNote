// Time Complexity: O(nLogn)
// Space Complexity: O(n)
// class Solution {

//     public int twoCitySchedCost(int[][] costs) {
//         int[][] diff = new int[costs.length][2];

//         for (int i = 0; i < costs.length; i++) {
//             diff[i][0] = costs[i][1] - costs[i][0];
//             diff[i][1] = i;
//         }

//         Arrays.sort(diff, (a, b) -> a[0] - b[0]);
//         for (int i = 0; i < costs.length; i++) {
//             System.out.println(diff[i][0]);
//         }
//         int result = 0;
//         for (int i = 0; i < costs.length; i++) {
//             int idx = diff[i][1];
//             if (i < costs.length / 2) {
//                 result += costs[idx][1];
//             } else {
//                 result += costs[idx][0];
//             }
//         }

//         return result;
//     }

// }

// Time Complexity: O(nLogn)
// Space Complexity: O(1) -- optimized memory usage from the above.
class Solution {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int result = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                result += costs[i][1];
            } else {
                result += costs[i][0];
            }
        }

        return result;
    }

}
