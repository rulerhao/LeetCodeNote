class Solution {

    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.charAt(i) == '(') {
                left.push(i);
            } else if (c == ')') {
                if (left.size() > 0) left.pop();
                else if (star.size() > 0) star.pop();
                else return false;
            } else {
                star.push(i);
            }
        }
        
        while (left.size() > 0 && star.size() > 0) {
            if (left.pop() > star.pop()) return false;
        }
        
        return left.size() == 0;
    }
}
