class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] lps = getLps(s);
        int len = s.length();
        if (
            lps[len - 1] > 0 && 
            len % (len - lps[len - 1]) == 0) {
            return true;
        }
        return false;
    }
    
    int[] getLps(String s) {
        if (s == null) return new int[0];
        if (s.length() == 0) return new int[0];
            
        int i = 1;
        int len = 0;
        int[] lps = new int[s.length()];
        lps[0] = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }
}
