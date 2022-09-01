class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        
        Arrays.sort(candidates);
        
        backTracking(candidates, target, 0, 0);
        
        return result;
    }
    
    private void backTracking(int[] candidates, int target, int sum, int startPos) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        
        for (int i = startPos; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) break;
            path.add(candidates[i]);
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
