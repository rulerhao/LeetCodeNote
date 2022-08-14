// BFS
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int level = 0;
        
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);
        
        while (!nodesQueue.isEmpty()) {
            level++;
            int size = nodesQueue.size();
            
            TreeNode tempNode = nodesQueue.poll();
            while (size > 0) {
                if (tempNode.left == null && tempNode.right == null) return level;
                if (tempNode.left != null) nodesQueue.offer(tempNode.left);
                if (tempNode.right != null) nodesQueue.offer(tempNode.right);
                if (size != 1) tempNode = nodesQueue.poll();
                size--;
            }
        }
        
        return level;
    }
}
