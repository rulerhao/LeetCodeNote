class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        # Create rotated box.
        rotatedBox = []
        m = len(box)
        n = len(box[0])
        
        for i in range(n):
            tmp = []
            for j in range(m - 1, -1, -1):
                tmp.append(box[j][i])
            rotatedBox.append(tmp)

        m = len(rotatedBox)
        n = len(rotatedBox[0])

        # 1. Iterate from top to bottom, left to right
        # 2. If item == '#', store it and set the item to '.'
        # 3. If item == '*', put the stored items to the above.
        # 4. If meet the bottom, put the stored items to the above.
        for i in range(n):
            num = 0
            for j in range(m):
                if rotatedBox[j][i] == '#':
                    num += 1
                    rotatedBox[j][i] = '.'
                if rotatedBox[j][i] == '*':
                    for k in range(num):
                        rotatedBox[j - k - 1][i] = '#'
                    num = 0
                if j == m - 1:
                    for k in range(num):
                        rotatedBox[j - k][i] = '#'
                    num = 0

        return rotatedBox
