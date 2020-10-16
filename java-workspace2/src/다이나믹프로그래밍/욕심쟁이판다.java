package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 욕심쟁이판다 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;
	static int count = 0;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		size = scanner.nextInt();
		map = new int[size][size];
		int[][] dp = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}

		int answer = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				int value = dfs(dp, row, column);
				answer = Math.max(answer, value);
			}
		}

		System.out.println(answer);
	}

	private static int dfs(int[][] dp, int row, int column) {
		if (dp[row][column] != 0) {
			return dp[row][column];
		}
		int maxDay = 1;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn)) {
				if (map[nextRow][nextColumn] > map[row][column]) {
					maxDay = Math.max(maxDay, dfs(dp, nextRow, nextColumn) + 1);
				}
			}
		}
		return dp[row][column] = maxDay;
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
