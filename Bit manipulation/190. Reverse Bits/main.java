public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                if (i == 0) {
                    result = result + 1;
                } else {
                    result = result << 1;
                    result = result + 1;
                }
            } else {
                if (i == 0) {
                    
                } else {
                    result = result << 1;
                }
            }
            n = n >> 1;
        }
        
        return result;
    }
}
