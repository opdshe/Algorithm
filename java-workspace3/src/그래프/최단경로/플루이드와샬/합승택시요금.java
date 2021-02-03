package 그래프.최단경로.플루이드와샬;

public class 합승택시요금 {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
				{2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		int[][] map = new int[n + 1][n + 1];
		for (int row = 1; row <= n; row++) {
			for (int column = 1; column <= n; column++) {
				if (row != column) {
					map[row][column] = INF;
				}
			}
		}
		for (int[] fare : fares) {
			map[fare[0]][fare[1]] = fare[2];
			map[fare[1]][fare[0]] = fare[2];
		}
		floyd(map, n);
		for (int mid = 1; mid <= n; mid++) {
			answer = Math.min(answer, map[s][mid] + map[mid][a] + map[mid][b]);
		}
		return answer;
	}

	private static void floyd(int[][] map, int n) {
		for (int mid = 1; mid <= n; mid++) {
			for (int row = 1; row <= n; row++) {
				for (int column = 1; column <= n; column++) {
					if (row == mid) {
						continue;
					}
					if (map[row][mid] != INF && map[mid][column] != INF) {
						int cost = map[row][mid] + map[mid][column];
						map[row][column] = Math.min(map[row][column], cost);
					}
				}
			}
		}
	}
}
