package 다이나믹프로그래밍;

import java.util.Scanner;

public class 타일장식물 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		long[] dp = new long[target + 1];
		solution(dp, target);

	}

	private static void solution(long[] dp, int target) {
		dp[1] = 4;
		if (target >= 2) {
			dp[2] = 6;
		}
		for (int idx = 3; idx <= target; idx++) {
			dp[idx] = dp[idx - 2] + dp[idx - 1];
		}
		System.out.println(dp[target]);
	}
}
