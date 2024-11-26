class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        visited = set()

        for i in range(n):
            visited.add(i)
        
        for edge in edges:
            if edge[1] in visited:
                visited.remove(edge[1])

        if len(visited) != 1:
            return -1

        for v in visited:
            return v
