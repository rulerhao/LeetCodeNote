// class Solution {
//     public boolean isValid(String s) {
//         if (s == null) return true;
//         if (s.length() == 0) return true;
        
//         Stack<Character> stack = new Stack<>();
        
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 stack.push(')');
//             } else if (s.charAt(i) == '{') {
//                 stack.push('}');
//             } else if (s.charAt(i) == '[') {
//                 stack.push(']');
//             } else if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
//                 return false;
//             } else {
//                 stack.pop();
//             }
//         }
//         return stack.isEmpty();
//     }
// }

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
