class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;
        int index = 0;
        int matchCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                matchCount++;
                index++;
                if (matchCount >= s.length()) break;
            }
        }
        
        return matchCount == s.length();
    }
}
