// Situation
// 1. Be separated to four part.
// 2. Each part must be integer 0 to 255.
// 
class Solution {
    List<String> result = new ArrayList<>();
    List<String> tempItems = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        
        backTracking(s, 0);
        
        return result;
    }
    
    private void backTracking(String s, int startPos) {
        if (tempItems.size() == 4) {
            if (startPos != s.length()) return;
            else {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    if (!String.valueOf(Integer.parseInt(tempItems.get(i))).equals(tempItems.get(i))) return;
                    str.append(tempItems.get(i));
                    if (i < 3) str.append(".");
                }
                result.add(str.toString());
                return;
            }
        }
        
        StringBuilder str = new StringBuilder();
        for (int i = startPos; i < startPos + 3 && i < s.length(); i++) {
            str.append(s.charAt(i));
            if (Integer.parseInt(str.toString()) > 255 || Integer.parseInt(str.toString()) < 0) continue;
            tempItems.add(str.toString());
            backTracking(s, i + 1);
            tempItems.remove(tempItems.size() - 1);
        }
    }
}
