import sys

N = int(sys.stdin.readline())
soldier = list(map(int, sys.stdin.readline().split()))
soldier_list = []
count = 0
cache = [1] * N

for pivot in range(1, N):
    for prev in range(0, pivot):
        if soldier[pivot] < soldier[prev] and cache[prev] >= cache[pivot]:
            cache[pivot] = cache[prev] + 1
print(N - max(cache))
