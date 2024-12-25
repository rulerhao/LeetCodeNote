# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        queue = deque()
        queue.append(root)
        res = []
        while queue:
            levelSize = len(queue)
            maximum = float('-inf')
            for i in range(levelSize):
                node = queue.popleft()
                maximum = max(node.val, maximum)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
            res.append(maximum)

        return res
