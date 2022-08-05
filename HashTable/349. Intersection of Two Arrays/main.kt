class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> setNums1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int n: nums1) {
            setNums1.add(n);
        }
        for (int n: nums2) {
            if (setNums1.contains(n)) {
                resultSet.add(n);
            }
        }
        return resultSet.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
