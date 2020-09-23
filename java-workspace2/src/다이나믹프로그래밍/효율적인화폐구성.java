package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 효율적인화폐구성 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int target = scanner.nextInt();
		int[] units = new int[N];
		for (int i = 0; i < N; i++) {
			units[i] = scanner.nextInt();
		}
		Arrays.sort(units);
		search(units, target);

	}

	private static void search(int[] units, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		for (int unit : units) {
			for (int num = unit; num <= target; num++) {
				if (dp[num - unit] != 10001) {
					dp[num] = Math.min(dp[num - unit] + 1, dp[num]);
				}
			}
		}
		if (dp[target] == 10001) {
			System.out.println("No answer");
		} else {
			System.out.println(dp[target]);
		}
	}
}
