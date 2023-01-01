class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primeList = new LinkedList<>();
        
        for (int i = left; i <= right; i++) {
            if (checkPrime(i)) {
                primeList.add(i);
            }
        }
        
        int closestSize = Integer.MAX_VALUE;
        int resultPre = -1;
        int resultPost = -1;
        int pre = -1;
        int post = -1;
        for (int num: primeList) {
            if (pre == -1 && post == -1) {
                pre = post;
                post = num;
            } else {
                pre = post;
                post = num;
                
                if (post - pre < closestSize) {
                    resultPre = pre;
                    resultPost = post;
                    closestSize = post - pre;
                }
            }
        }
        
        if (pre == -1 || post == -1) return new int[]{-1, -1};
        return new int[]{resultPre, resultPost};
    }
    
    Boolean checkPrime(int num) {
        int temp = num;
        
        while (temp > 1) {
            int mod = 2;
            while (mod <= temp && mod < num) {
                if (temp % mod == 0) {
                    return false;
                } else {
                    mod++;
                }
            }
            
            if (mod == num) break;
        }
                    
        return true;
    }
}
