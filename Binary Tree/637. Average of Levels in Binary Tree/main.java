class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Double> result = new ArrayList<>();
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        
        while (!nodes.isEmpty()) {
            List<Integer> nodesValInLevel = new ArrayList<>();
            int size = nodes.size();
            
            while (size > 0) {
                TreeNode node = nodes.poll();
                nodesValInLevel.add(node.val);
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
                size--;
            }
            result.add(getAverageOfIntegerList(nodesValInLevel));
        }
        return result;
    }
    
    private double getAverageOfIntegerList(List<Integer> list) {
        double sum = 0;
        for (int val: list) {
            sum += val;
        }
        return sum / list.size();
    }
}
