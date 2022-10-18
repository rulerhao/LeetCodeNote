class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int num: hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        Arrays.sort(hand);
        for (int num: hand) {
            if (count.get(num) <= 0) continue;
            count.put(num, count.get(num) - 1);
            for (int i = 1; i < groupSize; i++) {
                if (count.get(num + i) == null || count.get(num + i) <= 0) return false;
                count.put(num + i, count.get(num + i) - 1);
            }
        }
        
        return true;
    }
}
