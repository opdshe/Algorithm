package 최단경로.다익스트라;

import java.util.*;

public class 알고스팟 {
	static Scanner scanner = new Scanner(System.in);
	static int height;
	static int width;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		width = scanner.nextInt();
		height = scanner.nextInt();
		map = new int[height][width];
		visited = new boolean[height][width];
		scanner.nextLine();
		for (int i = 0; i < height; i++) {
			map[i] = Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		search();
	}

	private static void search() {
		Queue<Position> queue = new PriorityQueue<>(Comparator.comparing((Position p) -> p.destroy));
		queue.add(new Position(0, 0, 0));
		int answer = height * width;

		while (!queue.isEmpty()) {
			Position current = queue.poll();
			if (current.y == height - 1 && current.x == width - 1) {
				answer = Math.min(answer, current.destroy);
				break;
			}
			for (int[] offset : directions) {
				int nextHeight = current.y + offset[0];
				int nextWidth = current.x + offset[1];
				if (isAvailablePosition(nextHeight, nextWidth)) {
					if (!visited[nextHeight][nextWidth]) {
						if (map[nextHeight][nextWidth] == 0) {
							visited[nextHeight][nextWidth] = true;
							queue.add(new Position(nextHeight, nextWidth, current.destroy));
						} else {
							visited[nextHeight][nextWidth] = true;
							queue.add(new Position(nextHeight, nextWidth, current.destroy + 1));
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean isAvailablePosition(int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < height &&
				nextWidth >= 0 && nextWidth < width;
	}

	private static class Position {
		private int y;
		private int x;
		private int destroy;

		public Position(int y, int x, int destroy) {
			this.y = y;
			this.x = x;
			this.destroy = destroy;
		}
	}
}
