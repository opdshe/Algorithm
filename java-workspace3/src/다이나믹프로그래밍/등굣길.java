package 다이나믹프로그래밍;

public class 등굣길 {
	import java.util .*;

	class Solution {
		static final int MOD = 1000000007;

		public int solution(int m, int n, int[][] puddles) {
			long[][] dp = new long[n + 1][m + 1];
			dp[1][1] = 1;
			for (int[] puddle : puddles) {
				dp[puddle[1]][puddle[0]] = -1;
			}
			for (int row = 1; row <= n; row++) {
				for (int column = 1; column <= m; column++) {
					if (dp[row][column] == -1) {
						continue;
					}
					if (dp[row - 1][column] != -1) {
						dp[row][column] = (dp[row][column] + dp[row - 1][column]) % MOD;
					}
					if (dp[row][column - 1] != -1) {
						dp[row][column] = (dp[row][column] + dp[row][column - 1]) % MOD;
					}
				}
			}
			return (int) dp[n][m] % MOD;
		}
	}
}
