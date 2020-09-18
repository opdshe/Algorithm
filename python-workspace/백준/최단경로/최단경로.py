import heapq
import sys
INF = int(1e9)


def dijkstra():
    queue = []
    distance[startNode] = 0
    heapq.heappush(queue, (0, startNode))
    while queue:
        dist, node = heapq.heappop(queue)
        if distance[node] < dist:
            continue
        for adj in adjacent[node]:
            cost = dist + adj[1]
            if distance[adj[0]] > cost:
                distance[adj[0]] = cost
                heapq.heappush(queue, (cost, adj[0]))

    for i in range(1, vertex + 1):
        print(distance[i] if distance[i] is not INF else "INF")


vertex, edge = map(int, sys.stdin.readline().split())
startNode = int(input())
adjacent = [[] for _ in range(vertex + 1)]
distance = [INF] * (vertex + 1)
for _ in range(edge):
    source, dest, weight = map(int, sys.stdin.readline().split())
    adjacent[source].append((dest, weight))

dijkstra()
