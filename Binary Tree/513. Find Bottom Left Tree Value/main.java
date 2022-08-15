class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);
        
        int result = 0;
        
        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size(); // size of each level(here calls row);
            
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = nodesQueue.poll();
                if (i == 0)
                    result = tempNode.val;
                
                if (tempNode.left != null) nodesQueue.add(tempNode.left);
                if (tempNode.right != null) nodesQueue.add(tempNode.right);
            }
        }
        
        return result;
    }
}
