class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        
        used = new boolean[nums.length];
        
        nextStage(nums);
        
        return result;
    }
    
    private void nextStage(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.push(nums[i]);
            used[i] = true;
            nextStage(nums);
            used[i] = false;
            path.pop();
        }
    }
}
