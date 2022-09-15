class Solution {
    public int monotoneIncreasingDigits(int n) {
        String numString = String.valueOf(n);
        char[] numChars = numString.toCharArray();
        
        int nineLeftIndex = numChars.length - 1;
        for (int i = numChars.length - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                if (numChars[i - 1] - '0' > numChars[i] - '0') {
                    numChars[i - 1] = (char) (numChars[i - 1] - '0' - 1 + '0');
                    for (int j = nineLeftIndex; j >= i; j--) {
                        numChars[j] = '9';
                        nineLeftIndex = j - 1;
                    }
                }
            }
        }
    
        int result = 0;
        int multi = 1;
        for (int i = numChars.length - 1; i >= 0; i--) {
            result = result + (numChars[i] - '0') * multi;
            multi = multi * 10;
        }
        
        return result;
    }
}
