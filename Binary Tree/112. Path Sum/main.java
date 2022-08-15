class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sumExist(root, targetSum, 0);
    }
    
    boolean sumExist(TreeNode node, int targetSum, int nowSum) {
        if (node == null) return false;
        
        nowSum += node.val;
        if (node.left == null && node.right == null && targetSum == nowSum) {
            return true;
        }
        boolean left = sumExist(node.left, targetSum, nowSum);
        boolean right = sumExist(node.right, targetSum, nowSum);
        
        return left || right;
    }
}
