package 백준.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class 섬의개수 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int width = scanner.nextInt();
			int height = scanner.nextInt();
			scanner.nextLine();
			if (width == 0 && height == 0) {
				return;
			}
			int[][] map = new int[height][width];
			boolean[][] visited = new boolean[height][width];
			for (int i = 0; i < height; i++) {
				map[i] = Arrays.stream(scanner.nextLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();
			}
			int answer = 0;
			for (int h = 0; h < height; h++) {
				for (int w = 0; w < width; w++) {
					if (map[h][w] == 1 && !visited[h][w]) {
						answer++;
						DFS(map, visited, h, w);
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static void DFS(int[][] map, boolean[][] visited, int height, int width) {
		visited[height][width] = true;
		for (int hOffset = -1; hOffset <= 1; hOffset++) {
			for (int wOffset = -1; wOffset <= 1; wOffset++) {
				int nextHeight = height + hOffset;
				int nextWidth = width + wOffset;
				if (isAvailablePosition(map, nextHeight, nextWidth)) {
					if (isAvailableDistance(height, width, nextHeight, nextWidth) &&
							!visited[nextHeight][nextWidth] && map[nextHeight][nextWidth] == 1) {
						DFS(map, visited, nextHeight, nextWidth);
					}
				}
			}
		}
	}

	private static boolean isAvailablePosition(int[][] map, int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < map.length &&
				nextWidth >= 0 && nextWidth < map[0].length;
	}

	private static boolean isAvailableDistance(int currentHeight, int currentWidth, int nextHeight, int nextWidth) {
		double distance = Math.sqrt(Math.pow((nextHeight - currentHeight), 2) + Math.pow((nextWidth - currentWidth), 2));
		return distance < 2.0;
	}
}
