package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class FourSquares {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		solution(target);
	}

	private static void solution(int target) {
		int[] dp = new int[target + 1];
		int maxValue = (int) Math.sqrt(target);
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int value = 1; value <= maxValue; value++) {
			int square = (int) Math.pow(value, 2);
			for (int num = square; num <= target; num++) {
				if (dp[num - square] != INF) {
					dp[num] = Math.min(dp[num], dp[num - square] + 1);
				}
			}
		}
		System.out.println(dp[target]);
	}
}
