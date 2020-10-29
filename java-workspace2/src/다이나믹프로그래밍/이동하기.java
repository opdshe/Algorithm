package 다이나믹프로그래밍;

import java.util.Scanner;

public class 이동하기 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;

	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		int[][] map = new int[maxRow + 1][maxColumn + 1];
		for (int row = 1; row <= maxRow; row++) {
			for (int column = 1; column <= maxColumn; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		solution(map);
	}

	private static void solution(int[][] map) {
		int[][] dp = new int[maxRow + 1][maxColumn + 1];

		for (int row = 1; row <= maxRow; row++) {
			for (int column = 1; column <= maxColumn; column++) {
				int result = 0;
				result = Math.max(dp[row - 1][column], dp[row - 1][column - 1]);
				result = Math.max(result, dp[row][column - 1]);
				dp[row][column] = result + map[row][column];
			}
		}
		System.out.println(dp[maxRow][maxColumn]);
	}
}
