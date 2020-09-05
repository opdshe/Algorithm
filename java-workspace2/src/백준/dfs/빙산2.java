package 백준.dfs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 빙산2 {
	static Scanner scanner = new Scanner(System.in);
	static int height;
	static int width;
	static int remaining = 0;
	static int[][] board;
	static int count = 0;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int[][] removeBoard;
	static boolean[][] visited;

	public static void main(String[] args) {
		height = scanner.nextInt();
		width = scanner.nextInt();
		board = new int[height][width];
		removeBoard = new int[height][width];
		visited = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = scanner.nextInt();
				if (board[i][j] > 0) {
					remaining++;
				}
			}
		}
		search();

	}

	private static void search() {
		int time = 0;
		int answer = -1;
		while (true) {
			time++;
			int token = 0;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (board[i][j] > 0) {
						removeBoard[i][j] = getAdjacent(i, j);
					}
				}
			}
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int remove = removeBoard[i][j];
					if (remove > 0) {
						token++;
					}
					board[i][j] = board[i][j] - remove;
					if (board[i][j] <= 0 && remove != 0) {
						remaining--;
						board[i][j] = 0;
					}
				}
			}

			int dfsCount = 0;
			for (int i = 0; i < height; i++) {
				if (dfsCount > 1) {
					break;
				}
				for (int j = 0; j < width; j++) {
					if (board[i][j] > 0 && !visited[i][j]) {
						dfs(i, j);
						dfsCount++;
					}
				}
			}
			visited = new boolean[height][width];

			if (dfsCount > 1) {
				answer = time;
				break;
			}
			if (token == 0) {
				answer = 0;
				break;
			}
		}
		System.out.println(answer);
	}

	private static int getAdjacent(int height, int width) {
		int answer = 0;
		for (int[] direction : directions) {
			int nextHeight = height + direction[0];
			int nextWidth = width + direction[1];
			if (isAvailablePosition(nextHeight, nextWidth)) {
				if (board[nextHeight][nextWidth] == 0) {
					answer++;
				}
			}
		}
		return answer;
	}

	private static void dfs(int height, int width) {
		visited[height][width] = true;
		for (int[] offset : directions) {
			int nextHeight = height + offset[0];
			int nextWidth = width + offset[1];
			if (isAvailablePosition(nextHeight, nextWidth) && !visited[nextHeight][nextWidth] && board[nextHeight][nextWidth] > 0) {
				dfs(nextHeight, nextWidth);
			}
		}
	}

	private static boolean isAvailablePosition(int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < height &&
				nextWidth >= 0 && nextWidth < width;
	}
}
