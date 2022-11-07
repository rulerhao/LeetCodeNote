class Solution {
    public int maximum69Number (int num) {
        String numStr = Integer.toString(num);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '6') {
                StringBuilder sb = new StringBuilder(numStr);
                sb.setCharAt(i, '9');
                return Integer.parseInt(sb.toString());
            }
        }
        return num;
    }
}
