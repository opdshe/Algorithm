package 다이나믹프로그래밍;

import java.util.Scanner;

public class 쉬운계단수 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int length = scanner.nextInt();
		solution(length);
	}

	private static void solution(int length) {
		int[][] dp = new int[length + 1][10];
		for (int idx = 0; idx <= 9; idx++) {
			dp[1][idx] = 1;
		}
		for (int len = 2; len <= length; len++) {
			for (int idx = 0; idx <= 9; idx++) {
				int next;
				next = idx - 1;
				if (next >= 0 && next <= 9) {
					dp[len][idx] = (dp[len][idx] + dp[len - 1][next]) % 1000000000;
				}
				next = idx + 1;
				if (next >= 0 && next <= 9) {
					dp[len][idx] = (dp[len][idx] + dp[len - 1][next]) % 1000000000;
				}
			}
		}
		long sum = 0;
		for (int idx = 1; idx <= 9; idx++) {
			sum += dp[length][idx];
		}
		System.out.println(sum % 1000000000);
	}
}
