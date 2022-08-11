class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        
        return result;
    }
    
    void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
