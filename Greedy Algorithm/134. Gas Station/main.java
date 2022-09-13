// Circle Route
// gas[i] means ith station gas amount
// cost[i] means i to i + 1 station gas needed
// Return index which can travel around.
// If no than return -1.

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            curSum = curSum + diff;
            totalSum = totalSum + diff;
            if (curSum < 0) {
                curSum = 0;
                index = (i + 1) % gas.length;
            }
        }
        if (totalSum < 0) return -1;
        else return index;
    }
}
