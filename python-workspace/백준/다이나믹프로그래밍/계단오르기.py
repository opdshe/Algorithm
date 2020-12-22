import sys

count_of_stair = int(sys.stdin.readline())
cost = []
for _ in range(count_of_stair):
    cost.append(int(sys.stdin.readline()))

dp = [0 for _ in range(count_of_stair)]
dp[0] = cost[0]
if count_of_stair >= 2:
    dp[1] = cost[0] + cost[1]

for stair in range(2, count_of_stair):
    dp[stair] = max(dp[stair-3] + cost[stair-1] + cost[stair], dp[stair-2] + cost[stair])
print(dp[count_of_stair - 1])
