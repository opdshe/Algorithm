package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽부수고이동하기 {
	static final Scanner scanner = new Scanner(System.in);
	static int maxHeight;
	static int maxWidth;
	static int[][] map;
	static boolean[][][] visited;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		maxHeight = Integer.parseInt(st.nextToken());
		maxWidth = Integer.parseInt(st.nextToken());
		map = new int[maxHeight][maxWidth];
		visited = new boolean[2][maxHeight][maxWidth];
		for (int i = 0; i < maxHeight; i++) {
			String str = br.readLine();
			for (int j = 0; j < maxWidth; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		bfs(0, 0);
	}

	private static void bfs(int height, int width) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1, 0));

		visited[0][0][0] = true;
		int answer = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			if (current.y == maxHeight - 1 && current.x == maxWidth - 1) {
				answer = Math.min(answer, current.distance);
				continue;
			}
			for (int[] offset : directions) {
				int nextHeight = current.y + offset[0];
				int nextWidth = current.x + offset[1];
				if (isAvailablePosition(nextHeight, nextWidth)) {
					//이미 벽 부순경우
					if (current.destroyed == 1) {
						if (!visited[1][nextHeight][nextWidth] && map[nextHeight][nextWidth] == 0) {
							visited[1][nextHeight][nextWidth] = true;
							queue.offer(new Point(nextHeight, nextWidth, current.distance + 1, 1));
						}
					} else {
						if (map[nextHeight][nextWidth] == 0) {
							if (!visited[0][nextHeight][nextWidth]) {
								visited[0][nextHeight][nextWidth] = true;
								queue.offer(new Point(nextHeight, nextWidth, current.distance + 1, 0));
							}
						} else {
							if (!visited[1][nextHeight][nextWidth]) {
								visited[1][nextHeight][nextWidth] = true;
								queue.offer(new Point(nextHeight, nextWidth, current.distance + 1, 1));
							}
						}
					}
				}
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
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
