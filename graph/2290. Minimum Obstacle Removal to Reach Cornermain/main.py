class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        m, n = map(len, (grid, grid[0]))
        distances = [[inf] * n for _ in range(m)]
        distances[0][0] = 0
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        dq = deque([(0, 0, 0)])
        while dq:
            d, x, y = dq.popleft()
            for dir in dirs:
                i = x + dir[0]
                j = y + dir[1]
                if i >= 0 and i < m and j >= 0 and j < n and distances[i][j] == inf:
                    if grid[i][j] == 1:
                        distances[i][j] = d + 1
                        dq.append((d + 1, i, j))
                    else:
                        distances[i][j] = d
                        # Select no colide position to go further.
                        dq.appendleft((d, i, j))

        return distances[-1][-1]
