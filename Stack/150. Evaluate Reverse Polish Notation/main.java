class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null) return 0;
        if (tokens.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (String s: tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(- stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int divisor = stack.pop();
                int dividend = stack.pop();
                stack.push(dividend / divisor);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
