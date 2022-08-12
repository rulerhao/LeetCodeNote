class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<Node> nodes = new LinkedList();
        nodes.offer(root);
        
        while (!nodes.isEmpty()) {
            List<Integer> nodesValInLevel = new ArrayList<>();
            int size = nodes.size();
            
            while (size > 0) {
                Node node = nodes.poll();
                nodesValInLevel.add(node.val);
                
                if (node.children != null) {
                    for (Node childNode: node.children) {
                        nodes.add(childNode);
                    }
                }
                size--;
            }
            result.add(nodesValInLevel);
        }
        
        return result;
    }
}
