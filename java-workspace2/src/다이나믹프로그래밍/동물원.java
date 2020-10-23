package 다이나믹프로그래밍;

import java.util.Scanner;

public class 동물원 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int length = scanner.nextInt();
		solution(length);
	}

	private static void solution(int length) {
		int[][] dp = new int[length + 1][3];
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;

		for (int len = 2; len <= length; len++) {
			dp[len][0] = (dp[len - 1][0] + dp[len - 1][1] + dp[len - 1][2]) % 9901;
			dp[len][1] = (dp[len - 1][0] + dp[len - 1][2]) % 9901;
			dp[len][2] = (dp[len - 1][0] + dp[len - 1][1]) % 9901;
		}
		long total = 0;
		for (int column = 0; column < 3; column++) {
			total += (dp[length][column]) % 9901;
		}
		System.out.println(total % 9901);
	}
}
