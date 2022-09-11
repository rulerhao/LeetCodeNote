class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        getSubsequences(nums,0);
        return res;
    }
    
    private void getSubsequences(int[] nums, int start) {
        if(path.size() > 1){
            res.add(new ArrayList<>(path));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = start; i < nums.length; i++){
            if(!path.empty() && nums[i] < path.peek()){
                continue;
            }
            if (map.getOrDefault(nums[i], 0) >= 1){
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            path.push(nums[i]);
            getSubsequences(nums, i + 1);
            path.pop();
        }
    }
}
