class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char c: s1.toCharArray()) {
            arr1[c - 'a']++;
        }
        
        int left = 0;
        int right = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;
        }
        
        while (left <= s2.length() - s1.length() && right <= s2.length()) {
            if (checkArraySame(arr1, arr2)) return true;
            arr2[s2.charAt(left) - 'a']--;
            if (right < s2.length()) {
                arr2[s2.charAt(right) - 'a']++;
            }
            left++;
            right++;
        }
        
        return false;
    }
    
    private boolean checkArraySame(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        
        return true;
    }
}
