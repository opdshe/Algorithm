import sys

max_floor = int(sys.stdin.readline())
cost = [[0 for _ in range(max_floor + 1)] for _ in range(max_floor + 1)]
for floor in range(1, max_floor + 1):
    for idx in range(1, max_floor + 1):
        cost[floor][idx] = int(input())
print(cost)
for _ in range(max_floor):
    cost.append(list(map(int, sys.stdin.readline().split(" "))))
dp = [[0 for _ in range(max_floor + 1)] for _ in range(max_floor + 1)]

for floor in range(1, max_floor + 1):
    for idx in range(1, max_floor + 1):
        print("floor " + str(floor) + " idx " + str(idx))
        dp[floor][idx] = max(dp[floor - 1][idx - 1] + cost[floor][idx], dp[floor - 1][idx])

answer = None
for candidate in dp[max_floor]:
    answer = max(answer, candidate)
print(answer)
