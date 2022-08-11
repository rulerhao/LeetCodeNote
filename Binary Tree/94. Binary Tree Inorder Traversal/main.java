class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        
        return result;
    }
    
    void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
