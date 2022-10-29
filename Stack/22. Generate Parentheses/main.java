class Solution {
    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(0, 0, n);
        return res;
    }

    private void backTrack(int leftNum, int rightNum, int n) {
        if (leftNum == n && rightNum == n) {
            Iterator value = stack.iterator();

            String tmp = "";
            while (value.hasNext()) {
                tmp = tmp + value.next();
            }
            res.add(tmp);
        }
        if (leftNum < n) {
            stack.push('(');
            backTrack(leftNum + 1, rightNum, n);
            stack.pop();
        }
        if (rightNum < leftNum) {
            stack.push(')');
            backTrack(leftNum, rightNum + 1, n);
            stack.pop();
        }
    }
}
