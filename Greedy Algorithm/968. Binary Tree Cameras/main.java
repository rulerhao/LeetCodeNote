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

// Serach from leaf to root -> postorder.
// if (left == null && right == null) don't set camera.
// if (left || right is camera) node set as observed(2).

class Solution {
    int cameraCount = 0;
    
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        postorder(root);
        // Solve the root.
        if (root.left != null && (root.left.val == 0 || root.left.val == 1)) {
            
        } else if (root.right != null && (root.right.val == 0 || root.right.val == 1)) {
            
        } else {
            cameraCount++;
            root.val = 1;
        }
        return cameraCount;
    }
    
    private void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        if (root.left != null && root.left.val == 0) {
            root.val = 1; // set as camera
            cameraCount++;
            return;
        } else if (root.right != null && root.right.val == 0) {
            root.val = 1; // set as camera
            cameraCount++;
            return;
        }
        if (root.left != null && root.left.val == 1) {
            root.val = 2; // set as observed by camera.
            return;
        } else if (root.right != null && root.right.val == 1) {
            root.val = 2; // set as observed by camera.
            return;
        }
    }
}
