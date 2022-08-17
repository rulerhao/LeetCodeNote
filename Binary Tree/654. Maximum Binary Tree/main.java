class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildMBT(nums, 0, nums.length);
    }

    public TreeNode buildMBT(int[] nums, int leftIndex, int rightIndex) {
        if (nums == null) return null;
        if (rightIndex - leftIndex < 1) return null; // no elements
        if (rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]); // only 1 element
        
        int maxIndex = leftIndex;
        int maxVal = nums[maxIndex];
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }
        
        TreeNode node = new TreeNode(maxVal);
        node.left = buildMBT(nums, leftIndex, maxIndex);
        node.right = buildMBT(nums, maxIndex + 1, rightIndex);
        
        return node;
    }
}
