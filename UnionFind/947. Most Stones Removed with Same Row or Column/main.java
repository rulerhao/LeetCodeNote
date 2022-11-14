// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    
    private static class UnionFind {
        int[] parent;
        int count;
        public UnionFind(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            count = N;
        }
        public void union(int i, int j) {
            int parent1 = find(i);
            int parent2 = find(j);
            if (parent1 != parent2) {
                parent[parent2] = parent1;
                count--;
            }
        }
        private int find(int i) {
            while (parent[i] != i) {
                i = parent[parent[i]];
            }
            return i;
        }
    }
    
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        UnionFind uf = new UnionFind(stones.length);
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            rowMap.putIfAbsent(row, new ArrayList<>());
            colMap.putIfAbsent(col, new ArrayList<>());
            rowMap.get(row).add(i);
            colMap.get(col).add(i);
        }
        for (int key : rowMap.keySet()) {
            List<Integer> ls = rowMap.get(key);
            int parent = ls.get(0);
            for (int i = 1; i < ls.size(); i++) {
                uf.union(parent, ls.get(i));
            }
        }
        for (int key : colMap.keySet()) {
            List<Integer> ls = colMap.get(key);
            int parent = ls.get(0);
            for (int i = 1; i < ls.size(); i++) {
                uf.union(parent, ls.get(i));
            }
        }
        return stones.length - uf.count;
    }
    
}
