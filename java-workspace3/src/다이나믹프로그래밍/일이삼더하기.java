package 다이나믹프로그래밍;

import java.util.Scanner;

public class 일이삼더하기 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int target = scanner.nextInt();
			solution(target);
		}
	}

	private static void solution(int target) {
		int[] dp = new int[target + 1];
		dp[1] = 1;
		if (target >= 2) {
			dp[2] = 2;
		}
		if (target >= 3) {
			dp[3] = 4;
		}
		for (int num = 4; num <= target; num++) {
			dp[num] = dp[num - 1] + dp[num - 2] + dp[num - 3];
		}
		System.out.println(dp[target]);
	}
}
