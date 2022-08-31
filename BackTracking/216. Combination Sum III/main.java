class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        
        return result;
    }
    
    private void backTracking(int target, int k, int startIndex, int sum) {
        if (sum > target) return;
        
        if (path.size() == k) {
            if (sum == target) result.add(new ArrayList<>(path));
            return;
        }
        
        int max = 9 - (k - path.size()) + 1;
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
			path.add(i);
			sum += i;
			backTracking(target, k, i + 1, sum);
			path.removeLast();
			sum -= i;
		}
    }
}
