class Solution {

    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // pre, post
        HashMap<Integer, List<Integer>> nextNums = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int post = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> postList = nextNums.getOrDefault(pre, new ArrayList<Integer>());
            postList.add(post);
            nextNums.put(pre, postList);
        }
        
        int[] reqNums = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            reqNums[prerequisites[i][0]]++;
        }
        
        Queue<Integer> startNodes = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (reqNums[i] == 0) startNodes.add(i);
        }
        
        int[] result = new int[numCourses];
        int i = 0;
        while (!startNodes.isEmpty()) {
            int node = startNodes.poll();
            result[i] = node;
            i++;
            if (nextNums.get(node) != null) {
                for (int j = 0; j < nextNums.get(node).size(); j++) {
                    reqNums[nextNums.get(node).get(j)]--;
                    if (reqNums[nextNums.get(node).get(j)] == 0) startNodes.add(nextNums.get(node).get(j));
                } 
            }
        }
        
        if (i == numCourses) return result;
        
        return new int[0];
    }
}
