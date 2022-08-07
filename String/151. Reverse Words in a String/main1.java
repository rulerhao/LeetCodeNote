// With extra space.
class Solution {
    public String reverseWords(String s) {
        if (s == null) return s;
        if (s.length() == 0) return s;
        
        List<String> strings = convertStringToStrings(s);
        return convertStringsToReverseWords(strings);
    }
    
    List<String> convertStringToStrings(String s) {
        List<String> strings = new ArrayList<>();
        int startIndex = -1;
        // get string list for full string.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && startIndex == -1) {
                startIndex = i;
            } else if (s.charAt(i) == ' ' && startIndex != -1) {
                strings.add(s.substring(startIndex, i + 1 - 1));
                startIndex = -1;
            }
            if (i == s.length() - 1 && startIndex != -1) {
                strings.add(s.substring(startIndex, i + 1));
                startIndex = -1;
            }
        }
        return strings;
    }
    
    String convertStringsToReverseWords(List<String> strings) {
        String result = "";
        for (int i = strings.size() - 1; i >= 0; i--) {
            if (i == 0) {
                result += strings.get(i);
            } else {
                result += strings.get(i) + " ";
            }
        }
        return result;
    }
}
