import sys
import bisect


def count_of_target(t):
    left = bisect.bisect_left(numbers, t)
    right = bisect.bisect_right(numbers, t)
    return right - left


countOfNumbers = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))
numbers.sort()
countOfTargets = int(sys.stdin.readline())
targets = list(map(int, sys.stdin.readline().split()))
for target in targets:
    print(1 if count_of_target(target) > 0 else 0)
