package 다이나믹프로그래밍;

import java.util.Scanner;

public class 이친수 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		long answer = solution(target);
		System.out.println(answer);

	}

	private static long solution(int target) {
		long[] dp = new long[target + 1];
		dp[1] = 1;
		if (target >= 2) {
			dp[2] = 1;
		}
		for (int idx = 3; idx <= target; idx++) {
			dp[idx] = dp[idx - 1] + dp[idx - 2];
		}
		return dp[target];
	}
}
