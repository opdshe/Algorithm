package 다이나믹프로그래밍;

import java.util.Scanner;

public class 연속부최대곱 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		double[] numbers = new double[countOfNumber];
		for (int idx = 0; idx < countOfNumber; idx++) {
			numbers[idx] = scanner.nextFloat();
		}
		solution(numbers, countOfNumber);
	}

	private static void solution(double[] numbers, int countOfNumber) {
		if (countOfNumber == 1) {
			System.out.println(String.format("%.3f", numbers[0]));
			return;
		}
		double[] dp = new double[countOfNumber];
		dp[0] = numbers[0];
		double answer = dp[0];
		for (int pivot = 1; pivot < countOfNumber; pivot++) {
			if (dp[pivot - 1] >= 1) {
				dp[pivot] = dp[pivot - 1] * numbers[pivot];
			} else {
				dp[pivot] = numbers[pivot];
			}
			answer = Math.max(answer, dp[pivot]);
		}
		System.out.println(String.format("%.3f", answer));
	}
}
