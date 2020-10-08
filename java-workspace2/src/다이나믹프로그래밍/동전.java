package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(bufferedReader.readLine());
		for (int test = 0; test < testcase; test++) {
			int countOfCoin = Integer.parseInt(bufferedReader.readLine());
			int[] coins = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			int target = Integer.parseInt(bufferedReader.readLine());
			solution(coins, countOfCoin, target);
		}
	}

	private static void solution(int[] coins, int countOfCoin, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int num = coin; num <= target; num++) {
				dp[num] += dp[num - coin];
			}
		}
		System.out.println(dp[target]);
	}
}
