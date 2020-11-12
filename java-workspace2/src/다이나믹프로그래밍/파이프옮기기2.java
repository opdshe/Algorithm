package 다이나믹프로그래밍;

import java.util.Scanner;

public class 파이프옮기기2 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;
	static long[][][] dp;


	public static void main(String[] args) {
		size = scanner.nextInt();
		map = new int[size][size];
		dp = new long[3][size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		System.out.println(dfs(0, 0, 1));
	}

	private static long dfs(int state, int row, int column) {
		if (row == size - 1 && column == size - 1) {
			return 1;
		}
		if (dp[state][row][column] != 0) {
			return dp[state][row][column];
		}
		boolean availableToGoRight = column + 1 < size && map[row][column + 1] == 0;
		boolean availableToGoDown = row + 1 < size && map[row + 1][column] == 0;
		long total = 0;
		if (availableToGoRight && state != 1) {
			total += dfs(0, row, column + 1);
		}
		if (availableToGoDown && state != 0) {
			total += dfs(1, row + 1, column);
		}
		if (availableToGoRight && availableToGoDown && map[row + 1][column + 1] == 0) {
			total += dfs(2, row + 1, column + 1);
		}
		return dp[state][row][column] = total;
	}
}
