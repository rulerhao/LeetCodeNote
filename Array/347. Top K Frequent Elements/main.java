// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         if (nums == null) return new int[0];
//         if (nums.length == 0) return new int[0];
//         if (k <= 0) return new int[0];
        
//         Map<Integer, Integer> frequencyMap = new HashMap<>(); // it is the counter for all nums key.
        
//         // Set the count of the nums.
//         for (int n: nums) {
//             if (!frequencyMap.containsKey(n)) {
//                 frequencyMap.put(n, 1);
//             } else {
//                 frequencyMap.put(n, frequencyMap.get(n) + 1);
//             }
//         }
        
//         List<Integer>[] frequencyList = new List[nums.length + 1]; // max value would be length of nums
//         for (int key: frequencyMap.keySet()) {
//             int val = frequencyMap.get(key);
//             if (frequencyList[val] == null) {
//                 frequencyList[val] = new ArrayList<>();
//             }
//             frequencyList[val].add(key);
//         }
        
//         List<Integer> result = new ArrayList<>();
//         for (int i = nums.length; i >= 0; i--) { // Worst case: O(n + 1 + n)
//             if (frequencyList[i] == null) {
//                 continue;
//             }
//             for (int num: frequencyList[i]) {
//                 result.add(num);
//                 if (result.size() >= k) break;
//             }
//             if (result.size() >= k) break;
//         }
//         return result.stream().mapToInt(i->i).toArray();
//     }
// }

class Solution {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] topKFrequent(int[] numbers, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int n: numbers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int[] keys = new int[map.size()];
        int i = 0;
        for (int key: map.keySet()) {
            keys[i++] = key;
        }
        
        quickSelect(map, keys, k);
        System.out.println();
        
        return Arrays.copyOfRange(keys, keys.length - k,  keys.length);
    }
    
    private void quickSelect(
        HashMap<Integer, Integer> map,
        int[] keys,
        int k
    ) {
        int left = 0;
        int right = keys.length - 1;
        int index = keys.length - k;
        while (left <= right) {
            int pivot = partition(map, keys, left, right);
            if (pivot == index) {
                return;
            } else if (pivot > index) {
                right = pivot - 1;
            } else if (pivot < index) {
                left = pivot + 1;
            }
        }
    }
    
    private int partition(
        HashMap<Integer, Integer> map,
        int[] keys,
        int left,
        int right
    ) {
        int pivot = left;
        left = pivot + 1;
        while (left <= right) {
            while (left <= right && map.get(keys[left]) <= map.get(keys[pivot])) left++;
            while (left <= right && map.get(keys[right]) > map.get(keys[pivot])) right--;
            if (left > right) {
                break;
            }
            swap(keys, left, right);
        }
        swap(keys, pivot, right);
        
        return right;
    }
    
    private void swap(
        int[] arr,
        int i,
        int j
    ) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
