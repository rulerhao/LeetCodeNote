class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        
        int[][] range = new int[26][2]; // Each letter's left and right edge.
        for (int i = 0; i < range.length; i++) { // O(26)
            range[i][0] = -1;
            range[i][1] = -1;
        }
        
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) { // O(n)
            if (range[chars[i] - 'a'][0] == -1) {
                range[chars[i] - 'a'][0] = i;
            }
            range[chars[i] - 'a'][1] = i;
        }
        
        for (int i = 0; i < chars.length; i++) { // O(n)
            if (range[chars[i] - 'a'][0] == -1) continue;
            
            int leftEdge = i;
            int rightEdge = range[chars[i] - 'a'][1];
            for (int j = i + 1; j < rightEdge; j++) {
                rightEdge = Math.max(rightEdge, range[chars[j] - 'a'][1]);
            }
            result.add(rightEdge - i + 1);
            i = rightEdge;
        }
        
        return result;
    }
}
