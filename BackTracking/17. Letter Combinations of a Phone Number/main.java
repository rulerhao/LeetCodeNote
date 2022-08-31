class Solution {
    List<String> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    
    StringBuilder temp = new StringBuilder();
    String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if (digits == null) return new ArrayList<>();
        if (digits == "") return new ArrayList<>();
        if (digits.length() == 0) return new ArrayList<>();
        
        backTracking(digits, 0);
        
        return result;
    }
    
    private void backTracking(String digits, int startPos) {
        if (startPos == digits.length()) {
            result.add(temp.toString());
            return;
        }
        
        int digit = digits.toCharArray()[startPos] - '0';
        for (int j = 0; j < chars[digit].length(); j++) {
            temp.append(chars[digit].charAt(j));
            backTracking(digits, startPos + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
