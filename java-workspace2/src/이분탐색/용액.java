package 이분탐색;

import java.util.Scanner;

public class 용액 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int[] numbers = new int[size];
		for (int idx = 0; idx < size; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		solution(numbers, size);
	}

	private static void solution(int[] numbers, int size) {
		int left = 0;
		int right = size - 1;
		int diff = Integer.MAX_VALUE;
		int leftValue = 0;
		int rightValue = Integer.MAX_VALUE;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (diff > Math.abs(sum)) {
				diff = Math.abs(sum);
				leftValue = numbers[left];
				rightValue = numbers[right];
			}
			if (sum >= 0) {
				right--;
			} else {
				left++;
			}

		}
		System.out.println(leftValue + " " + rightValue);
	}
}
