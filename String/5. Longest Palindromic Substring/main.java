class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s, i, i); // like aba
            int len2 = extend(s, i, i + 1); // like abba
            if (max < Math.max(len1, len2)) {
                idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
                max = Math.max(len1, len2);
            }
        }
        return s.substring(idx, idx + max);
    }
    
    // 由指定 index 由中間往外找最大鏡像的答案
    private int extend(String s, int left, int right) {
        for (; left >= 0 && right < s.length(); left--, right++)
            if (s.charAt(left) != s.charAt(right))
                break;
        return right - left - 2 + 1; // 2 means current two unmatched char
    }
}
