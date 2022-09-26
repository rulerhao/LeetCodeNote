class Solution {
    int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }
        
        st.push(0);
        int result = 0;

        for (int i = 1; i < newHeights.length; i++) {
            if (newHeights[i] > newHeights[st.peek()]) {
                st.push(i);
            } else if (newHeights[i] == newHeights[st.peek()]) {
                st.pop();
                st.push(i);
            } else {
                while (newHeights[i] < newHeights[st.peek()]) {
                    int mid = st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = newHeights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }
}
