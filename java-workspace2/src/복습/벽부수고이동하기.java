package 복습;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 벽부수고이동하기 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;
	static int[][] map;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		map = new int[maxRow][maxColumn];
		scanner.nextLine();
		for (int row = 0; row < maxRow; row++) {
			map[row] = Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		boolean[][] visited = new boolean[maxRow][maxColumn];
		dfs(visited, 0, 0, 1, false);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static void dfs(boolean[][] visited, int row, int column, int cost, boolean destroy) {
		if (row == maxRow - 1 && column == maxColumn - 1) {
			answer = Math.min(answer, cost);
			return;
		}
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isAvailablePosition(nextRow, nextColumn)) {
				if (map[nextRow][nextColumn] == 0 && !visited[nextRow][nextColumn]) {
					visited[nextRow][nextColumn] = true;
					dfs(visited, nextRow, nextColumn, cost + 1, destroy);
					visited[nextRow][nextColumn] = false;
				} else if (map[nextRow][nextColumn] == 1 && !visited[nextRow][nextColumn]) {
					if (!destroy) {
						visited[nextRow][nextColumn] = true;
						dfs(visited, nextRow, nextColumn, cost + 1, true);
						visited[nextRow][nextColumn] = false;
					}
				}
			}
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}

	private static class Node {
		int y;
		int x;
		int cost;
		boolean destroy;

		public Node(int y, int x, int cost, boolean destroy) {
			this.y = y;
			this.x = x;
			this.cost = cost;
			this.destroy = destroy;
		}
	}
}
