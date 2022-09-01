class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] flag;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        
        flag = new boolean[candidates.length];
        
        Arrays.sort(candidates);
        
        backTracking(candidates, 0, target, 0);
        
        return result;
    }
    
    private void backTracking(int[] candidates, int startPos, int target, int sum) {
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        
        for (int i = startPos; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i] && !flag[i - 1]) {
                continue;
            }
            
            sum += candidates[i];
            if (sum > target) {
                sum -= candidates[i];
                break;
            }
            flag[i] = true;
            path.add(candidates[i]);
            backTracking(candidates, i + 1, target, sum);
            sum -= candidates[i];
            path.removeLast();
            flag[i] = false;
        }
    }
}
