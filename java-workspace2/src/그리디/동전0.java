package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class 동전0 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfCoins = scanner.nextInt();
		int[] coins = new int[countOfCoins];
		int target = scanner.nextInt();
		for (int idx = 0; idx < countOfCoins; idx++) {
			coins[idx] = scanner.nextInt();
		}
		solution(coins, target);
	}

	private static void solution(int[] coins, int target) {
		int[] dp = new int[target + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int coin : coins) {
			for (int num = coin; num <= target; num++) {
				if (num - coin != INF) {
					dp[num] = Math.min(dp[num], dp[num - coin] + 1);
				}
			}
		}
		System.out.println(dp[target]);
	}
}
