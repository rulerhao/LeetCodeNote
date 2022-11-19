class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];
            if (!checkSorted(orderMap, str1, str2)) return false;
        }

        return true;
    }

    private boolean checkSorted(HashMap<Character, Integer> map, String str1, String str2) {
        int len = Math.max(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.length() <= i) return true;
            else if (str2.length() <= i) return false;

            if (map.get(str1.charAt(i)) > map.get(str2.charAt(i))) return false;
            else if (map.get(str1.charAt(i)) < map.get(str2.charAt(i))) return true;
        }

        return true;
    }
}
