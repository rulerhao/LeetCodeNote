class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        
        boolean isPositive = x > 0;
        
        int absX = Math.abs(x);
        
        int num = 0;
        
        while (absX > 0) {
            if (Integer.MAX_VALUE / 10 < num) return 0;
            
            num = num * 10 + absX % 10;
            absX = absX / 10;
        }
        
        if (isPositive) return num;
        else return - num;
    }
}
