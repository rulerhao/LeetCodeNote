class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.size == 0) return 0
        if (target == 0) return 0 // Because target is positive.
        
        var sum: Int = 0
        var leftIndex: Int = 0
        var minLength = Int.MAX_VALUE
        for (rightIndex in 0..nums.size - 1) {
            sum = sum + nums[rightIndex]
            while (sum >= target) { // if sum is plus or equal to target.
                if (minLength > rightIndex - leftIndex + 1) {
                    minLength = rightIndex - leftIndex + 1
                }
                sum = sum - nums[leftIndex]
                leftIndex++
            }
        }
        
        if (minLength == Int.MAX_VALUE) return 0
        return minLength
    }
}
