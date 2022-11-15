/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    boolean find = false;
    int missCount = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode tmp = root;
        int totalLevelNum = 0;
        while (tmp != null) {
            totalLevelNum++;
            tmp = tmp.left;
        }

        dfs(root, 0, totalLevelNum);
        return (int) Math.pow(2, totalLevelNum) - 1 - missCount;
    }

    private void dfs(TreeNode root, int level, int totalLevelNum) {
        if (root == null) {
            missCount++;
            return;
        }
        if (level + 1 == totalLevelNum) {
            find = true;
            return;
        }
        dfs(root.right, level + 1, totalLevelNum);
        if (find) return;
        dfs(root.left, level + 1, totalLevelNum);
        if (find) return;
    }
}
