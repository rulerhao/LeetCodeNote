// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
        
//         // Get adjs
//         HashMap<Integer, List<int[]>> adjs = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             adjs.put(i + 1, new ArrayList<>());
//         }
//         for (int i = 0; i < times.length; i++) {
//             int pre = times[i][0];
//             int post = times[i][1];
//             int cost = times[i][2];
//             List<int[]> adj = adjs.getOrDefault(pre, new ArrayList<>());
//             adj.add(new int[] {post, cost});
//             adjs.put(pre, adj);
//         }
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(k);
//         HashSet<Integer> visited = new HashSet<>();
//         int sum = 0;
//         while (!queue.isEmpty()) {
//             int node = queue.poll();
//             if (visited.contains(node)) continue;
//             visited.add(node);
//             List<int[]> adj = adjs.get(node);
//             for (int i = 0; i < adj.size(); i++) {
//                 int[] adjThing = adj.get(i);
//                 int nextNode = adjThing[0];
//                 if (visited.contains(nextNode)) continue;
//                 sum += adjThing[1];
//                 queue.add(nextNode);
//             }
//         }
        
//         if (visited.size() == n) return sum;
//         return -1;
//     }
// }

// Bellman Ford ALgorithm
// Time Complexty (n * t) | Space Complexity O(n) where t is the length of times
class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[k - 1] = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < times.length; j++) {
                int src = times[j][0];
                int tgt = times[j][1];
                int cost = times[j][2];
                if (costs[src - 1] != Integer.MAX_VALUE) {
                    costs[tgt - 1] = Math.min(costs[tgt - 1], costs[src - 1] + cost);
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, costs[i]);
        }
        
        return result;
    }
}
