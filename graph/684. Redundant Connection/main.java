class Solution {

    int[] parents;
    
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length];
        for (int i = 0; i < edges.length; i++) parents[i] = i + 1;
        for (int[] edge: edges) {
            if (find(edge[0]) == find(edge[1])) return edge;
            else union(edge[0], edge[1]);
        }
        
        return new int[2];
    }
    
    private int find(int num) {
        if (num == parents[num - 1]) return parents[num - 1];
        return find(parents[num - 1]);
    }
    
    private void union(int num1, int num2) {
        parents[find(num2) - 1] = find(num1);
    }
    
}
