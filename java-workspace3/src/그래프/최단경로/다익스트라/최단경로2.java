package 그래프.최단경로.다익스트라;

import java.io.IOException;
import java.util.*;

public class 최단경로2 {
	static final int INF = Integer.MAX_VALUE;
	static Scanner scanner = new Scanner(System.in);
	static List<Edge>[] adjacent;

	public static void main(String[] args) throws IOException {
		int countOfVertex = scanner.nextInt();
		int countOfEdge = scanner.nextInt();
		int start = scanner.nextInt();
		scanner.nextLine();
		adjacent = new ArrayList[countOfVertex + 1];
		for (int idx = 1; idx <= countOfVertex; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int e = 0; e < countOfEdge; e++) {
			int[] edgeInfo = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			adjacent[edgeInfo[0]].add(new Edge(edgeInfo[1], edgeInfo[2]));
		}
		dijkstra(start, countOfVertex);
	}

	private static void dijkstra(int start, int countOfVertex) {
		Queue<Vertex> queue = new PriorityQueue<>(Comparator.comparing(vertex -> vertex.cost));
		int[] distances = new int[countOfVertex + 1];
		Arrays.fill(distances, INF);
		distances[start] = 0;
		queue.add(new Vertex(start, 0));

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			if (distances[current.idx] < current.cost) {
				continue;
			}
			for (Edge edge : adjacent[current.idx]) {
				int cost = current.cost + edge.cost;
				if (distances[edge.dest] > cost) {
					distances[edge.dest] = cost;
					queue.add(new Vertex(edge.dest, cost));
				}
			}
		}

		for (int idx = 1; idx <= countOfVertex; idx++) {
			System.out.println(distances[idx] == INF ? "INF" : distances[idx]);
		}
	}

	private static class Vertex {
		int idx;
		int cost;

		public Vertex(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	private static class Edge {
		int dest;
		int cost;

		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
