package 다이나믹프로그래밍;

import java.util.Scanner;

public class 오르막수 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int length = scanner.nextInt();
		solution(length);
	}

	private static void solution(int length) {
		int[][] dp = new int[length + 1][10];
		for (int idx = 0; idx < 10; idx++) {
			dp[1][idx] = 1;
		}
		for (int len = 2; len <= length; len++) {
			for (int pivot = 0; pivot < 10; pivot++) {
				for (int compare = 0; compare <= pivot; compare++) {
					dp[len][pivot] = (dp[len][pivot] + dp[len - 1][compare]) % 10007;
				}
			}
		}
		long answer = 0;
		for (int idx = 0; idx < 10; idx++) {
			answer = (answer + dp[length][idx]) % 10007;
		}
		System.out.println(answer % 10007);
	}
}
