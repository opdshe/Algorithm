package 다이나믹프로그래밍;

import java.util.Scanner;

public class 파스칼의삼각형 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		solution(row, column);
	}

	private static void solution(int row, int column) {
		int[][] dp = new int[row + 1][row + 1];
		dp[1][1] = 1;

		if (row >= 2) {
			dp[2][1] = 1;
			dp[2][2] = 1;
		}

		for (int r = 1; r <= row; r++) {
			for (int c = 1; c <= r; c++) {
				if (c == 1 || c == r) {
					dp[r][c] = 1;
				} else {
					dp[r][c] = dp[r - 1][c - 1] + dp[r - 1][c];
				}
			}
		}
		System.out.println(dp[row][column]);
	}
}
