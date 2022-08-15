class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        return getRoute(root, new ArrayList<>());
    }
    
    List<String> getRoute(TreeNode node, List<TreeNode> parents) {
        if (node == null) return new ArrayList<>();
        
        parents.add(node);
        
        List<String> routes = new ArrayList<>();
        if (node.left != null) routes.addAll(getRoute(node.left, parents));
        if (node.right != null) routes.addAll(getRoute(node.right, parents));
        
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < parents.size() - 1; i++) {
                sb.append(parents.get(i).val).append("->");
            }
            sb.append(parents.get(parents.size() - 1).val);
            routes.add(sb.toString());
        }
        
        parents.remove(parents.size() - 1);
        
        return routes;
    }
}
