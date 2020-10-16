package 다이나믹프로그래밍;

import java.util.Scanner;

public class 카드구매하기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int[] cards = new int[target + 1];
		int[] dp = new int[target + 1];
		dp[0] = 0;
		for (int idx = 1; idx <= target; idx++) {
			cards[idx] = scanner.nextInt();
		}
		for (int idx = 1; idx <= target; idx++) {
			for (int num = idx; num <= target; num++) {
				dp[num] = Math.max(dp[num], dp[num - idx] + cards[idx]);
			}
		}
		System.out.println(dp[target]);
	}
}
