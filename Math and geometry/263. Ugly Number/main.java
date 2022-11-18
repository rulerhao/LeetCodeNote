class Solution {
    // public boolean isUgly(int n) {
    //     if (n == 1) return true;
    //     else if (n == 0) return false;

    //     int[] div = new int[]{2, 3, 5};
    //     int i = 0;

    //     while (n != 1) {
    //         int rem = n % div[i];
    //         n /= div[i];
    //         if (rem != 0) {
    //             n *= div[i];
    //             i++;
    //             if (i == 3) return false;
    //         }
    //     }
    //     if (n == 1) return true;
    //     return false;
    // }

    public boolean isUgly(int n) {
        if (n <= 0){
            return false;
        }
        while (n > 0 && n % 5 == 0){
            n /= 5;
        }
        while (n > 0 && n % 3 == 0){
            n /= 3;
        }
        while (n > 0 && n % 2 == 0){
            n /= 2;
        }

        return n == 1;
    }
}
