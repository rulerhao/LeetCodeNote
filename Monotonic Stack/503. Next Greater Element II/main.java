class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int size = nums.length;
        int[] result = new int[size];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < 2 * size; i++) {
            while(!stack.empty() && nums[i % size] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i % size];
                stack.pop();
            }
            stack.push(i % size);
        }
        return result;
    }
}
