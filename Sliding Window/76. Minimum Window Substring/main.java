// class Solution {
//     public String minWindow(String s, String t) {
//         if (t.length() > s.length()) return "";
        
//         int[] arr1 = new int[60];
//         int[] arr2 = new int[60];
        
//         for (char c: t.toCharArray()) {
//             arr1[c - 'A']++;
//         }
        
//         int left = 0;
//         int right = t.length();
        
//         for (int i = 0; i < t.length(); i++) {
//             arr2[s.charAt(i) - 'A']++;
//         }
        
//         String res = "";
//         int min = Integer.MAX_VALUE;
//         while (left <= s.length() - t.length() && right <= s.length()) {
//             if (checkArrContain(arr1, arr2)) {
//                 if (right - left < min) {
//                     res = s.substring(left, right);
//                     min = right - left;
//                 }
//                 if (left < s.length()) {
//                     arr2[s.charAt(left) - 'A']--;
//                 }
//                 left++;
//             } else {
//                 if (right < s.length()) {
//                     arr2[s.charAt(right) - 'A']++;
//                 }
//                 right++;
//             }
//         }
        
//         return res;
//     }
    
//     private boolean checkArrContain(int[] arr1, int[] arr2) {
//         for (int i = 0; i < arr1.length; i++) {
//             if (arr1[i] > arr2[i]) {
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }

class Solution {

    //sliding window
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int end = 0; end < s.length(); end++) {
            char right = s.charAt(end);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}
