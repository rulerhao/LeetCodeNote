class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> temp = new Stack<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        
        backTracking(nums, 0);
        
        return result;
    }
    
    private void backTracking(int[] nums, int startPos) {
        result.add(new ArrayList<>(temp));
        if (startPos == nums.length) {
            return;
        }
        
        for (int i = startPos; i < nums.length; i++) {
            temp.push(nums[i]);
            backTracking(nums, i + 1);
            temp.pop();
        }
    }
}
