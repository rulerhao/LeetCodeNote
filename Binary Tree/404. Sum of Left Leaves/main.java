class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return getSumOfLeftLeaves(root);
    }
    
    int getSumOfLeftLeaves(TreeNode node) {
        if (node == null) return 0;
        
        int sum = 0;
        sum += getSumOfLeftLeaves(node.left);
        sum += getSumOfLeftLeaves(node.right);
        
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }
            
        return sum;
    }
}
