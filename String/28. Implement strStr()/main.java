class Solution {
    int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) return -1;
        if (needle == null || needle.length() == 0) return 0;
        
        //  0123456789012345
        // "bbbbababbbaabbba"
        // "abb"
        //  000
        int[] lps = getLps(needle);
        
        int hIdx = 0;
        int nIdx = 0;
        while (hIdx < haystack.length() && nIdx < needle.length()) {
            if (haystack.charAt(hIdx) == needle.charAt(nIdx)) {
                hIdx++;
                nIdx++;
            } else {
                if (nIdx == 0) {
                    hIdx++;
                } else {
                    nIdx = lps[nIdx - 1];
                }
            }
            if (nIdx == needle.length()) break;
        }
            
        if (nIdx == needle.length()) {
            return hIdx - needle.length();
        } else {
            return -1;
        }
    }
    
    int[] getLps(String pattern) {
        if (pattern == null) return new int[0];
        if (pattern.length() == 0) return new int[0];
           
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int len = 0;
        int i = 1; // Because lps[0] has been set
        
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = len;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        
        return lps;
    }
}
