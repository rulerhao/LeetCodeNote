class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val resultArray: Array<IntArray> = Array(n){IntArray(n)}
        var nowX = 0
        var nowY = 0
        var nowNum = 1
        val totalLoopTime = n / 2
        var loopCount = 0
        while (totalLoopTime - loopCount > 0) {
            nowX = loopCount
            nowY = loopCount
            // 12X
            // XXX
            // XXX
            // Top left to top right
            while (nowX < n - 1 - loopCount) {
                resultArray[nowY][nowX++] = nowNum++
            }
            // XX3
            // XX4
            // XXX
            // Top right to bottom right
            while (nowY < n - 1 - loopCount) {
                resultArray[nowY++][nowX] = nowNum++
            }
            // XXX
            // XXX
            // X65
            // Bottom right to bottom left
            while (nowX > 0 + loopCount) {
                resultArray[nowY][nowX--] = nowNum++
            }
            // XXX
            // 8XX
            // 7XX
            // Bottom left to top left
            while (nowY > 0 + loopCount) {
                resultArray[nowY--][nowX] = nowNum++
            }
            loopCount++
        }
        if (n % 2 == 1) {
            resultArray[loopCount][loopCount] = nowNum
        }
        return resultArray
    }
}
