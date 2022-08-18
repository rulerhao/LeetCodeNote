class Solution {
    // 递归
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        // left
        if (!isValidBST(root.left)) return false;
        
        // middle
        if (max != null && max.val >= root.val) return false;
        max = root;
        
        // right
        return isValidBST(root.right);
    }
}
