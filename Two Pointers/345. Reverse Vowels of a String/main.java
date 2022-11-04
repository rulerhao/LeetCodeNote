class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;

        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        while (left < right) {
            char leftC = s.charAt(left);
            boolean leftIsVowel = false;
            for (char vowel: vowels) {
                if (leftC == vowel) {
                    leftIsVowel = true;
                }
            }
            if (!leftIsVowel) {
                left++;
                continue;
            }
            char rightC = s.charAt(right);
            boolean rightIsVowel = false;
            for (char vowel: vowels) {
                if (rightC == vowel) {
                    rightIsVowel = true;
                }
            }
            if (!rightIsVowel) {
                right--;
                continue;
            }
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(left, rightC);
            sb.setCharAt(right, leftC);
            s = sb.toString();
            left++;
            right--;
        }

        return s;
    }
}
