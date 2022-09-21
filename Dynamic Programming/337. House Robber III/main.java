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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        int[] profit = doRob(root);
        return Math.max(profit[0], profit[1]);
    }
    
    private int[] doRob(TreeNode root) {
        int[] profit = new int[2]; // 0: no rob in this node, 1: rob in this node.
        if (root == null) return profit;
        
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        
        profit[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        profit[1] = left[0] + right[0] + root.val;
        
        return profit;
    }
}
