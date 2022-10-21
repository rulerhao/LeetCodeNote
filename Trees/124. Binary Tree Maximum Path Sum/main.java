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

    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumNode(root);
        return res;
    }

    public int maxPathSumNode(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, maxPathSumNode(root.left));
        int right = Math.max(0, maxPathSumNode(root.right));
        res = Math.max(res, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
