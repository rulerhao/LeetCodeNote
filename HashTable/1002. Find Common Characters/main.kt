class Solution {
    public List<String> commonChars(String[] words) {
        if (words.length < 1 || words == null) return new ArrayList<String>();
        
        List<String> result = new ArrayList<>();
        
        int[] record = new int[26]; // 26 is from lowercase english letters
        // First string for the base
        for (char c: words[0].toCharArray()) {
            record[c - 'a']++;
        }
        // The rest string
        for (int i = 1; i < words.length; i++) {
            int[] wordsRecord = new int[26];
            // get the char of each string
            for (char c: words[i].toCharArray()) {
                wordsRecord[c - 'a']++;
            }
            // set record to the least of common char
            for (int cIndex = 0; cIndex < record.length; cIndex++) {
                if (wordsRecord[cIndex]< record[cIndex]) {
                    record[cIndex] = wordsRecord[cIndex];
                }
            }
        }
        // Convert the least common record to result.
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[i]; j++) {
                result.add(Character.toString((char)(i + 'a')));
            }
        }
        return result;
    }
}
