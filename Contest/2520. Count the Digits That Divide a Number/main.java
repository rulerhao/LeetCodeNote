class Solution {
    public int countDigits(int num) {
        int count = 0;
        System.out.println("---------------");
        int temp = num;
        while (temp > 0) {
            int mod = temp % 10;
            if (num % mod == 0) {
                count++;
            }
            temp /= 10;
        }
        
        return count;
    }
}
