package 다이나믹프로그래밍;

import java.util.Scanner;

public class 피보나치수5 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		long[] dp = new long[target + 1];
		System.out.println(fib(dp, target));
	}

	private static long fib(long[] dp, int target) {
		if (dp[target] != 0) {
			return dp[target];
		}
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		return dp[target] = fib(dp, target - 1) + fib(dp, target - 2);
	}
}
