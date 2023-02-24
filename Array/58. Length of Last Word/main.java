class Solution {
    public int lengthOfLastWord(String s) {
        int lastLen = 0;
        int nowLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                nowLen = 0;
            } else {
                nowLen++;
                lastLen = nowLen;
            }
        }

        return lastLen;
    }
}
