package 다이나믹프로그래밍;

import java.util.Scanner;

public class 파도반수열 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int n = scanner.nextInt();
			solution(n);
		}
	}

	private static void solution(int n) {
		if (n <= 3) {
			System.out.println(1);
			return;
		}
		long[] dp = new long[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for (int idx = 4; idx <= n; idx++) {
			dp[idx] = dp[idx - 3] + dp[idx - 2];
		}
		System.out.println(dp[n]);
	}
}
