package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 알지비거리 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int[][] cost = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];
		int answer = 0xfffffff;
		scanner.nextLine();
		for (int i = 1; i <= N; i++) {
			cost[i] = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
		}
		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, dp[N][i]);
		}
		System.out.println(answer);
	}
}
