package 그래프.최단경로.플로이드와샬;

import java.util.Scanner;

public class 백양로브레이크 {
	static Scanner scanner = new Scanner(System.in);
	static int[][] map;
	static int vertex;
	static int edge;
	static int[] visited;
	static int INF;

	public static void main(String[] args) {
		vertex = scanner.nextInt();
		edge = scanner.nextInt();
		map = new int[vertex + 1][vertex + 1];
		INF = vertex * vertex;
		for (int i = 1; i <= vertex; i++) {
			for (int j = 1; j <= vertex; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < edge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int way = scanner.nextInt();
			if (way == 1) {
				map[dest][source] = 0;
				map[source][dest] = 0;
			} else {
				map[source][dest] = 0;
				map[dest][source] = 1;
			}
		}

		floyd();

		int testCase = scanner.nextInt();
		for (int i = 0; i < testCase; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			System.out.println(map[source][dest]);
		}
	}

	private static void floyd() {
		for (int middleNode = 1; middleNode <= vertex; middleNode++) {
			for (int h = 1; h <= vertex; h++) {
				for (int w = 1; w <= vertex; w++) {
					if (h == middleNode) {
						continue;
					}
					if (map[h][w] > map[h][middleNode] + map[middleNode][w]) {
						map[h][w] = map[h][middleNode] + map[middleNode][w];
					}
				}
			}
		}
	}
}
