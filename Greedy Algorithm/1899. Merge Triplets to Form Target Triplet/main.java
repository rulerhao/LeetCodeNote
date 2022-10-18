class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] first = new int[] {1, 1, 1};
        for (int[] triplet: triplets) {
            boolean tooHigh = false;
            for (int i = 0; i < 3; i++) {
                if (triplet[i] > target[i]) {
                    tooHigh = true;
                    break;
                }
            }
            if (tooHigh) continue;
            for (int i = 0; i < 3; i++) {
                first[i] = Math.max(triplet[i], first[i]);
            }
            int count = 0;
            for (int i = 0; i < 3; i++) {
                if (first[i] == target[i]) count++;
            }
            if (count == 3) return true;
        }
        
        return false;
    }
}
