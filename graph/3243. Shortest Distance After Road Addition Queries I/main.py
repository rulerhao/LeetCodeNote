class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        def dijkstra(start, end, graph):
            heap = []
            heappush(heap, (0, start)) # distance, node
            distances = [float('inf')] * n
            distances[0] = 0

            while True:
                distance, node = heappop(heap)
                
                if node == end:
                    return distance

                if distance > distances[node]:
                    continue

                for g_node, g_distance in graph[node]:
                    new_distance = distance + g_distance
                    if new_distance < distances[g_node]:
                        distances[g_node] = new_distance
                        heappush(heap, (new_distance, g_node))

            return distances[end]

        graph = {}
        for i in range(n - 1):
            graph[i] = []
            graph[i].append((i + 1, 1))

        result = []

        for q in queries:
            start, end = q
            graph[start].append((end, 1))
            distance = dijkstra(0, n - 1, graph)
            result.append(distance)

        return result
