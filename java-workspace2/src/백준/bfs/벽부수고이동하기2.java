package 백준.bfs;

import java.util.*;

public class 벽부수고이동하기2 {
	static Scanner scanner = new Scanner(System.in);
	static int[][] map;
	static int height;
	static int width;
	static int k;
	static boolean[][][] visited;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		init();
		bfs();
	}

	private static void bfs() {
		Queue<Position> queue = new ArrayDeque<>();
		queue.add(new Position(0, 0, 1, 0));
		int answer = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Position current = queue.poll();
			if (current.y == height - 1 && current.x == width - 1) {
				answer = Math.min(answer, current.cost);
				continue;
			}
			for (int[] offset : directions) {
				int nextHeight = current.y + offset[0];
				int nextWidth = current.x + offset[1];
				if (isAvailablePosition(nextHeight, nextWidth)) {
					// 이동할 수 있는
					if (map[nextHeight][nextWidth] == 0) {
						if (!visited[current.destroy][nextHeight][nextWidth]) {
							visited[current.destroy][nextHeight][nextWidth] = true;
							queue.add(new Position(nextHeight, nextWidth, current.cost + 1, current.destroy));
						}
					}
					// 이동할 수 없는 곳
					else {
						if (current.destroy < k) {
							if (!visited[current.destroy + 1][nextHeight][nextWidth]) {
								visited[current.destroy + 1][nextHeight][nextWidth] = true;
								queue.add(new Position(nextHeight, nextWidth, current.cost + 1, current.destroy + 1));
							}
						}
					}
				}
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

	}

	private static boolean isAvailablePosition(int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < height &&
				nextWidth >= 0 && nextWidth < width;
	}

	private static class Position {
		private int y;
		private int x;
		private int cost;
		private int destroy;

		public Position(int y, int x, int cost, int destroy) {
			this.y = y;
			this.x = x;
			this.cost = cost;
			this.destroy = destroy;
		}
	}

	private static void init() {
		height = scanner.nextInt();
		width = scanner.nextInt();
		k = scanner.nextInt();
		scanner.nextLine();
		map = new int[height][width];
		for (int h = 0; h < height; h++) {
			map[h] = Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		visited = new boolean[k + 1][height][width];
	}
}
