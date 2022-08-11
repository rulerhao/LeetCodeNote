class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inOrder(root);
    }
    
    List<Integer> inOrder(TreeNode node) {
        if (node == null) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<>();
        
        list.addAll(inOrder(node.left));
        list.add(node.val);
        list.addAll(inOrder(node.right));
        
        return list;
    }
}
