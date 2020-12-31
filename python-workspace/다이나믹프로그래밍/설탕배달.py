import sys

units = [5, 3]
target = int(sys.stdin.readline())
INF = 0xffffff
dp = [INF for _ in range(target + 1)]
dp[0] = 0
for unit in units:
    for num in range(unit, target + 1):
        if dp[num - unit] != INF:
            dp[num] = min(dp[num], dp[num - unit] + 1)
print(dp[target] if dp[target] != INF else -1)
