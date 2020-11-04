package 분류안함;

import java.util.Scanner;

public class 일로만들기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		solution(target);
	}

	private static void solution(int target) {
		int[] dp = new int[target + 1];
		dp[1] = 0;
		for (int num = 2; num <= target; num++) {
			dp[num] = dp[num - 1] + 1;
			if (num % 3 == 0) {
				dp[num] = Math.min(dp[num], dp[num / 3] + 1);
			} else if (num % 2 == 0) {
				dp[num] = Math.min(dp[num], dp[num / 2] + 1);
			}
		}
		System.out.println(dp[target]);
	}
}
