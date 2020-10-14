package 다이나믹프로그래밍;

import java.util.Scanner;

public class 스티커 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int countOfColumn = scanner.nextInt();
			int[][] stickers = new int[3][countOfColumn + 1];
			for (int row = 1; row <= 2; row++) {
				for (int column = 1; column <= countOfColumn; column++) {
					stickers[row][column] = scanner.nextInt();
				}
			}
			solution(stickers, countOfColumn);
		}
	}

	private static void solution(int[][] stickers, int countOfColumn) {
		int[][] dp = new int[3][countOfColumn + 1];
		dp[1][1] = stickers[1][1];
		dp[2][1] = stickers[2][1];

		if (countOfColumn >= 2) {
			dp[1][2] = stickers[2][1] + stickers[1][2];
			dp[2][2] = stickers[1][1] + stickers[2][2];
		}

		for (int column = 3; column <= countOfColumn; column++) {
			for (int row = 1; row <= 2; row++) {
				dp[row][column] = dp[row][column - 2] + stickers[row][column];
				dp[row][column] = Math.max(dp[row][column], dp[(row % 2) + 1][column - 1] + stickers[row][column]);
				dp[row][column] = Math.max(dp[row][column], dp[row][column - 2] + stickers[row][column]);
				dp[row][column] = Math.max(dp[row][column], dp[(row % 2) + 1][column - 2] + stickers[row][column]);

			}
		}
		/*for (int row = 1; row <= 2; row++) {
			for (int column = 1; column <= countOfColumn; column++) {
				System.out.print(dp[row][column] + " ");
			}
			System.out.println();
		}*/
		int answer = Math.max(dp[1][countOfColumn], dp[2][countOfColumn]);
		System.out.println(answer);
	}
}
