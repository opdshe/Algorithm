package 다이나믹프로그래밍;

import java.util.Scanner;

public class 안녕 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		int[] costs = new int[countOfPeople + 1];
		int[] pleasures = new int[countOfPeople + 1];
		long[][] dp = new long[countOfPeople + 1][100];
		for (int idx = 1; idx <= countOfPeople; idx++) {
			costs[idx] = scanner.nextInt();
		}
		for (int idx = 1; idx <= countOfPeople; idx++) {
			pleasures[idx] = scanner.nextInt();
		}
		for (int maxIdx = 1; maxIdx <= countOfPeople; maxIdx++) {
			for (int hp = 1; hp < 100; hp++) {
				int cost = costs[maxIdx];
				int pleasure = pleasures[maxIdx];
				if (hp >= cost) {
					dp[maxIdx][hp] = Math.max(dp[maxIdx - 1][cost],
							dp[maxIdx - 1][hp - cost] + pleasure);
				} else {
					dp[maxIdx][hp] = dp[maxIdx - 1][hp];
				}
			}
		}
		System.out.println(dp[countOfPeople][99]);
	}
}
