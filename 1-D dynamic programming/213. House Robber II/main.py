class Solution:
    def rob(self, nums: List[int]) -> int:
        # prev1, prev0, curr
        prev0 = 0
        prev1 = 0
        curr = 0
        for i in range(len(nums)):
            num = nums[i]
            if i == 0:
                curr = num
                prev0 = num
            elif i == 1:
                prev0 = curr
                curr = prev0
            elif i == len(nums) - 1:
                prev1 = prev0
                prev0 = curr
                curr = prev0
            else:
                prev1 = prev0
                prev0 = curr
                curr = max(prev1 + num, prev0)

        res0 = curr

        for i in range(len(nums)):
            num = nums[i]
            if i == 0:
                curr = 0
                continue
            elif i == 1:
                prev0 = curr
                curr = num
                continue
            else:
                prev1 = prev0
                prev0 = curr
                curr = max(prev1 + num, prev0)
        
        res1 = curr

        return max(res0, res1)
