from itertools import permutations


def solution(numbers):
    nums = list(str(numbers))
    answers = set()
    for length in range(1, len(numbers) + 1):
        for per in permutations(nums, length):
            number = int("".join(per))
            if is_prime(number):
                answers.add(number)
    return len(answers)


def is_prime(number):
    if number == 1 or number == 0:
        return False
    for num in range(2, number):
        if number % num == 0:
            return False
    return True
