class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += cardPoints[i];
        }
        int sum = max;
        for (int i = k - 1; i >= 0; i--) {
            sum = sum - cardPoints[i] + cardPoints[cardPoints.length - 1 + i - k + 1];
            max = Math.max(max, sum);
        }

        return max;
    }
}
