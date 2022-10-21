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

// left mid right
class Solution {
    
    int kth = 0;
    int kthNum;
    
    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return kthNum;
    }
    
    private void search(TreeNode root, int k) {
        if (root == null) return;
        
        search(root.left, k);
        kth++;
        if (kth == k) kthNum = root.val;
        search(root.right, k);
        
    }
}
