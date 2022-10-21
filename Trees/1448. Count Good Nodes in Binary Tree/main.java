/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int count = 0;
    
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode root, int largestVal) {
        if (root == null) return 0;
        
        int left = dfs(root.left, Math.max(largestVal, root.val));
        int right = dfs(root.right, Math.max(largestVal, root.val));
        
        int count = left + right + (root.val >= largestVal ? 1 : 0);
        
        return count;
    }
}
