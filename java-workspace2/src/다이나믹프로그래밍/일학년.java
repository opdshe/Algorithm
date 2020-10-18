package 다이나믹프로그래밍;

import java.util.Scanner;

public class 일학년 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		int[] numbers = new int[countOfNumber + 1];
		for (int idx = 1; idx <= countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		solution(numbers, countOfNumber);

	}

	private static void solution(int[] numbers, int countOfNumber) {
		long[][] dp = new long[countOfNumber + 1][21];
		dp[1][numbers[1]] = 1;
		for (int idx = 2; idx < countOfNumber; idx++) {
			for (int num = 0; num <= 20; num++) {
				if (dp[idx - 1][num] != 0) {
					if (num + numbers[idx] >= 0 && num + numbers[idx] <= 20) {
						dp[idx][num + numbers[idx]] += dp[idx - 1][num];
					}
					if (num - numbers[idx] >= 0 && num - numbers[idx] <= 20) {
						dp[idx][num - numbers[idx]] += dp[idx - 1][num];
					}
				}
			}
		}
		System.out.println(dp[countOfNumber - 1][numbers[countOfNumber]]);
	}
}
