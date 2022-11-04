class Solution {
    public int longestPalindrome(String[] words) {
        int[] doubleArr = new int[26];
        HashMap<String, Integer> singleMap = new HashMap<>();
        
        int res = 0;
        for (String str: words) {
            if (str.charAt(0) == str.charAt(1)) {
                doubleArr[str.charAt(0) - 'a']++;
            } else {
                String reverseStr = "" + str.charAt(1) + str.charAt(0);
                if (singleMap.getOrDefault(reverseStr, 0) == 0) {
                    singleMap.put(str, singleMap.getOrDefault(str, 0) + 1);
                } else {
                    singleMap.put(reverseStr, singleMap.get(reverseStr) - 1);
                    res += 4;
                }
            }
        }

        boolean usedOdd = false;
        for (int n: doubleArr) {
            if (n % 2 == 0) {
                res += n * 2;
            } else {
                res += (n - 1) * 2;
                if (!usedOdd) {
                    res += 2;
                    usedOdd = true;
                }
            }
        }

        return res;
    }
}
