import sys


def solve(target):
    dp = [0 for _ in range(target + 1)]
    dp[0] = 1
    for unit in units:
        for num in range(unit, target + 1):
            if dp[num - unit] != 0:
                dp[num] = dp[num - unit] + 1
    print(dp[target])


units = [1, 2, 3]
testcase = int(sys.stdin.readline())
for _ in range(testcase):
    target = int(sys.stdin.readline())
    solve(target)
