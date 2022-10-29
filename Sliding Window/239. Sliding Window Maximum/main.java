// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (nums == null) return new int[0];
//         if (nums.length == 0) return new int[0];
//         if (k <= 0) return new int[0];
        
//         Deque<Integer> dq = new ArrayDeque<>();
//         int[] result = new int[nums.length - k + 1];
//         for (int i = 0; i < nums.length; i++) {
//             if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
//                 dq.pollFirst();
//             }
//             // Remove elements of dq which are lower or equal than it.
//             while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
//                 dq.pollLast();
//             }
//             dq.offerLast(i);
//             // Add num to result.
//             if (i - k + 1 >= 0) {
//                 result[i - k + 1] = nums[dq.peekFirst()];
//             }
//         }
        
//         return result;
//     }
// }

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < (i - k + 1)) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        
        return res;
    }
}
