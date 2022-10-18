class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] newDigits = new int[len + 1];
        boolean firstTime = true;
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            int sum;
            if (firstTime) {
                sum = digits[i] + 1;
                firstTime = false;
            } else sum = digits[i] + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            digits[i] = sum;
            newDigits[i + 1] = digits[i];
        }
        
        if (carry == 1) {
            newDigits[0] = 1;
            return newDigits;
        }
        
        return digits;
    }
}
