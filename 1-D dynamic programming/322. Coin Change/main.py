class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [10 ** 4 + 1] * (amount + 1)
        dp[0] = 0
        for i in range(len(dp)):
            for j in range(len(coins)):
                if i >= coins[j]:
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)
        
        if dp[-1] == 10 ** 4 + 1:
            return -1
        return dp[-1]
                    
