package 다이나믹프로그래밍;

public class 멀리뛰기 {
	private static final int MOD = 1234567;

	public long solution(int n) {
		long[] dp = new long[n + 1];
		dp[1] = 1;
		if (n >= 2) {
			dp[2] = 2;
		}
		for (int idx = 3; idx <= n; idx++) {
			dp[idx] = (dp[idx - 1] + dp[idx - 2]) % MOD;
		}
		return dp[n] % MOD;
	}
}
