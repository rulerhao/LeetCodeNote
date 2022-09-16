// Each turn, choose 2 to smash with x, y weights (x <= y)
// if x == y -> destroyed them
// if x != y -> x = 0, y = y - x.
// At the end, left only 1 stone.
// Return smallest weight of the left one.

// Try to put stones to two set that two set would get the closest weight.
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = dp.length - 1; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        
        return sum - 2 * dp[dp.length - 1];
    }
}
