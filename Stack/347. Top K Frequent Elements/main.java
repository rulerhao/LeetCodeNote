class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) return new int[0];
        if (nums.length == 0) return new int[0];
        if (k <= 0) return new int[0];
        
        Map<Integer, Integer> frequencyMap = new HashMap<>(); // it is the counter for all nums key.
        
        // Set the count of the nums.
        for (int n: nums) {
            if (!frequencyMap.containsKey(n)) {
                frequencyMap.put(n, 1);
            } else {
                frequencyMap.put(n, frequencyMap.get(n) + 1);
            }
        }
        
        List<Integer>[] frequencyList = new List[nums.length + 1]; // max value would be length of nums
        for (int key: frequencyMap.keySet()) {
            int val = frequencyMap.get(key);
            if (frequencyList[val] == null) {
                frequencyList[val] = new ArrayList<>();
            }
            frequencyList[val].add(key);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--) { // Worst case: O(n + 1 + n)
            if (frequencyList[i] == null) {
                continue;
            }
            for (int num: frequencyList[i]) {
                result.add(num);
                if (result.size() >= k) break;
            }
            if (result.size() >= k) break;
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}

