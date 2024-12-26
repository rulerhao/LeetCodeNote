class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # memo = {}
        # def bt(index, current_sum):
        #     if index == len(nums):
        #         return 1 if current_sum == target else 0
            
        #     #check cache
        #     if (index, current_sum) in memo:
        #         return memo[(index, current_sum)]
            
        #     addition = bt(index+1, current_sum + nums[index])
        #     subtract = bt(index+1, current_sum - nums[index])

        #     #add to cache
        #     memo[(index, current_sum)] = addition +subtract

        #     return addition + subtract
        
        # return bt(0, 0)

        # @cache
        # def dfs(idx, sum) -> int:
        #     if idx == len(nums):
        #         if sum == target:
        #             return 1
        #         else:
        #             return 0
        #     return dfs(idx + 1, sum + nums[idx]) + dfs(idx + 1, sum - nums[idx])

        # return dfs(0, 0)

        # Backtracking, Memory, Dfs
        def dfs(idx, sum) -> int:
            if (idx, sum) in memo:
                return memo[(idx, sum)]

            if idx == len(nums):
                if sum == target:
                    return 1
                else:
                    return 0

            memo[(idx, sum)] = dfs(idx + 1, sum + nums[idx]) + dfs(idx + 1, sum - nums[idx])

            return memo[(idx, sum)]

        memo = {}

        return dfs(0, 0)
