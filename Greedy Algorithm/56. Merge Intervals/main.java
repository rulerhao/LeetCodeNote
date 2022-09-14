class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        
        LinkedList<int[]> newIntervals = new LinkedList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            int leftEdge = intervals[i][0];
            int rightEdge = intervals[i][1];
            if (i + 1 < intervals.length) {
                while (intervals[i + 1][0] <= rightEdge) {
                    rightEdge = Math.max(rightEdge, intervals[i + 1][1]);
                    i++;
                    if (i + 1 >= intervals.length) break;
                }
            }
            newIntervals.add(new int[]{leftEdge, rightEdge});
        }
        
        return newIntervals.toArray(new int[newIntervals.size()][]);
    }
}
