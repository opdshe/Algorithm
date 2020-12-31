import sys


def search():
    left = 0
    right = 0
    sum = 0
    count = 0

    while True:
        if sum >= target:
            if sum == target:
                count += 1
            sum -= numbers[left]
            left += 1
        elif right == count_of_numbers:
            break
        else:
            sum += numbers[right]
            right += 1
    print(count)


count_of_numbers, target = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().split()))
search()
