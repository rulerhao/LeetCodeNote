class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            result[i] = getOneNumber(i);
        }
        
        return result;
    }
    
    private int getOneNumber(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        
        return count;
    }
}
