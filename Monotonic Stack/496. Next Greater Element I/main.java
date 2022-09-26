// 1. nums1 is subset of nums2
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElements = new int[nums1.length];
        
        // It can be stack or deque. The time complexity both are O(n). 
        // But Deque in java is faster than Stack for some reason.
        Stack<Integer> notProcessed = new Stack<>();
        HashMap<Integer, Integer> mapToGreater = new HashMap<>();
        
        for (int n: nums2) {
            while (!notProcessed.empty() && notProcessed.peek() < n) {
                mapToGreater.put(notProcessed.pop(), n);
            }
            notProcessed.push(n);
        }
        
        for (int i = 0; i < nextGreaterElements.length; i++) {
            nextGreaterElements[i] = mapToGreater.getOrDefault(nums1[i], -1);
        }
        
        return nextGreaterElements;
    }
}
