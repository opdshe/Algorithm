package 그래프.최단경로.다익스트라;

import java.util.*;

public class 최단경로3 {
	static Scanner scanner = new Scanner(System.in);
	static List<Edge>[] edges;

	public static void main(String[] args) {
		int countOfVertex = scanner.nextInt();
		int countOfEdge = scanner.nextInt();
		int start = scanner.nextInt();
		init(countOfVertex);
		for (int i = 0; i < countOfEdge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			edges[source].add(new Edge(dest, cost));
		}
		dijkstra(countOfVertex, start);
	}

	private static void dijkstra(int countOfVertex, int start) {
		int[] distance = new int[countOfVertex + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		distance[start] = 0;

		Queue<Vertex> queue = new PriorityQueue<>(Comparator.comparing(Vertex::getCost));
		queue.add(new Vertex(start, 0));
		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			if (current.cost > distance[current.idx]) {
				continue;
			}
			for (Edge edge : edges[current.idx]) {
				int cost = current.cost + edge.cost;
				if (distance[edge.dest] > cost) {
					distance[edge.dest] = cost;
					queue.add(new Vertex(edge.dest, cost));
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}

	private static void init(int countOfVertex) {
		edges = new ArrayList[countOfVertex + 1];
		for (int idx = 0; idx <= countOfVertex; idx++) {
			edges[idx] = new ArrayList<>();
		}
	}

	private static class Vertex {
		int idx;
		int cost;

		public Vertex(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int getCost() {
			return cost;
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
