class Solution {
    public String reverseStr(String s, int k) {
        if (s == null) return s;
        if (s.length() == 0) return s;
        
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length) {
            if (index / k % 2 == 0) {
                if (chars.length - k >= index) {
                    int left = index;
                    int right = index + k - 1;
                    while (left < right) {
                        char temp = chars[left];
                        chars[left] = chars[right];
                        chars[right] = temp;
                        left++;
                        right--;
                    }
                } else {
                    int left = index;
                    int right = chars.length - 1;
                    while (left < right) {
                        char temp = chars[left];
                        chars[left] = chars[right];
                        chars[right] = temp;
                        left++;
                        right--;
                    }
                }
                index = index + k;
            } else {
                index = index + k;
            }
        }
        return new String(chars);
    }
}
