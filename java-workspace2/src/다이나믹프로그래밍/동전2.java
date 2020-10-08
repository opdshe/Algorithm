package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전2 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] coins = new int[input[0]];
		for (int idx = 0; idx < input[0]; idx++) {
			coins[idx] = Integer.parseInt(bufferedReader.readLine());
		}
		solution(coins, input[0], input[1]);
	}

	private static void solution(int[] coins, int countOfCoins, int target) {
		int INF = 0xfffffff;
		int[] dp = new int[target + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int coin : coins) {
			for (int num = coin; num <= target; num++) {
				dp[num] = Math.min(dp[num - coin] + 1, dp[num]);
			}
		}
		System.out.println(dp[target] == INF ? -1 : dp[target]);
	}
}
