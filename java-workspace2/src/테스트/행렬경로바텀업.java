package 테스트;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 행렬경로바텀업 {
	static int[][] map;
	static int[][] cache;
	static int[][] path;
	static int N;
	static Stack<int[]> pathStack = new Stack<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		map = new int[N][N];
		cache = initCache(N);
		path = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		System.out.println(getMinimumDistance(N - 1, N - 1));
		addPath(N - 1, N - 1);
		while (!pathStack.isEmpty()) {
			int[] position = pathStack.pop();
			System.out.println(Arrays.toString(position));
		}
	}

	private static int getMinimumDistance(int height, int width) {
		for (int h = 0; h < N; h++) {
			for (int w = 0; w < N; w++) {
				if (h == 0 && w == 0) {
					cache[h][w] = map[h][w];
				} else if (h == 0) {
					cache[h][w] = cache[h][w - 1] + map[h][w];
					path[h][w] = 2;
				} else if (w == 0) {
					cache[h][w] = cache[h - 1][w] + map[h][w];
					path[h][w] = 1;
				} else {
					int upper = cache[h - 1][w];
					int left = cache[h][w - 1];
					if (upper < left) {
						cache[h][w] = upper + map[h][w];
						path[h][w] = 1;
					} else {
						cache[h][w] = left + map[h][w];
						path[h][w] = 2;
					}
				}
			}
		}
		return cache[height][width];
	}

	private static int[][] initCache(int N) {
		int[][] cache = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cache[i][j] = -1;
			}
		}
		return cache;
	}

	private static void addPath(int height, int width) {
		pathStack.add(new int[]{height, width});
		if (path[height][width] == 1) {
			addPath(height - 1, width);
		} else if (path[height][width] == 2) {
			addPath(height, width - 1);
		}
	}
}
