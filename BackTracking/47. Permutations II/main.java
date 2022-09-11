class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums);
        return result;
    }

    private void backTrack(int[] nums) {
        // If fill path by nums
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，樹枝 nums[i - 1] 用過
            // used[i - 1] == false，樹層 nums[i - 1] 用過，跳過
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 樹枝 nums[i] 没用過
            if (!used[i]) {
                used[i] = true;
                path.push(nums[i]);
                backTrack(nums);
                path.pop();
                used[i] = false;
            }
        }
    }
}
