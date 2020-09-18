from collections import deque

def dfs(current):
    visited[current] = True
    print(current, end=' ')
    for i in range(1, N + 1):
        if visited[i] is False and adj[current][i] == 1:
            dfs(i)


def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = True

    while queue:
        current = queue.popleft()
        print(current, end=' ')
        for idx in range(1, N+1):
            if visited[idx] is False and adj[current][idx] == 1:
                visited[idx] = True
                queue.append(idx)
    print()


if __name__ == '__main__':
    N, M, V = map(int, input().split())
    adj = [[0] * (N + 1) for _ in range(N + 1)]
    visited = [False] * (N + 1)
    for _ in range(M):
        source, dest = map(int, input().split())
        adj[source][dest] = 1
        adj[dest][source] = 1
    dfs(V)
    print()
    visited = [False] * (N + 1)
    bfs(V)
