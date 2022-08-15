class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        return dfs(root);
    }
    
    TreeNode dfs(TreeNode node) {
        if (node == null) return null;
        
        TreeNode temp = node.left;
        node.left = dfs(node.right);
        node.right = dfs(temp);
        
        return node;
    }
}
