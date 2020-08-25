package 백준.dfs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 빙산 {
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, 1},
			new int[]{0, -1}
	);
	static int height;
	static int width;
	static boolean[][] visited;
	static int[][] map;
	static int[][] meltingCount;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		height = scanner.nextInt();
		width = scanner.nextInt();
		map = new int[height][width];
		meltingCount = new int[height][width];
		visited = new boolean[height][width];
		scanner.nextLine();

		int countOfIceberg = 0;
		int countOfMeltedIceberg = 0;

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				int value = scanner.nextInt();
				map[h][w] = value;
				if (value > 0) {
					countOfIceberg++;
				}
			}
		}
		int time = 1;
		while (countOfIceberg - countOfMeltedIceberg > 0) {
			boolean needToBeCheck = false;
			for (int h = 0; h < height; h++) {
				for (int w = 0; w < width; w++) {
					int aroundWater = getAroundWater(h, w);
					meltingCount[h][w] = aroundWater;
				}
			}

			for (int h = 0; h < height; h++) {
				for (int w = 0; w < width; w++) {
					map[h][w] -= meltingCount[h][w];
					if (map[h][w] <= 0) {
						countOfMeltedIceberg++;
						needToBeCheck = true;
						map[h][w] = 0;
					}
				}
			}
			if (needToBeCheck) {
				int count = getCount();
				if (count > 1) {
					break;
				} else {
					visited = new boolean[height][width];
				}
			}
			time++;
		}
		if (countOfIceberg == countOfMeltedIceberg) {
			time = 0;
		}
		System.out.println(time);
	}

	private static int getCount() {
		int count = 0;
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				if (map[h][w] > 0 && !visited[h][w]) {
					count++;
					if (count > 1) {
						return 2;
					}
					DFS(h, w);

				}
			}
		}
		return count;
	}

	private static void DFS(int height, int width) {
		visited[height][width] = true;
		for (int[] offset : directions) {
			int nextHeight = height + offset[0];
			int nextWidth = width + offset[1];
			if (isAvailablePosition(nextHeight, nextWidth)) {
				if (!visited[nextHeight][nextWidth] && map[nextHeight][nextWidth] > 0) {
					DFS(nextHeight, nextWidth);
				}
			}
		}
	}


	private static int getAroundWater(int height, int width) {
		int count = 0;
		for (int[] offset : directions) {
			int nextHeight = height + offset[0];
			int nextWidth = width + offset[1];
			if (isAvailablePosition(nextHeight, nextWidth)) {
				if (map[nextHeight][nextWidth] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isAvailablePosition(int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < height &&
				nextWidth >= 0 && nextWidth < width;
	}
}
