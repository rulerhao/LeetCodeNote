class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;
        if (root.val == val) {
            return root;
        }
        
        TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        }
        return searchBST(root.right, val);
    }
}
