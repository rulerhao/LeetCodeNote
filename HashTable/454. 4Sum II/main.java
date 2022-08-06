class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1: nums1) {
            for (int n2: nums2) {
                int sum = n1 + n2;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        for (int n1: nums3) {
            for (int n2: nums4) {
                int sum = n1 + n2;
                if (map.containsKey(0 - sum)) {
                    result = result + map.get(0 - sum);
                }
            }
        }
        return result;
    }
}
