package 다이나믹프로그래밍;

import java.util.Scanner;

public class 이친수 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int length = scanner.nextInt();
		solution(length);
	}

	private static void solution(int length) {
		if (length == 1) {
			System.out.println(1);
			return;
		}
		long[][] dp = new long[length + 1][2];
		dp[1][0] = 1;
		dp[1][1] = 1;
		for (int idx = 2; idx <= length; idx++) {
			for (int target = 0; target < 2; target++) {
				if (target == 0) {
					dp[idx][target] = dp[idx - 1][0] + dp[idx - 1][1];
				} else {
					dp[idx][target] = dp[idx - 1][0];
				}
			}
		}
		System.out.println(dp[length][1]);
	}
}
