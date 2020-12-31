import sys
from collections import deque

direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def is_available_position(next_height, next_width):
    return 0 <= next_height < N and 0 <= next_width < N


def bfs(h, w):
    queue = deque()
    queue.append((h, w))
    count = 0
    visited[h][w] = True

    while queue:
        current = queue.pop()
        count += 1
        for d in direction:
            next_height = current[0] + d[0]
            next_width = current[1] + d[1]
            if is_available_position(next_height, next_width):
                if not visited[next_height][next_width] and board[next_height][next_width] == 1:
                    visited[next_height][next_width] = True
                    queue.append((next_height, next_width))
    return count


N = int(sys.stdin.readline())
board = [[0] * N for _ in range(N)]
visited = [[False] * N for _ in range(N)]
for height in range(N):
    for idx, value in enumerate(sys.stdin.readline().strip()):
        board[height][idx] = int(value)

answer = []
for height in range(N):
    for width in range(N):
        if not visited[height][width] and board[height][width] == 1:
            answer.append(bfs(height, width))

answer.sort()
print(len(answer))
for a in answer:
    print(a)
