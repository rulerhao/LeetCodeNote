class Solution {

    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        
        int ans = 0;
        int max = 0;
        
        int left = 0;
        int right = 0;
        while (left <= right && left < s.length() && right < s.length()) {
            int cIdx = s.charAt(right) - 'A';
            arr[cIdx]++;
            max = Math.max(max, arr[cIdx]);
            if (right - left + 1 - max > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
