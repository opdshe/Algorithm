package 테스트;

import java.util.Arrays;
import java.util.Scanner;

public class 행렬경로재귀 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] map = new int[N][N];
		int[][] cache = initCache(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		System.out.println(getMinimumDistance(map, cache, N - 1, N - 1));
		for (int i = 0; i < N; i++) System.out.println(Arrays.toString(cache[i]));

	}

	private static int getMinimumDistance(int[][] map, int[][] cache, int height, int width) {
		if (cache[height][width] != -1) {
			return cache[height][width];
		}
		if (height == 0 && width == 0) {
			cache[height][width] = map[height][width];
		} else if (height == 0) {
			cache[height][width] = getMinimumDistance(map, cache, height, width - 1) + map[height][width];
		} else if (width == 0) {
			cache[height][width] = getMinimumDistance(map, cache, height - 1, width) + map[height][width];
		} else {
			cache[height][width] = Math.min(getMinimumDistance(map, cache, height - 1, width) + map[height][width],
					getMinimumDistance(map, cache, height, width - 1) + map[height][width]);
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
}
