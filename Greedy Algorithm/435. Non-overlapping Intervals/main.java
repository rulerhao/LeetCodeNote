class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        
        int deletedCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            int nextIndex = i + 1;
            int right = intervals[i][1];
            boolean overlap = false;
            if (nextIndex < intervals.length) {
                while (intervals[i][1] > intervals[nextIndex][0]) {
                    deletedCount++;
                    nextIndex++;
                    if (nextIndex >= intervals.length) {
                        break;
                    }
                }
                i = nextIndex - 1;
                continue;
            }
        }
        
        return deletedCount;
    }
}
