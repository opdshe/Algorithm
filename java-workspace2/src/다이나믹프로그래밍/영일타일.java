package 다이나믹프로그래밍;

import java.util.Scanner;

public class 영일타일 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int length = scanner.nextInt();
		solution(length);
	}

	private static void solution(int length) {
		int[] dp = new int[length + 1];
		dp[0] = 1;
		dp[1] = 1;
		if (length >= 2) {
			dp[2] = 2;
		}
		for (int idx = 3; idx <= length; idx++) {
			dp[idx] = (dp[idx] + dp[idx - 1]) % 15746;
			dp[idx] = (dp[idx] + dp[idx - 2]) % 15746;
		}
		System.out.println(dp[length] % 15746);
	}
}
