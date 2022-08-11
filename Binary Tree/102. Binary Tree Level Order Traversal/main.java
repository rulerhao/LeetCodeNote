class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
    
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root); // offer the root.
        
        while (!nodeQueue.isEmpty()) {
            List<Integer> nodesInLevel = new ArrayList<>(); // all nodes in this level.
            int numberOfSon = nodeQueue.size();
            while (numberOfSon > 0) {
                TreeNode node = nodeQueue.poll();
                nodesInLevel.add(node.val);
                if (node.left != null) nodeQueue.offer(node.left);
                if (node.right != null) nodeQueue.offer(node.right);
                numberOfSon--;
            }
            result.add(nodesInLevel); // add nodes to result 
        }
        
        return result;
    }
}
