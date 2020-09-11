package 코테대비중요문제;

import java.util.*;

public class 벽부수고이동하기 {
	static Scanner scanner = new Scanner(System.in);
	static int maxHeight;
	static int maxWidth;
	static int[][] map;
	static boolean[][][] visited;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, 1},
			new int[]{0, -1}
	);

	public static void main(String[] args) {
		maxHeight = scanner.nextInt();
		maxWidth = scanner.nextInt();
		visited = new boolean[2][maxHeight][maxWidth];
		map = new int[maxHeight][maxWidth];
		scanner.nextLine();
		for (int h = 0; h < maxHeight; h++) {
			map[h] = Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		bfs();
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 1, 0));
		int answer = -1;
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			if (current.y == maxHeight - 1 && current.x == maxWidth - 1) {
				answer = current.distance;
				break;
			}
			for (int[] offset : directions) {
				int nextHeight = current.y + offset[0];
				int nextWidth = current.x + offset[1];
				if (isAvailablePosition(nextHeight, nextWidth)) {
					if (current.destroyed == 1) {
						if (map[nextHeight][nextWidth] == 0 && !visited[1][nextHeight][nextWidth]) {
							visited[1][nextHeight][nextWidth] = true;
							queue.add(new Point(nextHeight, nextWidth, current.distance + 1, 1));
						}
					} else {
						if (map[nextHeight][nextWidth] == 0 && !visited[0][nextHeight][nextWidth]) {
							visited[0][nextHeight][nextWidth] = true;
							queue.add(new Point(nextHeight, nextWidth, current.distance + 1, 0));
						} else if (map[nextHeight][nextWidth] == 1 && !visited[1][nextHeight][nextWidth]) {
							visited[1][nextHeight][nextWidth] = true;
							queue.add(new Point(nextHeight, nextWidth, current.distance + 1, 1));
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean isAvailablePosition(int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < maxHeight &&
				nextWidth >= 0 && nextWidth < maxWidth;
	}

	private static class Point {
		private int y;
		private int x;
		private int distance;
		private int destroyed;

		public Point(int y, int x, int distance, int destroyed) {
			this.y = y;
			this.x = x;
			this.distance = distance;
			this.destroyed = destroyed;
		}
	}
}
