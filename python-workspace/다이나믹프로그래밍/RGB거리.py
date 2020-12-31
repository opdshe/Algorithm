import sys

count_of_house = int(sys.stdin.readline())
cost = []
for _ in range(count_of_house):
    cost.append(list(map(int, sys.stdin.readline().split(" "))))
dp = [[float('inf') for _ in range(3)] for _ in range(count_of_house)]
dp[0][0] = cost[0][0]
dp[0][1] = cost[0][1]
dp[0][2] = cost[0][2]

for house in range(1, count_of_house):
    dp[house][0] = cost[house][0] + min(dp[house - 1][1], dp[house - 1][2])
    dp[house][1] = cost[house][1] + min(dp[house - 1][0], dp[house - 1][2])
    dp[house][2] = cost[house][2] + min(dp[house - 1][0], dp[house - 1][1])

answer = min(dp[count_of_house - 1][0], dp[count_of_house - 1][1], dp[count_of_house - 1][2])
print(answer)
