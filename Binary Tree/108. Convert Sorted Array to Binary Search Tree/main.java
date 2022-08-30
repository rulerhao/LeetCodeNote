class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBstImpl(nums, 0, nums.length);
    }
    
    private TreeNode sortedArrayToBstImpl(int[] nums, int left, int right) { // left and right means index of left and right
        if (nums == null || nums.length == 0) return null;
        
        if (left >= right) return null;
        
        int center = (left + right) / 2; // index of the center;
        TreeNode node = new TreeNode(nums[center]);
        node.left = sortedArrayToBstImpl(nums, left, center);
        node.right = sortedArrayToBstImpl(nums, center + 1, right);
        
        return node;
    }
}
