package 그래프.최단경로.다익스트라;

import java.util.*;

public class 배달 {
	private static final int INF = Integer.MAX_VALUE;
	private static List<Edge>[] edges;

	public int solution(int N, int[][] road, int K) {
		init(N, road, K);
		return dijkstra(N, K);
	}

	private static int dijkstra(int N, int K) {
		int availableCity = 0;
		Queue<City> queue = new PriorityQueue<>(Comparator.comparing(city -> city.cost));
		queue.add(new City(1, 0));
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[1] = 0;

		while (!queue.isEmpty()) {
			City current = queue.poll();
			if (current.cost > distance[current.idx]) {
				continue;
			}
			availableCity++;
			System.out.println(current.idx);
			for (Edge edge : edges[current.idx]) {
				int cost = current.cost + edge.cost;
				if (distance[edge.dest] > cost && cost <= K) {
					distance[edge.dest] = cost;
					queue.add(new City(edge.dest, cost));
				}
			}
		}
		return availableCity;
	}

	private static void init(int N, int[][] road, int K) {
		edges = new ArrayList[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			edges[idx] = new ArrayList<>();
		}
		for (int[] ints : road) {
			edges[ints[0]].add(new Edge(ints[1], ints[2]));
			edges[ints[1]].add(new Edge(ints[0], ints[2]));
		}
	}

	private static class City {
		private int idx;
		private int cost;

		public City(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	private static class Edge {
		private int dest;
		private int cost;

		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
