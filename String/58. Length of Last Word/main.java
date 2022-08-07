class Solution {
    public int lengthOfLastWord(String s) {
        int maxLength = 0;
        int wordStart = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && wordStart == -1) {
                wordStart = i;
            } else if (s.charAt(i) == ' ' && wordStart != -1) {
                maxLength = i - wordStart;
                wordStart = -1;
            }
            if (wordStart != -1 && i == s.length() - 1) {
                maxLength = i - wordStart + 1;
                wordStart = -1;
            }
        }
        return maxLength;
    }
}
