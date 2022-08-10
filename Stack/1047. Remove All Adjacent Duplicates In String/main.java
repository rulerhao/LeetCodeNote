class Solution {
    public String removeDuplicates(String s) {
        if (s == null) return "";
        if (s.length() == 0) return "";
        
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        String result = new String();
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        
        return result;
    }
}
