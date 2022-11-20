class Solution {
    public int unequalTriplets(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }
        
        int res = 0;
        if (map.size() < 3) return res;
        
        int[] vals = new int[map.size()];
        int idx = 0;
        for (Integer key : map.keySet()) {
            vals[idx++] = map.get(key);
        }
        for (int i = 0; i < vals.length - 2; i++) {
            for (int j = i + 1; j < vals.length - 1; j++) {
                for (int k = j + 1; k < vals.length; k++) {
                    res = res + vals[i] * vals[j] * vals[k];
                }
            }
        }
        return res;
    }
}
