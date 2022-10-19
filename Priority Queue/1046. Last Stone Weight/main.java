class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
        for (int stone: stones) maxPQ.add(- stone);
        
        while (maxPQ.size() > 1) {
            int stone1 = maxPQ.poll();
            int stone2 = maxPQ.poll();
            int rest = stone1 - stone2;
            if (rest != 0) maxPQ.add(rest);
        }
        
        if (maxPQ.size() == 0) return 0;
        return - maxPQ.poll();
    }
}
