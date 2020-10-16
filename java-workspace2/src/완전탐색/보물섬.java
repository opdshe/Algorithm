package 완전탐색;

import java.util.*;

public class 보물섬 {
	static Scanner scanner = new Scanner(System.in);
	static int maxRow;
	static int maxColumn;
	static char[][] map;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static int answer = 0;

	public static void main(String[] args) {
		maxRow = scanner.nextInt();
		maxColumn = scanner.nextInt();
		scanner.nextLine();
		map = new char[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			String oneLine = scanner.nextLine();
			for (int column = 0; column < maxColumn; column++) {
				map[row][column] = oneLine.charAt(column);
			}
		}
		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
				if (map[row][column] == 'L') {
					bfs(map, row, column);
				}
			}
		}
		System.out.println(answer);
	}

	private static void bfs(char[][] map, int row, int column) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] visited = new int[maxRow][maxColumn];
		visited[row][column] = 1;
		queue.add(new int[]{row, column});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			answer = Math.max(answer, visited[current[0]][current[1]] - 1);
			for (int[] direction : directions) {
				int nextRow = current[0] + direction[0];
				int nextColumn = current[1] + direction[1];
				if (isAvailablePosition(nextRow, nextColumn)) {
					if (visited[nextRow][nextColumn] == 0 && map[nextRow][nextColumn] == 'L') {
						visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
						queue.add(new int[]{nextRow, nextColumn});
					}
				}
			}
		}
	}

	private static boolean isAvailablePosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}
}
