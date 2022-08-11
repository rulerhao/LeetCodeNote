class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        List<List<Integer>> nodesSortByLevel = new ArrayList<>();
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> nodesInLevel = new ArrayList<>();
            while (size > 0) {
                TreeNode node = nodes.poll();
                nodesInLevel.add(node.val);
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
                size--;
            }
            nodesSortByLevel.add(nodesInLevel);
        }
        
        for (List<Integer> nodesInLevel: nodesSortByLevel) {
            result.add(nodesInLevel.get(nodesInLevel.size() - 1));
        }
        
        return result;
    }
}
