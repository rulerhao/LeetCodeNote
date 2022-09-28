class Solution {
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> req = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++)
            req.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; i++)
            req.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0)
                if (isCyclic(req, i)) return false;
        }
        return true;
    }
    
    private boolean isCyclic(List<List<Integer>> req, int cur) {
        if (visited[cur] == 1) return true; // walked
        visited[cur] = 1; // Set it as walked
        
        for (int i = 0; i < req.get(cur).size(); i++) {
            if (visited[req.get(cur).get(i)] != 2) {
                if (isCyclic(req, req.get(cur).get(i))) return true;
            }
        }
        
        visited[cur] = 2; // Set it as no cyclic node.
        
        return false;
    }
}
