// dist[i]: distance of ith monster.
// speed[i]: speed of ith monster.
// Time Complexity: O(nLogn)
// Space Complexity: O(n)
// class Solution {
//     public int eliminateMaximum(int[] dist, int[] speed) {
//         if (dist.length == 0) return 0;

//         float[] reachTime = new float[dist.length];
//         for (int i = 0; i < dist.length; i++) {
//             reachTime[i] = (float) dist[i] / speed[i];
//         }
//         Arrays.sort(reachTime);
//         float nowTime = Integer.MIN_VALUE;
//         int count = 0;
//         int idx = 0;
//         while (idx < reachTime.length) {
//             if (reachTime[idx] <= idx) {
//                 break;
//             } else {
//                 count++;
//                 idx++;
//             }
//         }

//         return count;
//     }
// }

// Time Complexity: O(nLogn)
// Space Complexity: O(1)
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        if (dist.length == 0) return 0;

        for (int i = 0; i < dist.length; i++) {
            dist[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(dist);

        int count = 0;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= i) break;
            else {
                count++;
            }
        }

        return count;
    }
}
