package 그래프.최단경로.플루이드와샬;

public class 순위 {
	public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] map = new int[n + 1][n + 1];
		for (int[] result : results) {
			map[result[0]][result[1]] = 1;
		}

		floyd(map, n);

		for (int player = 1; player <= n; player++) {
			int win = 0;
			int lose = 0;
			for (int opponent = 1; opponent <= n; opponent++) {
				if (map[player][opponent] == 1) {
					win++;
				} else if (map[opponent][player] == 1) {
					lose++;
				}
			}
			if (win + lose == n - 1) {
				answer++;
			}
		}
		return answer;
	}

	private static void floyd(int[][] map, int n) {
		for (int mid = 1; mid <= n; mid++) {
			for (int row = 1; row <= n; row++) {
				for (int column = 1; column <= n; column++) {
					if (mid == row) {
						continue;
					}
					if (map[row][mid] == 1 && map[mid][column] == 1) {
						map[row][column] = 1;
					}
				}
			}
		}
	}
}
