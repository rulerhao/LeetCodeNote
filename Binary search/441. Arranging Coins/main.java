class Solution {
    public int arrangeCoins(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 1;
        else if (n == 3) return 2;

        long left = 1;
        long right = n / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = (1 + mid) * mid / 2;
            if (sum == n) {
                return (int) mid;
            } else if (sum > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) right;
    }
}
