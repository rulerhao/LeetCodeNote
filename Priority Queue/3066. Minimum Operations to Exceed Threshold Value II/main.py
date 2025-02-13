class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        pq = []
        for i in range(len(nums)):
            heappush(pq, nums[i])

        res = 0
        while len(pq) >= 2:
            num1 = heappop(pq)
            if num1 >= k:
                return res
            num2 = heappop(pq)
            heappush(pq, num1 * 2 + num2)
            res += 1
        
        return res
        
