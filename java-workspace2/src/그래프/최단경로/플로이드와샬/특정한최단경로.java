package 그래프.최단경로.플로이드와샬;

import java.util.Scanner;

public class 특정한최단경로 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int vertex = scanner.nextInt();
		int edge = scanner.nextInt();
		int INF = 2000;
		int[][] adj = new int[vertex + 1][vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			for (int j = 1; j <= vertex; j++) {
				if (i == j) {
					adj[i][j] = 0;
				} else {
					adj[i][j] = 0xfffffff;
				}
			}
		}

		for (int i = 0; i < edge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int weight = scanner.nextInt();
			adj[source][dest] = weight;
			adj[dest][source] = weight;
		}
		int firstMidNode = scanner.nextInt();
		int secondMidNode = scanner.nextInt();
		floyd(adj);
		int firstFirst = adj[1][firstMidNode] + adj[firstMidNode][secondMidNode] + adj[secondMidNode][vertex];
		int secondFirst = adj[1][secondMidNode] + adj[secondMidNode][firstMidNode] + adj[firstMidNode][vertex];

		int answer = Math.min(firstFirst, secondFirst);
		System.out.println(answer >= 0xfffffff ? -1 : answer);

	}

	private static void floyd(int[][] adj) {
		int vertex = adj.length - 1;
		for (int midNode = 1; midNode <= vertex; midNode++) {
			for (int height = 1; height <= vertex; height++) {
				for (int width = 1; width <= vertex; width++) {
					if (height == midNode) {
						continue;
					}
					adj[height][width] = Math.min(adj[height][width], adj[height][midNode] + adj[midNode][width]);
				}
			}
		}
	}
}
