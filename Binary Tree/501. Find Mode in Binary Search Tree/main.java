class Solution {
    ArrayList<Integer> list;
    int maxCount;
    int count;
    TreeNode pre;
    
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        
        list = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        
        findModeImp(root);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private void findModeImp(TreeNode node) {
        if (node == null) return;
        
        // left
        findModeImp(node.left);
        
        // middle
        if (pre == null || pre.val != node.val) count = 1;
        else if (pre.val == node.val) {
            count++;
        }
        
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(node.val);
        } else if (count == maxCount) list.add(node.val);
        pre = node;
        
        // right
        findModeImp(node.right);
    }
}
