package 다이나믹프로그래밍;

import java.util.Scanner;

public class 점화식 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		long[] dp = new long[target + 1];
		dp[0] = 1;
		System.out.println(recursion(dp, target));
	}

	private static long recursion(long[] dp, int target) {
		if (dp[target] != 0) {
			return dp[target];
		}
		if (target == 0) {
			return 1;
		}
		long sum = 0;
		for (int idx = 0; idx < target; idx++) {
			sum += recursion(dp, idx) * recursion(dp, target - 1 - idx);
		}
		return dp[target] = sum;
	}
}
