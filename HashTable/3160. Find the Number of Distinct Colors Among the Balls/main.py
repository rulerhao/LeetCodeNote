class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        # Time Complexity: O(n)
        # Space Complexity: O(n)
        # colored = {}
        # colors = [0] * (limit + 1)
        # res = [0] * len(queries)
        # for i in range(len(queries)):
        #     # print(i, colors, colored)
        #     idx = queries[i][0]
        #     color = queries[i][1]
        #     oriColor = colors[idx]
        #     if colors[idx] != 0:
        #         if colors[idx] == color:
        #             res[i] = len(colored)
        #             continue
        #         else:
        #             colored[oriColor] -= 1
        #             if colored[oriColor] == 0:
        #                 del colored[oriColor]
        #             if not color in colored:
        #                 colored[color] = 0
        #             colored[color] += 1
        #             colors[idx] = color
        #     else:
        #         if not color in colored:
        #             colored[color] = 0
        #         colored[color] += 1
        #         colors[idx] = color
        #     res[i] = len(colored)

        # return res


        # Time complexity: O(n)
        # Space complexity: O(len(queries))
        ball = {}
        colors = {}
        res = [0] * len(queries)
        num = 0
        for i in range(len(queries)):
            pos = queries[i][0]
            color = queries[i][1]

            # Remove the coverd ball color.
            if pos in ball:
                oriColor = ball[pos]
                colors[oriColor] -= 1
                if colors[oriColor] == 0:
                    del colors[oriColor]
                    num -= 1

            # Add color to colors.
            if not color in colors:
                colors[color] = 0
            colors[color] += 1
            ball[pos] = color
            if colors[color] == 1: # More than 1 color not possible to get more distinct color.
                num += 1
            res[i] = num

        return res
