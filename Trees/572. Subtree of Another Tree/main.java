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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return searchSubTree(root, subRoot);
    }
    
    private boolean searchSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }
        
        if (checkSame(root, subRoot)) {
            return true;
        }
        
        boolean left = searchSubTree(root.left, subRoot);
        boolean right = searchSubTree(root.right, subRoot);
        
        return left || right;
    }
        
    private boolean checkSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }
        
        if (root.val == subRoot.val) {
            boolean left = checkSame(root.left, subRoot.left);
            boolean right = checkSame(root.right, subRoot.right);
            return left && right;
        }
        
        return false;
    }
}
