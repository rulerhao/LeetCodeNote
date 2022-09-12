class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gPos = 0;
        for (int i = 0; i < s.length; i++) {
            if (gPos >= g.length) break;
            if (g[gPos] <= s[i]) {
                gPos++;
                count++;
            }
        }
        
        return count;
    }
}
