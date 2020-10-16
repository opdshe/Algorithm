package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 제곱수의합 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int square = (int) Math.sqrt(target);
		int[] dp = new int[target + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int unit = 1; unit <= square; unit++) {
			int num = (int) Math.pow(unit, 2);
			for (int n = num; n <= target; n++) {
				if (dp[n - num] != INF) {
					dp[n] = Math.min(dp[n], dp[n - num] + 1);
				}
			}
		}
		System.out.println(dp[target]);
	}
}
