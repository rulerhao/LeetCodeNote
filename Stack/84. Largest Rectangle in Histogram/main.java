// class Solution {
//     int largestRectangleArea(int[] heights) {
//         Stack<Integer> st = new Stack<Integer>();
        
//         int [] newHeights = new int[heights.length + 2];
//         newHeights[0] = 0;
//         newHeights[newHeights.length - 1] = 0;
//         for (int index = 0; index < heights.length; index++) {
//             newHeights[index + 1] = heights[index];
//         }
        
//         st.push(0);
//         int result = 0;

//         for (int i = 1; i < newHeights.length; i++) {
//             if (newHeights[i] > newHeights[st.peek()]) {
//                 st.push(i);
//             } else if (newHeights[i] == newHeights[st.peek()]) {
//                 st.pop();
//                 st.push(i);
//             } else {
//                 while (newHeights[i] < newHeights[st.peek()]) {
//                     int mid = st.pop();
//                     int left = st.peek();
//                     int right = i;
//                     int w = right - left - 1;
//                     int h = newHeights[mid];
//                     result = Math.max(result, w * h);
//                 }
//                 st.push(i);
//             }
//         }
//         return result;
//     }
// }

class Solution {
    int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] newHeights = new int[heights.length + 2];
        
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 1; i < newHeights.length - 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        stack.push(0);
        
        int res = 0;
        for (int i = 1; i < newHeights.length; i++) {
            if (!stack.isEmpty()) {
                if (newHeights[stack.peek()] < newHeights[i]) {
                    stack.push(i);
                } else if (newHeights[stack.peek()] > newHeights[i]) {
                    while (newHeights[stack.peek()] > newHeights[i]) {
                        int mid = stack.pop();
                        int left = stack.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = newHeights[mid];
                        res = Math.max(res, w * h);
                    }
                    stack.push(i);
                } else {
                    stack.pop();
                    stack.push(i);
                }
            }
        }
        
        return res;
    }
}
