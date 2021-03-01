package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 욕심쟁이판다 {
	static final Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;
	static int[][] dp;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		init();
		int answer = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				answer = Math.max(answer, search(row, column));
			}
		}
		System.out.println(answer);
	}

	private static int search(int row, int column) {
		if (dp[row][column] != 0) {
			return dp[row][column];
		}
		int offset = 0;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn) && map[nextRow][nextColumn] > map[row][column]) {
				offset = Math.max(offset, search(nextRow, nextColumn));
			}
		}
		return dp[row][column] = offset + 1;
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}

	private static void init() {
		size = scanner.nextInt();
		map = new int[size][size];
		dp = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
	}
}
