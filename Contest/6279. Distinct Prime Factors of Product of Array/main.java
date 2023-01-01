class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            
            int j = 2;
            while (j <= temp) {
                if (temp % j == 0) {
                    temp = temp / j;
                    set.add(j);
                } else {
                    j++;
                }
            }
        }
        
        return set.size();
    }
}
