package 복습;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 욕심쟁이판다 {
	static Scanner scanner = new Scanner(System.in);
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int size;

	public static void main(String[] args) {
		size = scanner.nextInt();
		int[][] map = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		int[][] dp = new int[size][size];
		int answer = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				answer = Math.max(answer, dfs(map, dp, row, column));
			}
		}
		System.out.println(answer);
	}

	private static int dfs(int[][] map, int[][] dp, int row, int column) {
		if (dp[row][column] != 0) {
			return dp[row][column];
		}
		int current = map[row][column];
		int result = 0;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn) && current < map[nextRow][nextColumn]) {
				result = Math.max(result, dfs(map, dp, nextRow, nextColumn));
			}
		}
		return dp[row][column] = result + 1;
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
