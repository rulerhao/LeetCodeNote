class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        # After operations, always last 1 or 0 negative num in matrix
        # So we calculate the negative num if num % 2 == 1 than there is 1 element is not possible to transform to positive. other wise no one.
        # If zero contains, Zero can be the roll that the last negative element.
        # To minimize the sum we have to mark the smallest num to let it be negative.
        negativeNum = 0
        zeroNum = 0
        sum = 0
        smallest = 10 ** 5
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] < 0:
                    negativeNum += 1
                elif matrix[i][j] == 0:
                    zeroNum += 1
                sum += abs(matrix[i][j])
                smallest = min(smallest, abs(matrix[i][j]))
        
        if zeroNum > 0:
            return sum
        if negativeNum % 2 == 0:
            return sum
        if negativeNum % 2 == 1:
            return sum - 2 * smallest

        return sum
