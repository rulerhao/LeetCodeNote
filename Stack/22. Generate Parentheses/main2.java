class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack("", 0, 0, n);
        return res;
    }

    private void backTrack(String str, int leftNum, int rightNum, int n) {
        if (leftNum == n && rightNum == n) {
            res.add(str);
        }
        if (leftNum < n) {
            backTrack(str + '(', leftNum + 1, rightNum, n);
        }
        if (rightNum < leftNum) {
            backTrack(str + ')', leftNum, rightNum + 1, n);
        }
    }
}
