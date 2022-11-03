// class Solution {
//     long[] preSum;
//     public int maxSumMinProduct(int[] nums) {
//         int n = nums.length;
//         int[] left_bound = new int[n], right_bound = new int[n];
//         Stack<Integer> st = new Stack<>();
//         for (int i = 0; i < n; i++) {
//             while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
//             if (!st.isEmpty())
//                 left_bound[i] = st.peek() + 1;
//             else
//                 left_bound[i] = 0;
//             st.add(i);
//         }
//         st = new Stack<>();
//         for (int i = n - 1; i >= 0; i--) {
//             while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
//             if (!st.isEmpty())
//                 right_bound[i] = st.peek() - 1;
//             else
//                 right_bound[i] = n - 1;
//             st.add(i);
//         }
        
//         preSum = new long[n + 1];
//         for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + nums[i];
        
//         long maxProduct = 0;
//         for (int i = 0; i < n; i++)
//             maxProduct = Math.max(maxProduct, getSum(left_bound[i], right_bound[i]) * nums[i]);
        
//         return (int) (maxProduct % 1000000007);
//     }
    
//     private long getSum(int left, int right) { // left, right inclusive
//         return preSum[right + 1] - preSum[left];
//     }
// }

class Solution {
    long[] preSum;
    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        int[] leftBounds = new int[len];
        int[] rightBounds = new int[len];
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                leftBounds[i] = 0;
                st.add(i);
            } else {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }
                if (!st.isEmpty()) {
                    leftBounds[i] = st.peek() + 1;
                    if (nums[st.peek()] != nums[i]) st.add(i);
                } else {
                    leftBounds[i] = 0;
                    st.add(i);
                }
            }
        }
        
        st = new Stack<>();
        
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                rightBounds[i] = len - 1;
                st.add(i);
            } else {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }
                if (!st.isEmpty()) {
                    rightBounds[i] = st.peek() - 1;
                    if (nums[st.peek()] != nums[i]) st.add(i);
                } else {
                    rightBounds[i] = len - 1;
                    st.add(i);
                }
            }
        }
        
        long[] sumArr = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sumArr[i + 1] = sumArr[i] + nums[i]; 
        }
        
        long res = 0;
        
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (sumArr[rightBounds[i] + 1] - sumArr[leftBounds[i]]) * nums[i]);
        }
        
        return (int) (res % 1000000007);
    }
    
}
