package 다이나믹프로그래밍;

import java.util.Scanner;

public class 일로만들기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		solve(N);
	}

	private static int solve(int N) {
		int[] dp = new int[N + 1];
		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
		}
		System.out.println(dp[N]);
		return dp[N];
	}
}
