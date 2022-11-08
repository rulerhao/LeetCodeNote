class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean valid = check(s, p, removable, mid);
            if (valid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right + 1;
    }

    private boolean check(String s, String p, int[] removable, int end) {
        int sIdx = 0;
        int pIdx = 0;

        char[] sArr = s.toCharArray();
        for (int i = 0; i <= end; i++) {
            sArr[removable[i]] = '.';
        }

        while (sIdx < s.length() && pIdx < p.length()) {
            if (sArr[sIdx] == p.charAt(pIdx)) {
                sIdx++;
                pIdx++;
            } else {
                sIdx++;
            }
        }

        return pIdx == p.length();
    }
}
