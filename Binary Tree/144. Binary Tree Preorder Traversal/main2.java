class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preOrder(root);
    }
    
    List<Integer> preOrder(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<>();
        
        list.add(root.val);
        list.addAll(preOrder(root.left));
        list.addAll(preOrder(root.right));
        
        return list;
    }
}
