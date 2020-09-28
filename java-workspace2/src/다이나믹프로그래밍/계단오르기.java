package 다이나믹프로그래밍;

import java.util.Scanner;

public class 계단오르기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfStairs = scanner.nextInt();
		int[] cost = new int[countOfStairs + 1];
		for (int idx = 1; idx <= countOfStairs; idx++) {
			cost[idx] = scanner.nextInt();
		}
		solutions(cost, countOfStairs);
	}

	private static int solutions(int[] cost, int target) {
		int[] dp = new int[target + 1];
		dp[1] = cost[1];
		if (target >= 2) {
			dp[2] = Math.max(dp[1] + cost[2], cost[2]);
		}
		for (int idx = 3; idx <= target; idx++) {
			dp[idx] = Math.max(dp[idx - 3] + cost[idx - 1] + cost[idx], dp[idx - 2] + cost[idx]);
		}
		System.out.println(dp[target]);
		return dp[target];
	}

}
