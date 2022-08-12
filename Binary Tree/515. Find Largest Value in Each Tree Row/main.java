class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // Handle exception
        if (root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> tempNodes = new LinkedList<>(); // Save the nodes which is unprocessed.
        tempNodes.offer(root);
        
        while (!tempNodes.isEmpty()) {
            int maxValInLevel = Integer.MIN_VALUE;
            int size = tempNodes.size();
            
            while (size > 0) {
                TreeNode tempNode = tempNodes.poll();
                if (tempNode.val > maxValInLevel) maxValInLevel = tempNode.val;
                if (tempNode.left != null) tempNodes.add(tempNode.left);
                if (tempNode.right != null) tempNodes.add(tempNode.right);
                size--;
            }
            result.add(maxValInLevel);
        }
        
        return result;
    }
}
