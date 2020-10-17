package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 카드구매하기2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfCard = scanner.nextInt();
		int[] cards = new int[countOfCard + 1];
		for (int idx = 1; idx <= countOfCard; idx++) {
			cards[idx] = scanner.nextInt();
		}
		solution(cards, countOfCard);
	}

	private static void solution(int[] cards, int countOfCard) {
		int[] dp = new int[countOfCard + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int idx = 1; idx <= countOfCard; idx++) {
			for (int num = idx; num <= countOfCard; num++) {
				if (dp[num - idx] != INF) {
					dp[num] = Math.min(dp[num], dp[num - idx] + cards[idx]);
				}
			}
		}
		System.out.println(dp[countOfCard]);
	}
}
