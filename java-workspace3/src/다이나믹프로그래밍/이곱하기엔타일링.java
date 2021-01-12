package 다이나믹프로그래밍;

public class 이곱하기엔타일링 {
	public int solution(int n) {
		long mod = 1000000007;
		long[] dp = new long[n + 1];
		dp[1] = 1;
		if (n >= 2) {
			dp[2] = 2;
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
		}
		return (int) dp[n];
	}
}
