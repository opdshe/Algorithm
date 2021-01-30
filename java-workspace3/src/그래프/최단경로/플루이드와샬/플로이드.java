package 그래프.최단경로.플루이드와샬;

import java.util.Scanner;

public class 플로이드 {
	static final int INF = 0xfffffff;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfCity = scanner.nextInt();
		int countOfBus = scanner.nextInt();
		int[][] map = new int[countOfCity + 1][countOfCity + 1];
		for (int row = 1; row <= countOfCity; row++) {
			for (int column = 1; column <= countOfCity; column++) {
				if (row != column) {
					map[row][column] = INF;
				}
			}
		}
		for (int i = 0; i < countOfBus; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			map[source][dest] = Math.min(map[source][dest], cost);
		}
		floyd(map, countOfCity);
	}

	private static void floyd(int[][] map, int countOfCity) {
		for (int mid = 1; mid <= countOfCity; mid++) {
			for (int source = 1; source <= countOfCity; source++) {
				for (int dest = 1; dest <= countOfCity; dest++) {
					if (mid == source) {
						continue;
					}
					int cost = map[source][mid] + map[mid][dest];
					if (map[source][dest] > cost) {
						map[source][dest] = cost;
					}
				}
			}
		}

		for (int row = 1; row <= countOfCity; row++) {
			for (int column = 1; column <= countOfCity; column++) {
				System.out.print(map[row][column] == INF ? 0 : map[row][column]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
