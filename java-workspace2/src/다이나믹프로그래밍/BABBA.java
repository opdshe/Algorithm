package 다이나믹프로그래밍;

import java.util.Scanner;

public class BABBA {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		solution(target);
	}

	private static void solution(int target) {
		int[][] dp = new int[target + 1][2];
		dp[0][0] = 1;
		dp[0][1] = 0;

		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int idx = 2; idx <= target; idx++) {
			dp[idx][0] = dp[idx - 2][0] + dp[idx - 1][0];
			dp[idx][1] = dp[idx - 2][1] + dp[idx - 1][1];
		}
		System.out.println(dp[target][0] + " " + dp[target][1]);
	}
}
