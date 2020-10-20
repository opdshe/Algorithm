package 완전탐색.DFS;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 안전영역 {
	static Scanner scanner = new Scanner(System.in);
	static int size;
	static int[][] map;
	static int minHeight = 100;
	static int maxHeight = 1;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		size = scanner.nextInt();
		map = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
				minHeight = Math.min(minHeight, map[row][column]);
				maxHeight = Math.max(maxHeight, map[row][column]);
			}
		}
		int answer = 0;
		for (int height = minHeight - 1; height <= maxHeight; height++) {
			boolean[][] visited = new boolean[size][size];
			int count = 0;
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					if (!visited[row][column] && map[row][column] >= height) {
						dfs(visited, height, row, column);
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}

	private static void dfs(boolean[][] visited, int height, int row, int column) {
		visited[row][column] = true;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn)) {
				if (!visited[nextRow][nextColumn] && map[nextRow][nextColumn] >= height) {
					dfs(visited, height, nextRow, nextColumn);
				}
			}
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextColumn >= 0 && nextColumn < size &&
				nextRow >= 0 && nextRow < size;
	}
}