// Time complexity = O(n^2)
// Space complexity = O(1)
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            if (i % 2 == 0) { // middle is char.
                int edgeRange = Math.min(i / 2, s.length() - 1 - (i / 2));
                for (int j = 0; j <= edgeRange; j++) {
                    if (s.charAt(i / 2 - j) == s.charAt(i / 2 + j)) {
                        count++;
                    } else {
                        break;
                    }
                }
            } else { // middle is space
                int edgeRange = Math.min(i / 2 + 1, s.length() - 1 - (i / 2));
                for (int j = 1; j <= edgeRange; j++) {
                    if (s.charAt(i / 2 + 1 - j) == s.charAt(i / 2 + j)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}
