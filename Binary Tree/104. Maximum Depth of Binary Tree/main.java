class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int result = 0;
        
        Queue<TreeNode> nodesQueue = new LinkedList<>(); // unsolved nodes.
        nodesQueue.offer(root);
        
        while (!nodesQueue.isEmpty()) {
            result++;
            int size = nodesQueue.size(); // the size means size in each level;
            TreeNode tempNode = nodesQueue.poll();
            while (size > 0) {
                if (tempNode.left != null) nodesQueue.offer(tempNode.left);
                if (tempNode.right != null) nodesQueue.offer(tempNode.right);
                if (size != 1) {
                    tempNode = nodesQueue.poll();
                }
                size--;
            }
        }
        
        return result;
    }
}
