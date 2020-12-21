import sys


def back_tracking(units, sum, target):
    global answer
    if sum == target:
        answer += 1
    for unit in units:
        if sum + unit <= target:
            back_tracking(units, sum + unit, target)


answer = 0
testcase = int(sys.stdin.readline())
for _ in range(testcase):
    target = int(sys.stdin.readline())
    units = [1, 2, 3]
    answer = 0
    back_tracking(units, 0, target)
    print(answer)
