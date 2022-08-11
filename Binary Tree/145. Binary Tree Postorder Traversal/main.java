class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        
        return result;
    }
    
    void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}
