package 그래프.최단경로.플로이드와샬;

import java.util.Arrays;

public class 순위 {
	static int INF = 0xfffffff;

	public static void main(String[] args) {
		solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
	}

	public static int solution(int n, int[][] results) {
		int[][] map = new int[n + 1][n + 1];
		for (int row = 1; row <= n; row++) {
			for (int column = 1; column <= n; column++) {
				if (row == column) {
					map[row][column] = 0;
				} else {
					map[row][column] = INF;
				}
			}
		}
		for (int[] result : results) {
			map[result[0]][result[1]] = 1;
		}
		floyd(map, n);
		boolean[] result = new boolean[n + 1];
		Arrays.fill(result, true);
		for (int row = 1; row <= n; row++) {
			for (int column = 1; column <= n; column++) {
				if (row == column) {
					continue;
				}
				if (map[row][column] == INF && map[column][row] == INF) {
					result[row] = false;
					break;
				}
			}
		}
		int answer = 0;
		for (int idx = 1; idx <= n; idx++) {
			if (result[idx]) {
				answer++;
			}
		}
		System.out.println(answer);
		return 0;
	}

	private static void floyd(int[][] map, int n) {
		for (int midNode = 1; midNode <= n; midNode++) {
			for (int row = 1; row <= n; row++) {
				for (int column = 1; column <= n; column++) {
					if (row == midNode) {
						continue;
					}
					int cost = map[row][midNode] + map[midNode][column];
					if (map[row][column] > cost) {
						map[row][column] = cost;
					}
				}
			}
		}
	}
}