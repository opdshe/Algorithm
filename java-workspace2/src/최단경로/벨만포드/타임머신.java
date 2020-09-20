package 최단경로.벨만포드;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 타임머신 {
	static List<Edge> edges = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	static final int INF = 0xfffffff;

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;

		for (int i = 0; i < M; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int weight = scanner.nextInt();
			edges.add(new Edge(source, dest, weight));
			if (source == 1) {
				if (dist[dest] > weight) {
					dist[dest] = weight;
				}
			}
		}
		bellmanFord(N, dist);
	}

	private static void bellmanFord(int N, int[] dist) {

		boolean hasCycle = false;

		for (int count = 0; count < N - 1; count++) {
			for (Edge edge : edges) {
				if (dist[edge.source] != INF && dist[edge.source] + edge.weight < dist[edge.dest]) {
					dist[edge.dest] = dist[edge.source] + edge.weight;
				}
			}
		}

		for (Edge edge : edges) {
			if (dist[edge.source] != INF && dist[edge.source] + edge.weight < dist[edge.dest]) {
				hasCycle = true;
				break;
			}
		}
		if (hasCycle) {
			System.out.println(-1);
		} else {
			for (int city = 2; city <= N; city++) {
				if (dist[city] == INF) {
					System.out.println(-1);
				} else {
					System.out.println(dist[city]);
				}
			}
		}
	}

	private static class Edge {
		private int source;
		private int dest;
		private int weight;

		public Edge(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}
}
