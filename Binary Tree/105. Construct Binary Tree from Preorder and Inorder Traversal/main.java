class Solution {
    
    Map<Integer, Integer> map; // Save inorder index element. Makes search more quickly (Because search in array need O(n) but map just need O(1)).
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return getTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    private TreeNode getTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preEnd || inStart >= inEnd) {
            return null;
        }
        
        int rootIndex = map.get(preorder[preStart]);
        int leftLen = rootIndex - inStart;
        TreeNode node = new TreeNode(inorder[rootIndex]);
        node.left = getTree(preorder, preStart + 1, preStart + 1 + leftLen,
                            inorder, inStart, rootIndex);
        node.right = getTree(preorder, preStart + leftLen + 1, preEnd, 
                             inorder, rootIndex + 1, inEnd);
        
        return node;
    }
}
