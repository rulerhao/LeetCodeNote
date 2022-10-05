class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(
            intervals,
            (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])
        );
        
        int result = 0;
        
        int preIdx = 0;
        for (int nextIdx = 1; nextIdx < intervals.length; nextIdx++) {
            int preTail = intervals[preIdx][1];
            int nextHead = intervals[nextIdx][0];
            int nextTail = intervals[nextIdx][1];
            if (preTail > nextHead) { // overlap
                if (preTail > nextTail) {
                    preIdx = nextIdx;
                }
                result++;
            } else {
                preIdx = nextIdx;
            }
        }
        
        return result;
    }
}
