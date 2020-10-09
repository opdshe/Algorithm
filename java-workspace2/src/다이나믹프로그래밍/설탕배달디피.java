package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달디피 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int[] dp = new int[target + 1];
		int[] units = new int[]{3, 5};
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int unit : units) {
			for (int num = unit; num <= target; num++) {
				if (dp[num - unit] != INF) {
					dp[num] = dp[num - unit] + 1;
				}
			}
		}
		System.out.println(dp[target] == INF ? -1 : dp[target]);
	}
}
