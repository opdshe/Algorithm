package 분류안함;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int[] units = new int[]{3, 5};
		int[] dp = new int[target + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int unit : units) {
			for (int weight = unit; weight <= target; weight++) {
				if (dp[weight - unit] != INF) {
					dp[weight] = Math.min(dp[weight], dp[weight - unit] + 1);
				}
			}
		}
		System.out.println(dp[target] == INF ? -1 : dp[target]);
	}
}
