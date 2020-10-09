package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class 벽부수고이동하기 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int maxRow = input[0];
		int maxColumn = input[1];
		int[][] map = new int[maxRow][maxColumn];
		for (int row = 0; row < maxRow; row++) {
			map[row] = Arrays.stream(bufferedReader.readLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}

		solution(map, maxRow, maxColumn);
	}

	private static void solution(int[][] map, int maxRow, int maxColumn) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[2][maxRow][maxColumn];
		visited[0][0][0] = true;
		queue.add(new Point(0, 0, 0, 1));

		int answer = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			if (current.y == maxRow - 1 && current.x == maxColumn - 1) {
				answer = Math.min(answer, current.distance);
				continue;
			}
			for (int[] direction : directions) {
				int nextRow = current.y + direction[0];
				int nextColumn = current.x + direction[1];
				if (isAvailablePosition(maxRow, maxColumn, nextRow, nextColumn)) {
					if (map[nextRow][nextColumn] == 0) {
						if (!visited[current.destroyed][nextRow][nextColumn]) {
							visited[current.destroyed][nextRow][nextColumn] = true;
							queue.add(new Point(nextRow, nextColumn, current.destroyed, current.distance + 1));
						}
					} else if (map[nextRow][nextColumn] == 1) {
						if (current.destroyed == 0) {
							if (!visited[1][nextRow][nextColumn]) {
								visited[1][nextRow][nextColumn] = true;
								queue.add(new Point(nextRow, nextColumn, 1, current.distance + 1));
							}
						}
					}
				}
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static boolean isAvailablePosition(int maxRow, int maxColumn, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < maxRow &&
				nextColumn >= 0 && nextColumn < maxColumn;
	}

	private static class Point {
		private int y;
		private int x;
		private int destroyed;
		private int distance;

		public Point(int y, int x, int destroyed, int distance) {
			this.y = y;
			this.x = x;
			this.destroyed = destroyed;
			this.distance = distance;
		}
	}
}
