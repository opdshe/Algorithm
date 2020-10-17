package 다이나믹프로그래밍;

import java.util.Scanner;

public class 이곱하기앤타일링2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int width = scanner.nextInt();
		solution(width);
	}

	private static void solution(int width) {
		int[] dp = new int[width + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int w = 2; w <= width; w++) {
			dp[w] = (dp[w] + dp[w - 1]) % 10007;
			dp[w] = (dp[w] + dp[w - 2] * 2) % 10007;
		}
		System.out.println(dp[width] % 10007);
	}
}
