package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 거슴른돈 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		solution(target);
	}

	private static void solution(int target) {
		int[] coins = new int[]{2, 5};
		int[] dp = new int[target + 1];
		int INF = 0xfffffff;
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int coin : coins) {
			for (int num = coin; num <= target; num++) {
				if (dp[num - coin] != INF) {
					dp[num] = Math.min(dp[num], dp[num - coin] + 1);
				}
			}
		}
		System.out.println(dp[target] == INF ? -1 : dp[target]);
	}
}
