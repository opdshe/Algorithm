package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 내리막길 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int maxRow;
	static int maxColumn;
	static int[][] map;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) throws IOException {
		int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		maxRow = sizeInfo[0];
		maxColumn = sizeInfo[1];
		map = new int[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			map[row] = Arrays.stream(bufferedReader.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
		}
		int[][] dp = new int[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			Arrays.fill(dp[row], -1);
		}
		int answer = dfs(dp, 0, 0);
		System.out.println(answer);
	}

	private static int dfs(int[][] dp, int row, int column) {
		if (dp[row][column] != -1) {
			return dp[row][column];
		}
		if (row == maxRow - 1 && column == maxColumn - 1) {
			return 1;
		}
		int current = map[row][column];
		int base = 0;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn) && current > map[nextRow][nextColumn]) {
				base += dfs(dp, nextRow, nextColumn);
			}
		}
		return dp[row][column] = base;
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}
}
