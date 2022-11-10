// Time Complexity: O(n^2)
// Space Complexity: O(1)
// class Solution {
//     public int removeCoveredIntervals(int[][] intervals) {
//         for (int i = 0; i < intervals.length; i++) {
//             for (int j = i + 1; j < intervals.length; j++) {
//                 if (intervals[i][0] == -1 && intervals[i][1] == -1) break;
//                 else if (intervals[j][0] == -1 && intervals[j][1] == -1) continue;

//                 if (intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]) {
//                     intervals[j] = new int[]{-1, -1};
//                 } else if (intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]) {
//                     intervals[i] = new int[]{-1, -1};
//                 }
//             }
//         }

//         int count = 0;
//         for (int i = 0; i < intervals.length; i++) {
//             if (intervals[i][0] != -1 && intervals[i][1] != -1) {
//                 count++;
//             }
//         }

//         return count;
//     }
// }

// Time Complexity: O(nLogn)
// Space Complexity: O(1)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; 
            else return a[0] - b[0];
        });
            
        int idx = 0;
        int removed = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[idx][0] && intervals[i][1] <= intervals[idx][1]) {
                removed++;
                continue;
            }
            if (intervals[i][1] >= intervals[idx][1]) {
                idx = i;
            }
        }

        return intervals.length - removed;
    }
}
