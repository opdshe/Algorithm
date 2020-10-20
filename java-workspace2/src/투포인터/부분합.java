package 투포인터;

import java.util.Scanner;

public class 부분합 {
	static Scanner scanner = new Scanner(System.in);
	static int countOfNumber;
	static int minSum;
	static int[] numbers;

	public static void main(String[] args) {
		countOfNumber = scanner.nextInt();
		minSum = scanner.nextInt();
		numbers = new int[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		solution();
	}

	private static void solution() {
		int left = 0;
		int right = 0;
		long sum = 0;
		int answer = Integer.MAX_VALUE;

		while (true) {
			if (sum >= minSum) {
				answer = Math.min(answer, right - left);
				sum -= numbers[left++];
			} else if (right == countOfNumber) {
				break;
			} else {
				sum += numbers[right++];
			}
		}
		System.out.println(answer == countOfNumber ? 0 : answer);
	}
}
