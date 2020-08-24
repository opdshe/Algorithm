package 백준.dfs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 알파벳 {
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, 1},
			new int[]{0, -1}
	);
	static boolean[] visited = new boolean[26];
	static int R;
	static int C;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		R = scanner.nextInt();
		C = scanner.nextInt();
		char[][] map = new char[R][C];
		scanner.nextLine();
		for (int i = 0; i < R; i++) {
			map[i] = scanner.nextLine()
					.toCharArray();
		}
		char value = map[0][0];
		visited[value - 65] = true;
		DFS(map, 0, 0, 1);
		System.out.println(answer);
	}

	private static void DFS(char[][] map, int height, int width, int count) {
		answer = Math.max(answer, count);

		for (int[] offset : directions) {
			int nextHeight = height + offset[0];
			int nextWidth = width + offset[1];
			if (isAvailablePosition(nextHeight, nextWidth)) {
				char value = map[nextHeight][nextWidth];
				if (!visited[value - 65]) {
					visited[value - 65] = true;
					DFS(map, nextHeight, nextWidth, count + 1);
					visited[value - 65] = false;
				}
			}
		}

	}


	private static boolean isAvailablePosition(int nextHeight, int nextWidth) {
		return nextHeight >= 0 && nextHeight < R &&
				nextWidth >= 0 && nextWidth < C;
	}
}
