package 다이나믹프로그래밍;

public class 보행자천국 {
	static int MOD = 20170805;

	public int solution(int m, int n, int[][] cityMap) {
		int[][][] dp = new int[m + 1][n + 1][2];
		dp[1][1][0] = 1;
		dp[1][1][1] = 1;
		for (int r = 1; r <= m; r++) {
			for (int c = 1; c <= n; c++) {
				if (cityMap[r - 1][c - 1] == 0) {
					dp[r][c][0] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
					dp[r][c][1] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
				} else if (cityMap[r - 1][c - 1] == 1) {
					dp[r][c][0] = 0;
					dp[r][c][1] = 0;
				} else {
					dp[r][c][0] += dp[r - 1][c][0] % MOD;
					dp[r][c][1] += dp[r][c - 1][1] % MOD;
				}
			}
		}
		return dp[m][n][0];
	}
}
