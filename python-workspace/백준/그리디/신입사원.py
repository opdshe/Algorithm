import sys

testcase = int(sys.stdin.readline())
for _ in range(testcase):
    count_of_people = int(sys.stdin.readline())
    candidates = []
    for _ in range(count_of_people):
        first, second = map(int, sys.stdin.readline().split(" "))
        candidates.append((first, second))
    candidates.sort(key=lambda x: x[0])
    count =0
    for i in range(count_of_people):
        for j in range(0, i):
            if candidates[i][1] > candidates[j][1]:
                count+=1
                break
    print(count_of_people - count)