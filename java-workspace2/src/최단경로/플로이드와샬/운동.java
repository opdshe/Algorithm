package 최단경로.플로이드와샬;

import java.util.Arrays;
import java.util.Scanner;

public class 운동 {
	static final int INF = 0xfffffff;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int vertex = scanner.nextInt();
		int edge = scanner.nextInt();
		int[][] graph = new int[vertex + 1][vertex + 1];
		for (int i = 1; i <= vertex; i++) {
			Arrays.fill(graph[i], INF);
		}
		for (int i = 0; i < edge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			graph[source][dest] = scanner.nextInt();
		}

		floyd(graph);

		int answer = INF;
		for (int i = 1; i <= vertex; i++) {
			if (graph[i][i] != INF) {
				answer = Math.min(answer, graph[i][i]);
			}

		}
		System.out.println(answer == INF ? -1 : answer);
	}

	private static void floyd(int[][] graph) {
		int vertex = graph.length - 1;
		for (int middleNode = 1; middleNode <= vertex; middleNode++) {
			for (int height = 1; height <= vertex; height++) {
				for (int width = 1; width <= vertex; width++) {
					graph[height][width] = Math.min(graph[height][width], graph[height][middleNode] + graph[middleNode][width]);
				}
			}
		}
	}
}
