class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        
        while (!nodes.isEmpty()) {
            List<Integer> nodesOfLevel = new ArrayList<>();
            int size = nodes.size();
            while (size > 0) {
                TreeNode node = nodes.poll();
                nodesOfLevel.add(node.val);
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
                size--;
            }
            result.add(nodesOfLevel);
        }
        Collections.reverse(result);
        
        return result;
    }
}
