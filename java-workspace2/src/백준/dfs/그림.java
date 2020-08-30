package 백준.dfs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 그림 {
	static Scanner scanner = new Scanner(System.in);
	static int row;
	static int column;
	static int[][] board;
	static boolean[][] visited;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int countOfPictures = 0;
	static int maxSize = 0;
	static int count;

	public static void main(String[] args) {
		row = scanner.nextInt();
		column = scanner.nextInt();
		scanner.nextLine();

		board = new int[row][column];
		visited = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			board[i] = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				if (!visited[r][c] && board[r][c] == 1) {
					countOfPictures++;
					count = 0;
					dfs(r, c);
				}
			}
		}
		System.out.println(countOfPictures);
		System.out.println(maxSize);
	}

	private static void dfs(int row, int column) {
		count++;
		maxSize = Math.max(maxSize, count);
		visited[row][column] = true;
		for (int[] offset : directions) {
			int nextRow = row + offset[0];
			int nextColumn = column + offset[1];
			if (isAvailableToGo(nextRow, nextColumn)) {
				dfs(nextRow, nextColumn);
			}
		}
	}

	private static boolean isAvailableToGo(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < row &&
				nextColumn >= 0 && nextColumn < column &&
				!visited[nextRow][nextColumn] && board[nextRow][nextColumn] == 1;
	}
}
