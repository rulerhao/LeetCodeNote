class Solution {
    public int minimumPartition(String s, int k) {
        if (s.length() == 0) return -1;
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int startPos = i;
            for (int size = 1; startPos + size <= s.length(); size++) {
                long num = Long.parseLong(s.substring(startPos, startPos + size));
                if (num > k && size == 1) {
                    return -1;
                } else if (num > k && size >= 2) {
                    count++;
                    i = startPos + size - 2;
                    break;
                } else if (num <= k && startPos + size == s.length()) {
                    count++;
                    return count;
                }
            }
        }
        
        return count;
    }
}
