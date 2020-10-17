package 다이나믹프로그래밍;

import java.util.Scanner;

public class 가장큰증가하는부분수열 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumbers = scanner.nextInt();
		int[] numbers = new int[countOfNumbers];
		for (int idx = 0; idx < countOfNumbers; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		solution(numbers, countOfNumbers);
	}

	private static void solution(int[] numbers, int countOfNumbers) {
		int[] dp = new int[countOfNumbers];
		int answer = numbers[0];
		dp[0] = numbers[0];
		for (int idx = 1; idx < countOfNumbers; idx++) {
			for (int prev = 0; prev < idx; prev++) {
				if (numbers[idx] > numbers[prev] && dp[prev] > dp[idx]) {
					dp[idx] = dp[prev];
				}
			}
			dp[idx] += numbers[idx];
			answer = Math.max(answer, dp[idx]);
		}
		System.out.println(answer);
	}
}
