class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        
        int[] warnerDay = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int topIndex = stack.pop();
                warnerDay[topIndex] = i - topIndex;
            }
            stack.push(i);
        }
        
        return warnerDay;
    }
}
