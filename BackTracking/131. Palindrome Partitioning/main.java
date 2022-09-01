class Solution {
    
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    
    public List<List<String>> partition(String s) {
        if (s == null && s.length() == 0) return new ArrayList<>();
        
        backTracking(0, s);
        
        return result;
    }
    
    private void backTracking(int startPos, String str) {
        if (startPos == str.length()) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startPos; i < str.length(); i++) {
            String thisStr = str.substring(startPos, i + 1);
            if (checkPD(thisStr)) {
                path.add(thisStr);
            } else {
                continue;
            }
            backTracking(i + 1, str);
            path.removeLast();
        }
    }
    
    private boolean checkPD(String str) {
        if (str == null || str.length() == 0) return false;
        
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) return false;
        }
        return true;
    }
}
