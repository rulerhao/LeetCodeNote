class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        else if (n == 1) return x;
        if (n < 0) {
            if (n % 2 == 0) {
                n = n / 2; //We're doing this because if I do -N and N=Integer.MIN_VALUE it'll become a value which is greater than the max value of Integer.MAX_VALUE
                n = - n;
                x = 1 / x / x;
            } else {
                x = 1 / x;
                n = - n;
            }
        }
        if (n % 2 == 0) {
            x = x * x;
            n = n / 2;
        } else {
            return x * myPow(x, n - 1);
        }
        return myPow(x, n);
    }
}
