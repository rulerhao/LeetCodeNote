class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;   
                result = 0;
            } else if(c == ')') {
                result += sign * number;  
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
                
            }
        }
        if(number != 0) result += sign * number;
        return result;
    }

    // private boolean checkIsNumber(char c) {
    //     if (s.charAt(i) == '0') {
    //         return true;
    //     } else if (s.charAt(i) == '1') {
    //         return true;
    //     } else if (s.charAt(i) == '2') {
    //         return true;
    //     } else if (s.charAt(i) == '3') {
    //         return true;
    //     } else if (s.charAt(i) == '4') {
    //         return true;
    //     } else if (s.charAt(i) == '5') {
    //         return true;
    //     } else if (s.charAt(i) == '6') {
    //         return true;
    //     } else if (s.charAt(i) == '7') {
    //         return true;
    //     } else if (s.charAt(i) == '8') {
    //         return true;
    //     } else if (s.charAt(i) == '9') {
    //         return true;
    //     }
    //     return false;
    // }

    // private boolean checkIsNumber(String s) {
    //     if (s.equals("0")) {
    //         return true;
    //     } else if (s.equals("1")) {
    //         return true;
    //     } else if (s.equals("2")) {
    //         return true;
    //     } else if (s.equals("3")) {
    //         return true;
    //     } else if (s.equals("4")) {
    //         return true;
    //     } else if (s.equals("5")) {
    //         return true;
    //     } else if (s.equals("6")) {
    //         return true;
    //     } else if (s.equals("7")) {
    //         return true;
    //     } else if (s.equals("8")) {
    //         return true;
    //     } else if (s.equals("9")) {
    //         return true;
    //     }
    //     return false;
    // }
}
