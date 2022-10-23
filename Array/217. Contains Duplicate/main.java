class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> record = new HashSet<>();
        for (int num: nums) {
            if (record.contains(num)) {
                return true;
            } else {
                record.add(num);
            }
        }
        
        return false;
    }
}
