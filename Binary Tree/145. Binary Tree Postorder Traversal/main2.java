class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postOrder(root);
    }
    
    List<Integer> postOrder(TreeNode node) {
        if (node == null) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<>();
        list.addAll(postOrder(node.left));
        list.addAll(postOrder(node.right));
        list.add(node.val);
        return list;
    }
}
