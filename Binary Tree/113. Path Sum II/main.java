class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        
        return getMatchPath(root, targetSum, 0, new ArrayList<>());
    }
    
    private List<List<Integer>> getMatchPath(TreeNode node, int targetSum, int nowSum, List<Integer> path) {
        if (node == null) return new ArrayList<>();
        
        path.add(node.val);
        nowSum += node.val;
        
        List<List<Integer>> pathList = new ArrayList<>();
        
        pathList.addAll(getMatchPath(node.left, targetSum, nowSum, path));
        pathList.addAll(getMatchPath(node.right, targetSum, nowSum, path));
        
        if (node.left == null && node.right == null && targetSum == nowSum) {
            pathList.add(new ArrayList<>(path));
        }
        
        path.remove(path.size() - 1);
        
        return pathList;
    }
}
