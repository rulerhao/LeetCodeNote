class Solution {
    
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        sum = 0;
        converBSTRML(root);
        return root;
    }
    
    private void converBSTRML(TreeNode root) {
        if (root == null) return;
        
        // right
        converBSTRML(root.right);
        
        // middle
        sum = sum + root.val;
        root.val = sum;
        
        // left
        converBSTRML(root.left);
    }
}
