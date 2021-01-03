package 다이나믹프로그래밍;

public class 피보나치수 {
    public int solution(int n) {
        int mod = 1234567;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int num = 2; num <= n; num++) {
            dp[num] = (dp[num - 1] + dp[num - 2]) % mod;
        }
        return dp[n] % mod;
    }
}
