class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            result.add(path);
            return result;
        }
        
        Arrays.sort(nums); // n log(n)
        backTracking(nums, 0);
        
        return result;
    }
    
    private void backTracking(int[] nums, int startPos) {
        result.add(new ArrayList<>(path));
        if (startPos == nums.length) {
            return;
        }
        for (int i = startPos; i < nums.length; i++) {
            if (i > startPos && nums[i - 1] == nums[i]) {
                continue;
            }
            path.push(nums[i]);
            backTracking(nums, i + 1);
            path.pop();
        }
    }
}
