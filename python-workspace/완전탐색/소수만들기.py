from itertools import combinations

def solution(nums):
    comb = combinations(nums, 3)
    count = 0
    for c in comb:
        if is_prime_number(sum(c)):
            count += 1
    return count


def is_prime_number(sum):
    if sum == 1:
        return False
    if sum == 2:
        return True
    for num in range(2, sum):
        if sum % num == 0:
            return False
    return True


solution([1, 2, 3, 4])
