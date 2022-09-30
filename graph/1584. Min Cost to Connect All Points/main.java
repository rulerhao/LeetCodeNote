class Solution {

    // Time Complexity: O(N^2 log(N)) where N is the length of points. N^2 comes from the fact we need to find the distance between a currNode and every other node to pick the shortest distance. log(N) comes from Priority Queue
    // Space Complexity: O(N^2)
    public int minCostConnectPoints(int[][] points) {
        // Each time we add new node we will sort it by weight. The lower would be the front.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        HashSet<Integer> visited = new HashSet<>();
        
        pq.add(new int[] {0, 0});
        
        int lineNum = 0;
        int sum = 0;
        while (!pq.isEmpty() && lineNum != points.length) {
            int[] node = pq.poll();
            
            int weight = node[0];
            int index = node[1];
            
            if (visited.contains(index)) continue;
            
            lineNum++;
            visited.add(index);
            sum += weight;
            
            for (int i = 0; i < points.length; i++) {
                int nextWeight = Math.abs(points[index][0] - points[i][0]) + Math.abs(points[index][1] - points[i][1]);
                pq.add(new int[] {nextWeight, i});
            }
        }
        
        return sum;
    }
}
