// Time Complexity: O(nLogn + qLogq)
// Space Complexity: n + q
class Solution {
    public int[] minInterval(int[][] intervals , int[] queries) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        HashMap<Integer, Integer> res = new HashMap<>();
        int i = 0;
        int aLen = intervals.length;
        int qLen = queries.length;
        int[] Q = queries.clone();
        int[] res2 = new int[qLen];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(Q);
        for (int q : Q) {
            while (i < aLen && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                i++;
                pq.add(new Pair(r - l + 1, r));
            }
            while (!pq.isEmpty() && pq.peek().getValue() < q)
                pq.poll();
            res.put(q, pq.isEmpty() ? -1 : pq.peek().getKey());
        }
        i = 0;
        for (int q : queries) {
            res2[i] = res.get(q);
            i++;
        }
        return res2;
    }
}
