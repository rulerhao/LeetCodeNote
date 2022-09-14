// 1. ratings mean each children's rate
// 2. Each child has at least 1.
// 3. Higher rating more than neighbor.

// Solve:
// find lowest rate and give him 1.
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        
        int sum = 0;
        int[] candyNums = new int[ratings.length];
        
        candyNums[0] = 1;
        
        // From left to right.
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyNums[i] = candyNums[i - 1] + 1;
            } else {
                candyNums[i] = 1;
            }
        }
        
        // From right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyNums[i] = Math.max(candyNums[i], candyNums[i + 1] + 1);
            }
        }
        
        // Get sum
        for (int i = 0; i < ratings.length; i++) {
            sum = sum + candyNums[i];
        }
        
        return sum;
    }
}
