package 다이나믹프로그래밍;

import java.util.Scanner;

public class 이곱하기엔타일링 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		solution(target);
	}

	private static void solution(int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int level = 2; level <= target; level++) {
			dp[level] = (dp[level - 1] + dp[level - 2]) % 10007;
		}
		System.out.println(dp[target]);
	}
}
